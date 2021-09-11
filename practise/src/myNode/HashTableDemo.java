package myNode;

/**
 * @Author: ruan
 * Date: 2021/9/11 17:23
 * @Description: 哈希表
 */
public class HashTableDemo {

}

/**
 * 定义节点
 */
class MyNode{
    /**
     * 节点ID
     */
    private int id;
    /**
     * 节点名
     */
    private String name;
    /**
     * 指向下一个节点
     */
    private MyNode next;

    public MyNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}

/**
 * 定义链表以保存节点信息
 */
class NodeList{
    /**
     * 创建表头节点
     */
    private MyNode head;

    /**
     * 新增节点
     * @param newNode
     */
    public void add(MyNode newNode){
        //创建辅助节点

    }

}
