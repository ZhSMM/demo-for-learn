# Isof恢复文件

Isof（list open files）：列出进程打开的文件

1. 查看打开文件message的进程：lsof | grep message   # var/log/messsages

   ```
   [root@www ~]# lsof|grep message
   abrt-watc   741                root    4r      REG              253,0     12508   68925916 /var/log/messages
   rsyslogd   1205                root    6w      REG              253,0     12571   68925913 /var/log/messages (deleted)
   in:imjour  1205 1215           root    6w      REG              253,0     12571   68925913 /var/log/messages (deleted)
   rs:main    1205 1218           root    6w      REG              253,0     12571   
   68925913 /var/log/messages (deleted)
   
   68925913：文件block
   741：PID
   root：用户
   4：fd
   r：只读
   w：读写
   ```

2. 误删除某个进程正在使用的文件后在恢复：

   - rm -rf /var/log/messages

   - losf | grep message：找到正在使用此文件的文件描述符

   - cp /proc/1205/fd/6 /var/log/messages：复制回源文件

     less /proc/1205/fd/6 >/var/log/messages：重定向

3. 配置文件一般进程只是在启动时读取，所以进程并不是时刻打开文件的，所以不能用此方法恢复。日志文件一般是实时读取的，可以恢复。

