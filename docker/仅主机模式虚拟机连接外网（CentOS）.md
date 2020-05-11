# 仅主机模式虚拟机连接外网（CentOS）

1. 本地连接共享给VMware Network Adapter

   - 控制面板 - 网络和Internet - 网络和共享中心 - 更改适配器设置 - 
   - 选择本地连接或WLAN（本机连接网络的适配器）- 右键 属性 - 共享 - 允许其他网络用户通过... - 选择虚拟机的网络适配器

2. VMware - 编辑 - 虚拟网络编辑器 - DHCP设置 - 起始IP（xxx.xxx.xxx.2） -  结束IP（xxx.xxx.xxx.254）

3. linux设置：`vi /etc/sysconfig/network-scripts/` - `ll` - `ifcfg-ens32` 

   ```
   TYPE=Ethernet
   IPV6INIT=yes
   IPV6_AUTOCONF=yes
   DEVICE=ens33
   ONBOOT=yes
   # 虚拟机ip地址 ip addr
   IPADDR=192.168.137.2
   # 虚拟机掩码
   NETMASK=255.255.255.0
   # 虚拟机网络适配器的IP地址
   GATEWAY=192.168.137.1
   # DNS服务器IP：国内通用114.114.114.114
   DNS1=114.114.114.114
   # 虚拟机右键-设置-网络适配器-高级-mac地址
   HWADDR=00:0C:29:40:E4:B9
   ```

4. 重启network：service network restart