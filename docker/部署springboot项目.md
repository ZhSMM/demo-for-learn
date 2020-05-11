# 部署springboot项目

需求：定义dockerfile，发布springboot项目。

实现步骤：

1. 定义父镜像：`From java:8`
2. 定义作者信息：`MAINTAINER author <email>`
3. 将jar包添加到容器：`ADD springboot.jar app.jar`
4. 定义容器启动执行的命令：`CMD java -jar app.jar`
5. 通过dockerfile构建镜像：`docker build -f dockerfile 文件路径 -t 镜像名称：版本`