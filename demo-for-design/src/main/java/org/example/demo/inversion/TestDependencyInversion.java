package org.example.demo.inversion;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/11
 * @description 未使用依赖倒置
 **/
public class TestDependencyInversion {
    public static void main(String[] args) {
        // 方式一测试：
        Person person=new Person();
        person.receive(new Email());
    }
}

class Email{
    public String getInfo(){
        return "电子邮件信息：hello world！";
    }
}

// 完成Person接受消息的功能
// 方式一：
//  缺点：如果需要获取的对象是微信、短信等，需要新增类，同时Person类需要增加相应的接受方法
// 解决方法：
//    引入一个抽象的接口IReceiver，表示接受者，Person类与IReceiver发生依赖
//    因为Email、WeChat等实现IReceiver，实现依赖倒置原则
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}