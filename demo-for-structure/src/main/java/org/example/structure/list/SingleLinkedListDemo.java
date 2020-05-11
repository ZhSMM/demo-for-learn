package org.example.structure.list;

import java.util.Stack;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/01
 * @description 单链表设计
 **/

// 定义节点
class Node<T> {
    public int id; // 编号
    public T t;  // 定义数据域
    public Node<T> next;  // 指向下一个节点

    public Node(int id, T t) {
        this.id = id;
        this.t = t;
        next = null;
    }
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", t=" + t + "}";
    }
}

// 定义SingleLinkedList管理节点
class SingleLinkedList<T> {
    // 先定义头节点，头节点不动，不存放具体的数据
    private final Node<T> head = new Node<>(-1, null);

    // 添加节点
    // 当不考虑编号顺序时
    //  1. 找到当前链表的最后节点
    //  2. 将最后节点的next指向新的节点
    public void add(Node<T> t) {
        // head节点不动，辅助节点遍历
        Node<T> tmp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (tmp.next == null) {
                break;
            }
            // 未找到节点，节点后移
            tmp = tmp.next;
        }
        // 退出循环时，tmp指向最后节点
        tmp.next = t;
    }

    // 获取头节点
    public Node<T> getHead() {
        return head;
    }

    // 第二种方式添加节点，根据id大小进行调整
    // 存在相同id时，添加失败，给予提示
    public void addByOrder(Node<T> t) {
        // 头节点不动，辅助节点进行遍历
        //  tmp位于要添加位置的前一个节点
        Node<T> tmp = head;
        boolean flag = false; // 标识添加的编号是否存在，默认false
        while (true) {
            if (tmp.next == null) {  // tmp已经在链表最后,终止遍历
                break;
            }
            // 找到位置，tmp后面
            if (tmp.next.id > t.id) {
                break;
            } else if (tmp.next.id == t.id) {   // 编号存在
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        // 进行flag判断
        if (flag) {  // flag维true，说明节点已经存在，无法进行插入
            System.out.println("准备插入的节点id已经存在，无法继续操作!");
            return;
        } else {        // 进行节点插入操作
            t.next = tmp.next;
            tmp.next = t;
        }
    }

    // 修改节点的信息，根据id来修改，所以id不可变
    //  根据传入节点的id进行修改
    public void update(Node<T> t) {
        // 判空操作
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node<T> tmp = head; // 辅助节点，遍历
        boolean flag = false; // 标志是否找到节点
        while (true) {
//            if (tmp.next == null){ // 是否已经到达链表尾部
//                System.out.println("修改失败，不存在此id的节点");
//                break;
//            }
//            if (tmp.id == t.id){ // 找到此id的节点
//                tmp.t = t.t;
//                System.out.println("修改成功！");
//                break;
//            }
//            tmp = tmp.next;
            if (tmp.next == null) { // 到达链表尾部循环
                break;
            }
            if (tmp.id == t.id) { // 找到节点退出循环
                flag = true;
                break;
            }
            // 节点后移
            tmp = tmp.next;
        }
        // 对flag进行判断确认是否找到节点
        if (flag) {
            System.out.println("修改成功！");
            tmp.t = t.t;
        } else {
            System.out.println("不存在此id的节点，修改失败！");
        }
    }

    // 删除节点：
    // 1. 先找到被删除节点的前一个节点；
    // 2. tmp.next = tmp.next.next;
    // 3. 被删除的节点会因为没有引用指向而被GC回收
    public void delete(int id) {
        // 判空操作
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node<T> tmp = head; // 辅助节点，为待删除节点的前一个节点
        boolean flag = false; // 标志是否找到节点
        while (true) {
            if (tmp.next == null) { // 到达链表尾部循环，未找到
                break;
            }
            if (tmp.next.id == id) { // 找到被删除节点退出循环
                flag = true;
                break;
            }
            // 节点后移
            tmp = tmp.next;
        }
        // 对flag进行判断确认是否找到节点
        if (flag) {
            System.out.println("删除成功！");
            tmp.next = tmp.next.next;
        } else {
            System.out.println("不存在此id的节点，删除失败！");
        }
    }

    // 遍历链表,顺便输出节点个数
    public int list() {
        // 如果链表为空
        if (head.next == null) {
            System.out.println("链表为空");
            return 0;
        }
        // 对节点个数进行计数
        int count = 0;
        // head节点不动，辅助节点进行遍历
        Node<T> tmp = head.next;
        while (true) {
            // 判断是否到达链表最后节点
            if (tmp == null) {
                break;
            }
            // 输出节点值
            System.out.println(tmp.toString());
            count++;
            // 将tmp节点后移
            tmp = tmp.next;
        }
        return count;
    }
}

public class SingleLinkedListDemo {
    /**
     * 面试题1： 获取单链表的节点个数（如果是带头节点的链表，需求不统计头节点）
     *
     * @param head 链表头节点
     * @param <T>  节点数据域的类型
     * @return 返回的是有效节点个数
     */
    public static <T> int getLength(Node<T> head) {
        if (head.next == null) {  // 空链表
            return 0;
        }
        int length = 0;
        // 定义一个辅助变量，此处没有统计头节点
        Node<T> tmp = head.next;
        while (tmp != null) {
            length++;  // length自增
            tmp = tmp.next;  // 遍历
        }
        return length;
    }

    /**
     * 面试题：查找单链表中的倒数第k个节点
     * <p>
     * 思路：
     * 1. 编写一个方法，接受head节点，同时接受一个index
     * 2. index是表示倒数index个节点
     * 3. 先把链表从头到尾遍历，得到链表的总长度size
     * 4. 得到size后，从链表的第一个开始遍历到 size - index节点
     *
     * @param head  头节点
     * @param index 链表从尾部开始计数的位置
     * @param <T>   节点数据域的类型
     * @return 从尾部开始计数第index个节点
     */
    public static <T> Node<T> findIndexNodeFromLast(Node<T> head, int index) {
        if (head.next == null) {
            System.out.println("链表为空，不存在此元素！");
            return null;
        }
        // 先获得链表总长度，第一道面试题已经写好了函数
        int total = getLength(head);
        // index校验
        if (total < index || index <= 0) {
            System.out.println("链表总长度不够，返回null");
            return null;
        }
        // 辅助指针，for循环定位到倒数的index
        Node<T> tmp = head.next; // total=3 index=1  3-1 =2 移动了2次
        for (int i = 0; i < total - index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * 面试题：单链表的反转
     * <p>
     * 思路：
     * 1. 重新定义一个头节点：Node<T> reverseHead = new Node
     * 2. 从头到尾遍历原本的节点，并取出放入新链表的最前端
     * 3. 然后：head.next = reverseHead.next
     *
     * @param <T> 节点数据域的类型
     */
    public static <T> void reverseSingleLinkedList(Node<T> head) {
        // 如果链表为空，直接返回
        if (head.next == null) {
            return;
        }
        // 如果链表不为空
        // 定义新的头节点
        Node<T> reverseHead = new Node<>(-1, null);
        // 辅助指针，用于取出原链表节点
        Node<T> tmp = null;
        while (head.next != null) {
            tmp = head.next;
            // 原头节点next指向下一个节点的next
            head.next = tmp.next;

            // 把取出节点的下一个节点指向reverseHead的下一个节点
            tmp.next = reverseHead.next;
            // 把reverseHead的next节点指向tmp节点
            reverseHead.next = tmp;
        }
        // 将头节点的next指向reverseHead的next指针
        head.next = reverseHead.next;
    }

    /**
     * 面试题：从尾到头打印单链表 【1.反向遍历 2. 栈】
     *
     * 方式一： 先将单链表进行反转，再打印  ---- 不建议，会破坏单链表的结构
     * 方式二： 使用栈，顺序遍历将节点压入栈，利用栈的先入后出原则，实现逆序打印的效果
     * @param <T> 节点数据域的类型
     * @param head 头节点
     */
    public static <T> void printFromRearToHead(Node<T> head){
        // 判空操作
        if (head.next == null){
            return;
        }
        Stack<Node<T>> stack=new Stack<>();
        // 辅助节点，用来遍历
        Node<T> tmp = head.next;
        while (tmp !=null){
            // 将节点入栈
            stack.push(tmp);
            // 节点后移
            tmp=tmp.next;
        }
        // 打印节点
        while (!stack.empty()){
            System.out.println(stack.pop()); // 出栈，栈特点：先进后出
        }
    }

    /**
     * 面试题：合并两个有序的单链表，合并后使之以然有序
     *
     * 思路：
     *   1. 创建一个新的newHead节点
     *   2. 使用两个辅助节点分别遍历，取出其id进行比较，然后放入新节点的后面
     *   3. head1.next = newHead.next;
     * @param head1 第一个有序单链表的头节点
     * @param head2 第二个有序单链表的头节点
     * @param <T> 单链表的数据域的类型的泛型
     */
    public static <T> void mergeTwoSortedSingleLinkedList(Node<T> head1,Node<T> head2){
        // 判空操作
        if (head2.next==null || head1.next == null){
            if (head1.next == null ){
                head1.next=head2.next;
            }
            return;
        }
        // 辅助节点
        Node<T> tmp = null;
        // 新的首节点
        Node<T> newNode=new Node<>(-1,null);
        // 新节点的最后一个节点
        Node<T> last=newNode;
        while (head1.next != null && head2.next!=null){
            if (head1.next.id < head2.next.id){
                tmp= head1.next;
                head1.next = tmp.next;
            }else{
                tmp= head2.next;
                head2.next = tmp.next;
            }
            last.next=tmp;
            last=last.next;
        }
        if (head1 != null){
            last.next=head1.next;
        }
        if (head2 != null){
            last.next=head2.next;
        }
        head1.next = newNode.next;
    }

    public static void main(String[] args) {
        // 创建节点
        Node<String> node = new Node<>(100, "世界如此美好");
        Node<String> node1 = new Node<>(6, "第一个节点");
        Node<String> node2 = new Node<>(2, "第二个节点");
        Node<String> node3 = new Node<>(9, "第三个节点");

        // 创建链表
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        // 有序添加节点
        linkedList.addByOrder(node);
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node3);

        Node<String> node6 = new Node<>(69, "星期无");
        Node<String> node7 = new Node<>(81, "星期X");
        Node<String> node8 = new Node<>(99, "星期H");
        Node<String> node9 = new Node<>(98, "第n个节点");
        Node<String> node10 = new Node<>(9, "重复节点");
        SingleLinkedList<String> linkedList2 = new SingleLinkedList<>();
        linkedList2.addByOrder(node6);
        linkedList2.addByOrder(node7);
        linkedList2.addByOrder(node8);
        linkedList2.addByOrder(node9);
        linkedList2.addByOrder(node10);
        // 合并单链表
        mergeTwoSortedSingleLinkedList(linkedList.getHead(),linkedList2.getHead());
        linkedList.list();

        // 获取单链表长度
        System.out.println("单链表长度：" + getLength(linkedList.getHead()));

        // 得到倒数第5个节点
        System.out.println("倒数第5个节点：" + findIndexNodeFromLast(linkedList.getHead(), 5));

        // 逆序打印单链表
        printFromRearToHead(linkedList.getHead());

        // 反转单链表
        System.out.println("反转之前：节点数：" + linkedList.list());
        reverseSingleLinkedList(linkedList.getHead());
        System.out.println("反转之后：节点数：" + linkedList.list());

//        // 添加重复节点
//        System.out.println("-------添加重复节点--------");
//        linkedList.addByOrder(node4);
//        System.out.println("节点数：" + linkedList.list());
//
//        // 修改节点
//        System.out.println("---------- 修改节点-------");
//        linkedList.update(node4);
//        System.out.println("节点数：" + linkedList.list());
//
//        // 删除节点
//        System.out.println("--------------删除------------");
//        linkedList.delete(9);
//        System.out.println("节点数：" + linkedList.list());
//
//        // 删除不存在id
//        System.out.println("-----------删除不存在id------------");
//        linkedList.delete(36);
//        System.out.println("节点数：" + linkedList.list());
//
//        // 删除全部节点
//        System.out.println("-----------删除全部节点-------");
//        linkedList.delete(2);
//        linkedList.delete(6);
//        linkedList.delete(100);
//        System.out.println("节点数：" + linkedList.list());
    }
}
