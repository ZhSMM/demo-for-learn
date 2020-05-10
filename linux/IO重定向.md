# I/O重定向

标准输入、标准输出、标准错误

FD：file description，文件描述符，或者说 Process I/O channels，进程使用文件描述符来管理打开的文件。

- $$：当前进程的pid
- /proc/$$/fd：当前进程打开的文件

- 0：stdin，标准输入，键盘
- 1：stdout，标准输出，终端
- 2：stderr，标准错误，终端

输出重定向：

- ll 1> 1.txt：输出重定向
- ll 0< /etc：输入重定向

重定向：

- `>`：重定向覆盖
- `>>`：重定向追加
- &>：混合输出，既包含正确输出，也包含错误输出

特殊设备：

- /dev/null：空设备
- `>/dev/null`：清除
- 如果/dev/null设备被删，
  - 手动创建： `mknod -m 666 /dev/null c 1 3`
  - 重启

输入重定向：

- dd if=/dev/zero of=/file.txt bs=1M count=20

- dd </dev/zero >/file.txt bs=1M count=20

- mysql -uroot -p1234 < bt.sql

- 定时任务：at 起始时间 终止时间 

  at now +2 min < at.txt  ：CTRL+D终止

普通文件和系统文件：

```
[root@www ~]# ll /dev/null /dev/zero /dev/sda /etc/hosts
crw-rw-rw-. 1 root root 1, 3 May  9 09:32 /dev/null
brw-rw----. 1 root disk 8, 0 May  9 09:32 /dev/sda
crw-rw-rw-. 1 root root 1, 5 May  9 09:32 /dev/zero
-rw-r--r--. 1 root root  158 Jun  7  2013 /etc/hosts
```

- 普通文件存在文件大小

- 设备文件在文件大小处显示的是：主设备号，从设备号

  - 主设备号相同：表示为同一种设备，或者说kernel使用相同的模块
  - 从设备号：同一类型设备中的一个序号

- mknod ：建立块设备或字符设备

  mkmod [options] name type major minor

  options：

  - `-m`：文件权限控制

  type：

  - b：块设备，有缓存
  - c：字符设备，无缓存
  - p：管道设备

- 管道输入，一次多行输入：
  - cat > 1.txt：ctrl+d结束
  - cat > 1.txt <<-EOF：定义结束符，输入EOF结束输入，加-可以忽略空格键
- subshell：
  - （ls）：（）包裹会在子shell中执行
  - 如果某些命令会影响当前shell，可以在subshell中运行



