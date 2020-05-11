# Docker命令

### 概念

- 镜像（image）：Docker镜像，相当于一个root文件系统；
- 容器（Container）：镜像和容器的关系，就像是面向对象程序设计的类和对象一样。镜像是静态的定义，容器是镜像运行的实体。容器可以被创建、启动、停止、删除、暂停等；

### docker daemon命令

- 启动docker：`systemctl start docker`
- 查看docker服务状态：`systemctl status docker`
- 关闭docker： `systemctl stop docker`
- 重启docker服务：`systemctl restart docker`
- 开机启动docker：`systemctl enable docker`

### docker镜像命令

搜索报错：`Error response from daemon: Get https://index.docker.io/v1/search?q=redis&n=25: net/http: TLS handshake timeout`

解决措施：更正服务器DNS配置：`vi /etc/resolv.conf`，改为：

```
nameserver 8.8.8.8
nameserver 8.8.8.4
```

重启网络服务：`systemctl restart network`

- 查看镜像：`docker images`
- 查看所有镜像id：`docker images -q`
- 搜索镜像：`docker search [image]`

- 下载镜像：`docker pull [image]:tag`
- 删除镜像：`docker rmi [image-id]`
- 到官网搜索镜像：[redis镜像](https://hub.docker.com/_/redis)

### docker容器相关命令

- 查看运行中的容器：`docker ps`
- 查看到所有容器：`docker ps -a`
- 创建容器：`docker run -it --name=c1 centos:7 /bin/bash`
  - -i：保持容器运行，通常与-t同时使用，加入-it这两个参数后，容器创建自动进入容器中，退出容器后，容器自然关闭；
  - -t：为容器创建一个伪输入终端，通常与-i连用；
  - -d：后台运行创建容器，容器创建后需要使用docker exec 进入容器，退出后，容器不关闭；
  - -it：交互式容器；
  - -id：守护式容器；
  - --name：为容器命名；
- 退出容器：exit
- 进入容器：`docker exec -it [容器名] /bin/bash`
- 启动容器：`docker start [容器名]`
- 停止容器：`docker stop [容器名]`
- 删除容器：`docker rm [容器名]`
- 删除所有容器：`docker rm "docker ps -aq"`
- 查看容器信息：`docker inspect [容器名]`

