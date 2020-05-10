# type stat file

type：查看命令类型，例如该命令是alias，还是内置命令，还是某个文件

```
[root@www usr]# type ll
ll is aliased to `ls -l --color=auto'

[root@www usr]# type ls
ls is aliased to `ls --color=auto'

[root@www usr]# type cd
cd is a shell builtin   # builtin 内置命令

[root@www usr]# type for
for is a shell keyword  # keyword 关键字

[root@www usr]# type useradd
useradd is /usr/sbin/useradd

[root@www usr]# type -a ls  # -a 列出该命令所有类型
ls is aliased to `ls --color=auto'
ls is /usr/bin/ls
```

file：查看文件类型，例如是文本文件、二进制文件、管道文件、设备文件、链接文件

```
[root@www usr]# file /etc/hostname
/etc/hostname: ASCII text
[root@www usr]# file /dev/sda
/dev/sda: block special
```

stat：查看文件的属性，例如文件名称，大小，权限，atime，ctime，mtime

```
[root@www usr]# stat /dev/sda
  File: ‘/dev/sda’
  Size: 0         	Blocks: 0          IO Block: 4096   block special file
Device: 5h/5d	Inode: 1812        Links: 1     Device type: 8,0
Access: (0660/brw-rw----)  Uid: (    0/    root)   Gid: (    6/    disk)
Context: system_u:object_r:fixed_disk_device_t:s0
Access: 2020-05-08 11:26:57.622999661 +0800
Modify: 2020-05-08 11:26:54.866999813 +0800
Change: 2020-05-08 11:26:54.866999813 +0800
 Birth: -
```

