package myNode;

/**
 * @Author: ruan
 * Date: 2021/9/9 7:57
 * @Description:
 */
public class SingleLinkListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "小天才");
        Node node2 = new Node(2, "大聪明");
        Node node3 = new Node(3, "卧龙");
        Node node4 = new Node(4, "凤雏");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        /*singlyLinkedList.ulAdd(node2);
        singlyLinkedList.ulAdd(node3);
        singlyLinkedList.ulAdd(node4);
        singlyLinkedList.ulAdd(node1);*/
        singlyLinkedList.olAdd(node2);
        singlyLinkedList.olAdd(node3);
        singlyLinkedList.olAdd(node4);
        singlyLinkedList.olAdd(node1);
        singlyLinkedList.list();
        Node node = singlyLinkedList.findNode(1);
        System.out.printf("[%d]号节点是数据为:[%s] \n",node.getNo(),node.getName());
        singlyLinkedList.updateNode(3,"小卧龙");
        singlyLinkedList.list();
        System.out.printf("链表长度为:[%d] \n",singlyLinkedList.size());
        singlyLinkedList.delNode(3);
        singlyLinkedList.list();
        System.out.printf("链表长度为:[%d] \n",singlyLinkedList.size());
    }

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
        while (temp.getNext() != null){
            //后移节点
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }


    /**
     * 插入节点---顺序插入
     * @param newNode
     */
    public void olAdd(Node newNode){
        //创建辅助节点
        Node temp = headNode;
        //插入的编号是否存在
        boolean flag = false;
        //遍历整个节点
        while (true){
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() > newNode.getNo()){
                //说明找到了待插入位置就再temp后面
                break;
            }
            if (temp.getNext().getNo() == newNode.getNo()){
                //已经存在此数值
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        //开始插入
        if (flag){
            System.out.printf("准备插入的节点的编号[%d]已经存在了, 不能加入\n",newNode.getNo());
        }else {
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }



    }

    /**
     * 打印链表
     * 1.遍历链表打印每一个节点
     */
    public void list(){
        //首先判断链表是否为空
        if (headNode.getNext() == null){
            System.out.println("链表为空");
            return;
        }

        //定义一个辅助节点
        Node temp = headNode;
        //遍历整个节点
        while (temp.getNext() != null){
            temp = temp.getNext();
            System.out.println(temp.toString());
        }
    }

    /**
     * 查看节点信息
     * @param no 节点id
     * @return
     */
    public Node findNode(int no){
        //数据校验
        if (no < 0 || no > size()){
            System.out.println("数据异常");;

        }else {
            //查看是否为空链表
            if (headNode.getNext() == null){
                System.out.println("链表为空");
                return new Node(-1,"");
            }
            //创建辅助节点
            Node temp = headNode;
            //遍历链表
            while (temp.getNext() != null){
                temp = temp.getNext();
                if (temp.getNo() == no){
                    return temp;
                }
            }
        }
        return new Node(-1,"");
    }

    /**
     * 更新节点数据
     * @param no 待更新节点no
     * @param newName 新数据值
     */
    public void updateNode(int no,String newName){
        //判断是否为空
        if (headNode.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        /**
         * 是否找到
         */
        boolean flag = false;
        //数据校验
        if (no < 0 || no > size()){
            System.out.println("非法数据");
        }else {
            //创建头节点
            Node temp = headNode.getNext();
            while (temp != null){
                temp = temp.getNext();
                if (temp.getNo() == no){
                    flag = true;
                    break;
                }
            }
            if (flag){
                temp.setName(newName);
            }else {
                System.out.printf("[%d]节点不存在",no);
            }
        }
    }

    /**
     * 删除节点
     * @param no 要删除节点的no
     */
    public void delNode(int no){
        /**
         * 是否找到该节点
         */
        boolean flag = false;
        //数据校验
        if (no < 0 || no > size()){
            System.out.println("数据异常");
            return;
        }
        //创建辅助节点
        Node temp = headNode;
        //遍历节点
        while (temp.getNext() != null){
            temp = temp.getNext();
            if (temp.getNext().getNo() == no){
                flag = true;
                break;
            }
        }
        if (flag){
            temp.setNext(temp.getNext().getNext());
        }
    }

    /**
     * 链表长度
     * @return
     */
    public int size(){
        int count = 0;
        //判断是否为空
        if (headNode.getNext() == null){
             System.out.println("链表为空");
             return 0;
        }
         //创建辅助链表
        Node temp = headNode;
        while (temp.getNext() != null){
            temp = temp.getNext();
            count++;
        }
        return count;
    }
}