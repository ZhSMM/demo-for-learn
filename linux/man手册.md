# man手册

**man手册页**（manual pages，“手册”），是类UNIX系统最重要的手册工具。多数类UNIX都预装了它，这也包括Arch。使用man手册页的命令是：`man`。

### 阅读手册页

man手册页：

1. 普通命令
2. 内核提供的系统调用
3. 库调用（C库函数）
4. 特殊文件（大多在/dev目录下）和设备
5. 文件格式规范
6. 游戏
7. 杂项（及其规范）
8. 系统管理命令（通常需要root权限）和守护进程

命令：

- man 手册名：阅读对应的手册页
- man手册页通过名称和所属分类标识。有些不同分类的man手册页名字可能相同，比如 man(1) 和 man(7)，这时需要额外指明分类以访问需要的手册。
- whatis 命令：可以只显示需要的man手册页的简要信息

技巧：

1. 按章节查询：一般情况下不需要
   - man -f 命令：列出所有章节中的该 命令 的手册
   - man 章节号 命令：查询该章节 该命令的帮助
2. 在所有章节中查询
   - man -a 命令

### 格式

所有man手册页都按照以下标准格式组织：

- NAME - 手册叙述对象名称，及简要描述。
- SYNOPSIS - 命令参数格式，或者函数调用格式等。
- DESCRIPTION - 对叙述对象更加详细的描述。
- EXAMPLES - 由浅入深的使用示例。
- OPTIONS - 命令行或者函数调用参数的意义。
- EXIT STATUS - 不同返回（退出）代码的含义。
- FILES - 与叙述对象相关的文件。
- BUGS - 已知的bug。
- SEE ALSO - 相关内容列表。
- AUTHOR, HISTORY, COPYRIGHT, LICENSE, WARRANTY - 历史、版权、编者信息。

### 搜索手册页

如果用户压根儿不知道要查阅的手册的名称，该怎么办呢？没事，通过 `-k` 或者 `--apropos` 参数就可以按给定关键词搜索相关手册。例如，要查阅有关密码的手册（“password”）：

关键词搜索特性是从一个专用的缓存生成的。默认情况下你没有这个缓存，所以无论你搜什么，都会提示你*nothing appropriate*。你可以通过下面的命令来生成这个缓存：

```
# mandb
```

每当你安装新的manpage之后都需要运行这个命令，缓存才会更新。

现在你可以开始搜索了。 例如，要查阅有关密码的手册（“password”）：

```
$ man -k password
```

或者：

```
$ man --apropos password
```

还可以直接使用 `apropos` 命令：

```
$ apropos password
```

关键字可以使用正则表达式。

如果你想全文搜索的话，你可以用`-K`选项：

```
$ man -K password
```

### 使用在线手册页

许多网站提供在线man手册页，详细列表参见：[Wikipedia:Man_page#Repositories_of_manual_pages](https://en.wikipedia.org/wiki/Man_page#Repositories_of_manual_pages)。

- [Man7.org.](http://man7.org/linux/man-pages/index.html) Upstream for Arch Linux's [man-pages](https://www.archlinux.org/packages/?name=man-pages).
- [*Debian GNU/Linux man pages*](http://manpages.debian.net/)
- [*DragonFlyBSD manual pages*](http://leaf.dragonflybsd.org/cgi/web-man)
- [*FreeBSD Hypertext Man Pages*](http://www.freebsd.org/cgi/man.cgi)
- [*Linux and Solaris 10 Man Pages*](http://www.manpages.spotlynx.com/)
- [*Linux/FreeBSD Man Pages*](http://manpagehelp.net/) with user comments
- [*Linux man pages at die.net*](http://linux.die.net/man/)
- [The Linux man-pages project at kernel.org](http://www.kernel.org/doc/man-pages/)
- [*NetBSD manual pages*](http://netbsd.gw.com/cgi-bin/man-cgi)
- [*Mac OS X Manual Pages*](http://developer.apple.com/documentation/Darwin/Reference/ManPages/index.html)
- [*On-line UNIX manual pages*](http://unixhelp.ed.ac.uk/alphabetical/index.html)
- [*OpenBSD manual pages*](http://www.openbsd.org/cgi-bin/man.cgi)
- [*Plan 9 Manual — Volume 1*](http://man.cat-v.org/plan_9/)
- [*Inferno Manual — Volume 1*](http://man.cat-v.org/inferno/)
- [*Storage Foundation Man Pages*](http://sfdoccentral.symantec.com/sf/5.0MP3/linux/manpages/index.html)
- [*The Missing Man Project*](http://markhobley.yi.org/manpages/missingman.html) [dead link as of 9 July 2010]
- [*Gobuntu Manual Pages*](http://en.linuxpages.info/index.php?title=Main_Page) [dead link as of 9 July 2010]
- [*The UNIX and Linux Forums Man Page Repository*](http://www.unix.com/man-page/OpenSolaris/1/man/)
- [*Ubuntu Manpage Repository*](http://manpages.ubuntu.com/)