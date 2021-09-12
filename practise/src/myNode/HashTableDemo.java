package myNode;

/**
 * @Author: ruan
 * Date: 2021/9/11 17:23
 * @Description: 哈希表
 */
public class HashTableDemo {
    public static void main(String[] args) {


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
    public MyNode find(int no){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        //创建辅助节点
        MyNode temp = head;
        while (true){
            if (temp.getId() == no){
                break;
            }
            if (temp.getNext() == null){
                temp = null;
                break;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 根据id删除节点
     * @param no
     * @return
     */
    public boolean delById(int no){
        if (head == null){
            System.out.println("链表为空");
            return false;
        }
        //创建辅助节点
        MyNode temp = head;
        MyNode myNode = find(no);
        if (myNode == null){
            System.out.println("无此节点");
            return false;
        }else {
            head = myNode.getNext();
            return true;
        }
    }



}

/**
 * 创建哈希表
 */
class MyHashTable{
    /**
     * 数组作为链表底层
     */
    private NodeList[] nodeLists;
    /**
     * 哈希表长度
     */
    private int size;

    /**
     * 创建构造方法
     */
    public MyHashTable(int size) {
        this.size = size;
        nodeLists = new NodeList[size];
        for (int i = 0; i < size; i++) {
            nodeLists[i] = new NodeList();
        }
    }

    /**
     * 添加节点
     */
    public void add(MyNode node){
        //判断节点要插入的位置
        int hashFun = hashFun(node.getId());
        nodeLists[hashFun].add(node);
    }
    /**
     * 查找节点
     */
    public MyNode find(int id){
        int hashFun = hashFun(id);
        MyNode myNode = nodeLists[hashFun].find(id);
        if (myNode != null){
            System.out.printf("在第%d 条链表中找到 雇员 id = %d \n", (hashFun + 1), id);
        }else {
            System.out.println("未找到");
        }
        return myNode;
    }
    /**
     * 删除节点
     */
    public boolean del(int id){
        int hashFun = hashFun(id);
        return nodeLists[hashFun].delById(id);
    }

    /**
     * 散列函数
     * @param id
     * @return
     */
    public int hashFun(int id){
        return id % size;
    }
}
