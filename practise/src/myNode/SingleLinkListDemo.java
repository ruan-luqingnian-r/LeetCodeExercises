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
     */
    public Node(int no, String name) {
        this.no = no;
        this.name = name;
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

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 自定义链表
 */
class SinglyLinkedList{
    /**
     * 创建空的头节点
     */
    private Node headNode = new Node(0,"");

    /**
     * 向链表内插入节点-无序插入
     * 1.遍历到节点尾部 next = null;
     * 2.将节点尾部指向待插入节点 next = newNode;
     */
    public void ulAdd(Node newNode){
        //定义一个辅助头节点
        Node temp = headNode;
        //遍历链表找到节点尾部
        while (true){
            if (temp.getNext() == null){
                break;
            }
            //后移节点
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }
}