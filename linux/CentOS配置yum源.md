# CentOS配置yum源

1. 备份配置文件：

   ```
   cp -a /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.bak
   
   // 或者直接改名
   mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.bak
   ```

2. 下载新的**CentOS-Base.repo**文件到**/etc/yum.repos.d/**目录下，选择CentOS版本：

   如阿里云的yum源：

   ```
   wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
   ```

   华为的yum源：

   ```
   wget -O /etc/yum.repos.d/CentOS-Base.repo https://repo.huaweicloud.com/repository/conf/CentOS-7-reg.repo
   ```

3. 执行**yum clean all**清除原有yum缓存。

4. 执行**yum makecache**（刷新缓存）或者**yum repolist all**（查看所有配置可以使用的文件，会自动刷新缓存）。

### 参考

- 阿里云镜像站：[CentOS](https://developer.aliyun.com/mirror/centos)