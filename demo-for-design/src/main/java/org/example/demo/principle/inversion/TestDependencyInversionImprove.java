package org.example.demo.principle.inversion;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description 依赖倒置
 **/
public class TestDependencyInversionImprove {
    public static void main(String[] args) {
        // 方式二测试：客户端无需改变
        Person person=new Person();
        person.receive(new Email());
    }
}
interface IReceiver{
    String getInfo();
}

class Email01 implements IReceiver{
    @Override
    public String getInfo() {
        return "电子邮件信息：hello world！";
    }
}
// 增加WeChat
class WeChat implements IReceiver{

    @Override
    public String getInfo() {
        return "接收到微信消息：hello world！";
    }
}

// 完成Person接受消息的功能
// 方式一：
//  缺点：如果需要获取的对象是微信、短信等，需要新增类，同时Person类需要增加相应的接受方法
// 解决方法：
//    引入一个抽象的接口IReceiver，表示接受者，Person类与IReceiver发生依赖
//    因为Email、WeChat等实现IReceiver，实现依赖倒置原则
class Person01{
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}