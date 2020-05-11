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

