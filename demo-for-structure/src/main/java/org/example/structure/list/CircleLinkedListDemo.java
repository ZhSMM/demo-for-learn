package org.example.structure.list;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/01
 * @description 约瑟夫问题
 **/
// 创建子节点
class Boy {
    // 编号
    private int no;
    // 下一个节点
    private Boy next;

    public Boy(int no) {
        this.no = no;
        this.next = null;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

// 创建一个环形的单项链表
class CircleLinkedList {
    // 创建一个first节点，无编号
    private Boy first = null;

    // 添加小孩节点，构建一个环形链表
    public void addBoy(int nums) {
        // nums数据校验
        if (nums < 2) {
            System.out.println("nums的值不正确");
            return;
        }
        // 创建辅助指针
        Boy cur = null;
        // 使用for循环创建链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first); // 构成环
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }
    // 遍历当前的环形链表
    public void showBoy(){
        // 判空
        if (first == null){
            System.out.println("无小孩");
            return;
        }
        // 辅助指针
        Boy cur = first;
        while (true){
            System.out.println("小孩的编号："+cur.getNo());
            if (cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }
    }
    // 根据用户输入，执行出圈操作
    // 1. 创建一个辅助指针helper,事先应该指向环形链表的最后这个节点；
    //   补充：小孩报数前，先让first和helper移动k-1次
    // 2. 当小孩报数时，让first和help指针同时移动m-1次
    // 3. 这是就可以让这个小孩出圈 ： first = first.next  helper.next = first
    // 4. first == helper

    /**
     *
     * @param startNo  表示从第几个小孩开始计数
     * @param countNum  表示每次数几下
     * @param nums 最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        // 数据校验
        if (first == null || startNo <1 || startNo>nums){
            System.out.println("参数输入有误，请重新输入！");
        }
        // 创建辅助指针
        Boy helper=first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前，先让first和helper移动startNo-1次
        for (int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        // 当小孩报数时，让first和helper指针同时移动countNum次,然后出圈
        // 循环到只剩一个节点
        while(true){
            if (helper == first){  // 圈中只有一个节点
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                helper=helper.getNext();
            }
            // 这是first指向的节点为要出圈的节点
            System.out.println("小孩出圈："+first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的节点:"+first.getNo());
    }
}

public class CircleLinkedListDemo {
    public static void main(String[] args) {
        // 构建环形链表
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoy(5);
        circleLinkedList.showBoy();
        // 执行出圈操作
        circleLinkedList.countBoy(1,2,5);
    }
}
