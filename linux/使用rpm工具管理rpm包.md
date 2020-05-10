# 使用rpm工具管理rpm包

### 安装

- rpm -lvh local_path
- rpm -lvh url_path

额外选项：

- --nosignature：不检验软件包的签名
- --force：强制安装软件包
- --nodeps：忽略依赖关系

RPM包安装信息存储到本地数据库中。

### 查询

从本地rpm数据库进行查询：

- rpm -q 包：查询指定包是否安装
- rpm -qa：查询所有已安装的包
- rpm -ql 包：查询包安装的文件
- rpm -qf /usr/bin/ntfs-3g ：查询该文件属于哪个rpm包