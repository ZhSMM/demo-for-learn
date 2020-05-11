# docker私有仓库

### 私有仓库搭建

1. 拉取私有仓库：`docker pull registry`
2. 启动私有仓库：`docker run --name docker-registry -d -p 5000:5000 registry`

3. 访问：`curl -X GET http://127.0.0.1:5000/v2/_catalog`

### 访问

1. 修改daemon.json：`vim /etc/docker/daemon.json`
2. 在上述文件添加一个key，用来信任私有仓库：`{"insecure-registries": ["私有仓库ip：5000"]}`

3. 重启docker：`systemctl restart docker` and `docker start registry`
4. 标记镜像为私有仓库的镜像：`docker tag centos:7 私有仓库服务器IP：5000/centos：7`
5. 上传标记的镜像：`docker push 私有仓库服务器IP：5000/centos：7`

