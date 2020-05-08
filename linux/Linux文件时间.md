# Linux文件时间

Linux文件存在4种时间：stat file，查看文件的详细属性，包括时间属性

- 访问时间：atime ，查看内容
- 修改时间：mtime，修改内容
- 改变事件：ctime，文件属性，比如权限
- 删除事件：dtime，文件被删除的时间

```
[root@www myTest]# ls -l  # 查看的是文件的修改时间
total 8
-rw-r--r--. 1 root root  13 May  8 16:45 a.txt
-rw-r--r--. 1 root root 688 May  8 17:10 test.txt

[root@www myTest]# stat a.txt 
  File: ‘a.txt’
  Size: 13        	Blocks: 8          IO Block: 4096   regular file
Device: fd00h/64768d	Inode: 2957697     Links: 1
Access: (0644/-rw-r--r--)  Uid: (    0/    root)   Gid: (    0/    root)
Context: unconfined_u:object_r:usr_t:s0
Access: 2020-05-08 16:47:49.868375280 +0800
Modify: 2020-05-08 16:45:47.498382049 +0800
Change: 2020-05-08 16:45:47.500382049 +0800
 Birth: -
```

注：RHEL6开始relatime，atime延迟修改，必须满足其中一个条件才进行修改：

1. 自上次atime修改后，已达到86400s
2. 发生写操作时