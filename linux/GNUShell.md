# GNU Shell

Shell是系统的用户界面，提供了用户与内核进行交互操作的一种接口。它接收用户输入的命令并把它送入内核去执行。

实际上Shell是一个命令解释器，它解释由用户输入的命令并且把它们送到内核。不仅如此，Shell有自己的编程语言用于对命令的编辑，它允许用户编写由shell命令组成的程序。Shell编程语言具有普通编程语言的很多特点，比如它也有循环结构和分支控制结构等，用这种编程语言编写的Shell程序与其他应用程序具有同样的效果。

### Shell入门

#### 建立和运行shell程序

什么是shell程序呢? 

- 简单的说shell程序就是一个包含若干行shell或者[linux](https://baike.baidu.com/item/linux)命令的文件；

- 像编写高级语言的程序一样，编写一个shell程序需要一个文本编辑器，如vi等；

- 在文本编辑环境下，依据shell的语法规则，输入一些shell/linux命令行，形成一个完整的程序文件。

使用shell的两种方式：

- shell窗口输入命令，低效率；
- 运行shell script（shell 脚本，*.sh），效率高；

执行shell script的三种方法：

- chmod +x file（在/etc/profile中，加入export PATH=${PATH}:~/yourpath，就可以在命令行下直接运行，像执行普通命令一样）

- sh file

- ./file

- source file

在编写shell时，第一行一定要指明系统需要那种shell解释你的shell程序，如：#! /bin/bash,#! /bin/csh,/bin/tcsh，还是#! /bin/pdksh

#### bash shell提示符

快捷键操作：

- CTRL + L ：清屏
- CTRL + Shift + + ：放大bash界面
- CTRL + - ：缩小bash界面

```
[root@www ~]# echo $PS1  # 输出当前提示符
[\u@\h \W]\$

[root@www ~]# date   # 输出日期时间
Fri May  8 11:29:52 CST 2020

[root@www ~]# whoami  # 查看当前登录用户
root

[root@www ~]# bash -version  # 查看bash版本
GNU bash, version 4.2.46(2)-release (x86_64-redhat-linux-gnu)
Copyright (C) 2011 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>

This is free software; you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.
```

#### bash shell语法

shell语法：命令 + 选项 + 参数

- 命令：整条shell命令的主体
- 选项：会影响微调命令的行为
- 参数：命令作用的对象

在shell中 ls -a 输出时，**蓝色**显示的为目录，黑色为文件，以 `.` 开头的为隐藏文件。

#### bash基本特性

1. 自动补全 ： tab键

2. 快捷键：

   - CTRL + C ：终止当前程序
   - CTRL + D ：退出shell，等效于 exit
   - CTRL + L ：清屏
   - CTRL + A ：光标移到命令行的最前端
   - CTRL + E ：光标移动命令行的后端
   - CTRL + U ：删除光标前所有字符
   - CTRL + K ：删除光标后所有字符
   - CTRL + R ：搜索历史命令，利用关键词
   - ALT + . ：引用上一条命令的最后一个参数 ，等价于 !$
   - ESC + . ：引用上一条命令的最后一个参数 ，等价于 !$

3. 历史命令：

   - 查看历史命令：history

   - 选择：光标上下键

   - CTRL + R 快捷键

   - `! + 20`：执行历史命令

     `! + 字符串`：执行历史命令

     `!$`：引用上一条命令的最后一个参数

4. 命令别名

   - alias 别名 = "命令" ：临时的，仅在当前shell生效

   - unalias 别名：取消这个别名
   - alias：查看当前系统定义的别名
   - type -a "命令" ：查看当前命令是否是别名
   - 相同命令别名优先，如 ls ，可以使用 \ls 跳过别名

   永久别名：

   - `gedit /etc/bashrc` 

5. 查看帮助：

   1. 命令  --help
   2. man手册