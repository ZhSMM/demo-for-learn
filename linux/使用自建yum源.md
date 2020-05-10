# 使用自建yum源

获取rpm包：手动更新 或 计划任务自动更新

手动获取rpm包：

- yum install xx --downloadonly：从官方下载安装包
- yum update

1. 配置防火墙
   - fireware-cmd --permanent --add-service=ftp
   - fireware-cmd --reload
2. 关闭SELinux：
   - setenforce 0
   - vim /etc/sysconfig/selinux ： SELINUX = disabled
3. FTP：
   - yum -y install vsftpd
   - systemctl start vsftpd
   - systemctl enable vsftpd

yum软件包缓存目录：

- /etc/yum.conf：

  ``` 
  # 启动yum开启缓存
  cachedir=/var/cache/yum/$basearch/$releasever
  keepcache = 1
  debuglevel = 2
  ```

- /var/cache/yum/x86_64/7/base/packages
- /var/cache/yum/x86_64/7/updates/packages
- /var/cache/yum/x86_64/7/extras/packages

提供update：需要保证环境一致（1、最小化安装；2、update）

- 配置yum缓存

- yum clean all：清除缓存
- yum -y update
- mkdir /var/ftp/update (/var/ftp：ftp共享目录)
- find /var/cache/yum/x86_64/7/ -iname "*.rpm" -exec cp -rf {} /var/ftp/update \; 
- yum -y install createrepo
- createrepo /var/ftp/update

