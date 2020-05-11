package org.example.structure.list;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/05/01
 * @description 双向链表
 **/
// 双向链表节点
class DoubleNode<T> {
    public int id;
    public T value;
    public DoubleNode<T> prev;
    public DoubleNode<T> next;

    public DoubleNode(int id, T value) {
        this.id = id;
        this.value = value;
        this.prev = null;
        this.next = null;
    }


    @Override
    public String toString() {
        return "DoubleNode{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}

// 双向链表
class DoubleLinkedList<T> {
    private final DoubleNode<T> head = new DoubleNode<>(-1, null);

    // 返回头节点
    public DoubleNode<T> getHead() {
        return head;
    }

    // 遍历
    public void list() {
        // 如果链表为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 对节点个数进行计数
        int count = 0;
        // head节点不动，辅助节点进行遍历
        DoubleNode<T> tmp = head.next;
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
    }

    // 添加
    public void add(DoubleNode<T> node) {
        // 辅助节点
        DoubleNode<T> tmp = head;
        // 遍历链表，找到最后一个节点
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        // 将新节点添加在后面
        tmp.next = node;
        node.prev = tmp;
    }

    // 修改一个节点的内容
    public boolean update(DoubleNode<T> node) {
        // 判空操作
        if (head.next == null) {
            System.out.println("链表为空");
            return false;
        }
        // 找到需要修改的节点
        boolean flag = false;
        // 辅助节点
        DoubleNode<T> tmp = head.next;
        while (true) {
            if (tmp == null) { // 遍历到最后一个节点退出
                break;
            }
            if (tmp.id == node.id) {  // 找到节点退出
                flag = true;
                break;
            }
            // 辅助节点移位
            tmp = tmp.next;
        }
        if (flag) { // 找到节点
            tmp.value = node.value;
            return true;
        } else {
            return false;
        }
    }

    // 删除节点
    // 对于双向链表，可以直接找到目标节点，进行删除
    public boolean delete(int id) {
        // 判空
        if (head.next == null) {
            System.out.println("链表为空");
            return false;
        }
        // 标识
        boolean flag = false;
        // 辅助节点
        DoubleNode<T> tmp = head.next;
        while (true) {  // 循环遍历去找待删除的节点
            if (tmp == null) {
                break;
            }
            if (tmp.id == id) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        // 是否找到节点
        if (flag){
            tmp.prev.next=tmp.next;
            // tmp.next有可能为空，需要进行判断,不判断可能出现空指针异常
            if (tmp.next != null){
                tmp.next.prev = tmp.prev;
            }
            return true;
        }else{
            System.out.println("未找到该节点");
            return false;
        }
    }
}

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 创建节点
        DoubleNode<String> node = new DoubleNode<>(100, "世界如此美好");
        DoubleNode<String> node1 = new DoubleNode<>(6, "第一个节点");
        DoubleNode<String> node2 = new DoubleNode<>(2, "第二个节点");
        DoubleNode<String> node3 = new DoubleNode<>(9, "第三个节点");

        // 双向链表测试
        DoubleLinkedList<String> list=new DoubleLinkedList<>();
        // 增加节点
        list.add(node);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        // 输出
        list.list();

        // 修改
        System.out.println("-----------双向链表的修改测试-------");
        list.update(new DoubleNode<>(9,"世界"));
        list.list();
        // 删除最后一个
        System.out.println("-----------双向链表的删除测试-------");
        list.delete(9);
        list.list();
        // 增加相同节点
        list.add(new DoubleNode<>(2,"Hello World"));
        list.list();
    }
}
