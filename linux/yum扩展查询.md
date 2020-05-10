# yum扩展查询

### 扩展查询

1. 从包名和包描述中查询带有关键字Chinese的包
   - yum list | grep chinese：只关注软件包的名称
   - yum search chinese：关注软件包的名称和描述
2. 查找/etc/vsftpd/vsftpd.conf由哪个包提供：
   - yum provides /etc/vsftpd/vsftpd.conf
3. 查找vsftpd.conf由哪个包提供：
   - yum provides */vsftpd.conf
4. 查找命令gnuplot由哪个包提供
   - yum provides gnuplot