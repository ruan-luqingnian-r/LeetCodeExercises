package myNode;

/**
 * @Author: ruan
 * Date: 2021/9/9 7:57
 * @Description:
 */
public class SingleLinkList {

}

/**
 * 节点
 */
class Node{
    private int no;
    private String name;
    private Node next;

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
