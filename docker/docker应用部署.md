# docker应用部署

### mysql部署

在docker容器中部署MySQL，并通过外部mysql客户端操作mySQL Server：

实现步骤：

1. 搜索MySQL镜像；

2. 拉取镜像；

3. 创建容器：

   ```
   # 在/root 目录下创建mysql目录用于存储mysql的数据信息
   mkdir ~/mysql
   cd ~/mysql
   
   # 创建容器
   docker run -id \
   -p 3307：3306 \   # 端口映射，将容器端口3306映射到宿主机端口3307
   --name=c_mysql \   
   -v $PWD/conf:/etc/mysql/conf.d \   # 将主机当前目录下的conf/my.cnf挂载到容器
   -v $PWD/logs:/logs \  # 日志
   -v $PWD/data:/var/lib/mysql \  # 数据目录
   -e MYSQL_ROOT_PASSWORD=1234 \  # 初始化root用户密码
   mysql:5.6
   ```

4. 操作容器中的MySQL

问题：

- 容器内的网络服务和外部机器不能直接通信；
- 外部机器可以和宿主机直接通信；
- 宿主机和容器可以直接通信；

端口映射：当容器中的网络服务需要被外部机器访问时，可以将容器中提供服务的端口映射到宿主机的端口上，外部机器访问宿主机的该端口，从而间接访问容器的服务。

### tomcat部署

```
docker run -id --name=c_tomcat \
-p 8080:8080 \
-v $PWD:/usr/local/tomcat/webapps \ #
tomcat
```

### nginx部署

```
docker run -id --name=c_nginx \
-p 80:80 \
-v $PWD/conf/nginx.conf:/etc/nginx/nginx.conf \
-v $PWD/logs:/var/log/nginx \
-v $PWD/html:/usr/share/nginx/html \
nginx
```

### redis部署

```
# 创建容器，设置端口映射
docker run -id --name=c_redis -p 6379:6379 redis:5.0
# 使用外部机器连解redis -h:主机IP -p:端口 
./redis-cli.exe -h 192.168.149.135 -p 6379
```

