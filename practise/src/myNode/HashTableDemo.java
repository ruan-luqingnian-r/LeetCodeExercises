package myNode;

/**
 * @Author: ruan
 * Date: 2021/9/11 17:23
 * @Description: 哈希表
 */
public class HashTableDemo {
    public static void main(String[] args) {
        MyNode node1 = new MyNode(1, "测试1");
        MyNode node2 = new MyNode(2, "测试2");
        MyNode node3 = new MyNode(3, "测试3");
        MyNode node4 = new MyNode(4, "测试4");
        NodeList nodeList = new NodeList();
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);

    }

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

    @Override
    public String toString() {
        return "MyNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

        if (head == null){
            head = newNode;
            return;
        }

        //创建辅助节点
        MyNode temp = head;
        //找到链表尾部
        while (true){
            if (temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
        }
        //插入节点
        temp.setNext(newNode);
    }

    /**
     * 遍历链表
     */
    public void list(int no){
        if (head == null){
            System.out.println("第"+(no + 1)+"个链表为空");
            return;
        }else {
            System.out.print("第"+(no + 1)+"个链表的信息为");
        }
        
        //创建辅助节点
        MyNode temp = head;
        while (true){
            System.out.printf(" => id=%d name=%s\t",temp.getId(),temp.getName());
            if (temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
            System.out.println(temp.toString());
        }
        System.out.println();
    }

    /**
     * 根据编号查找信息
     * @param no
     */
    public void find(int no){

    }

}
