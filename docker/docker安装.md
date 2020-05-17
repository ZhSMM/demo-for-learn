# docker安装

### 使用Xshell连接linux服务端：

1. 查看Linux内核版本：`uname -r` (docker要求CentOS系统的内核版本高于3.10)
2. 升级软件包及内核（可选）：`yum update`

### docker

#### 概述

Docker是一种容器技术，用于解决软件跨环境迁移问题。官网：[https://www.docker.com/](https://www.docker.com/)

- Docker是一个开源的应用容器引擎；
- 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，然后发布到任何流行的Linux机器上；
- 容器是完全的沙箱机制，相互隔离；
- 容器性能开销极低；
- Docker从17.03版本后分CE（Community Edition：社区版）和EE（Enterprise Edition：企业版）

Docker CE 是免费的 Docker 产品的新名称，Docker CE 包含了完整的 Docker 平台，非常适合开发人员和运维团队构建容器 APP。

#### 阿里云镜像安装docker

Ubuntu 14.04/16.04（使用 apt-get 进行安装）：

```
# step 1: 安装必要的一些系统工具
sudo apt-get update
sudo apt-get -y install apt-transport-https ca-certificates curl software-properties-common
# step 2: 安装GPG证书
curl -fsSL https://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | sudo apt-key add -
# Step 3: 写入软件源信息
sudo add-apt-repository "deb [arch=amd64] https://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable"
# Step 4: 更新并安装Docker-CE
sudo apt-get -y update
sudo apt-get -y install docker-ce

# 安装指定版本的Docker-CE:
# Step 1: 查找Docker-CE的版本:
# apt-cache madison docker-ce
#   docker-ce | 17.03.1~ce-0~ubuntu-xenial | https://mirrors.aliyun.com/docker-ce/linux/ubuntu xenial/stable amd64 Packages
#   docker-ce | 17.03.0~ce-0~ubuntu-xenial | https://mirrors.aliyun.com/docker-ce/linux/ubuntu xenial/stable amd64 Packages
# Step 2: 安装指定版本的Docker-CE: (VERSION例如上面的17.03.1~ce-0~ubuntu-xenial)
# sudo apt-get -y install docker-ce=[VERSION]
```



CentOS 7：

```
# step 1: 安装必要的一些系统工具
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
# Step 2: 添加软件源信息
sudo yum-config-manager --add-repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
# Step 3: 更新并安装Docker-CE
sudo yum makecache fast
sudo yum -y install docker-ce
# Step 4: 开启Docker服务
sudo service docker start

# 注意：
# 官方软件源默认启用了最新的软件，您可以通过编辑软件源的方式获取各个版本的软件包。例如官方并没有将测试版本的软件源置为可用，您可以通过以下方式开启。同理可以开启各种测试版本等。
# vim /etc/yum.repos.d/docker-ee.repo
#   将[docker-ce-test]下方的enabled=0修改为enabled=1
#
# 安装指定版本的Docker-CE:
# Step 1: 查找Docker-CE的版本:
# yum list docker-ce.x86_64 --showduplicates | sort -r
#   Loading mirror speeds from cached hostfile
#   Loaded plugins: branch, fastestmirror, langpacks
#   docker-ce.x86_64            17.03.1.ce-1.el7.centos            docker-ce-stable
#   docker-ce.x86_64            17.03.1.ce-1.el7.centos            @docker-ce-stable
#   docker-ce.x86_64            17.03.0.ce-1.el7.centos            docker-ce-stable
#   Available Packages
# Step2: 安装指定版本的Docker-CE: (VERSION例如上面的17.03.0.ce.1-1.el7.centos)
# sudo yum -y install docker-ce-[VERSION]
```

#### 安装

1. 删除旧版本docker：

   ```
    sudo yum remove docker \
                     docker-client \
                     docker-client-latest \
                     docker-common \
                     docker-latest \
                     docker-latest-logrotate \
                     docker-logrotate \
                     docker-engine
   ```

2. yum包更新到最新：`yum update`

3. 安装需要的软件包，`yum-util`提供`yum-config-manager`功能，另外两个是`devicemapper`驱动依赖的：`yum install -y yum-utils device-mapper-persistent-data lvm2`

4. 设置yum源：

   `yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo`

5. 列出并排序您存储库中可用的版本，此示例按版本号（从高到低）对结果进行排序：`yum list docker-ce --showduplicates | sort -r`

6. 安装docker：`yum install -y docker-ce`

7. 查看docker版本，验证是否验证成功：`docker -v`

8. 启动docker：`systemctl start docker`

9. 设为开机启动：`systemctl enable docker`

10. 停止docker：`systemctl stop docker`

### 配置镜像站

##### [DaoCloud](https://dashboard.daocloud.io) 

daocloud.io免费注册用户，点击顶部菜单“加速器”，使用一行命令配置加速器并重启docker。

##### [阿里云镜像](https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors)

### docker使用

- 在docker hub查找镜像：`docker search +[镜像名]` 
- 拉取镜像：`docker pull +[镜像名]:tag`
- 查看docker镜像：`docker images`

