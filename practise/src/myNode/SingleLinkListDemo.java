package myNode;

/**
 * @Author: ruan
 * Date: 2021/9/9 7:57
 * @Description:
 */
public class SingleLinkListDemo {

}

/**
 * 自定义节点
 */
class Node{
    /**
     * 节点编号
     */
    private int no;
    /**
     * 节点名称（内容）
     */
    private String name;
    /**
     * 指向下一个节点
     */
    private Node next;

    /**
     * 创建构造方法
     * @param no
     * @param name
     * @param next
     */
    public Node(int no, String name, Node next) {
        this.no = no;
        this.name = name;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

/**
 * 自定义链表
 */
class SinglyLinkedList{

}