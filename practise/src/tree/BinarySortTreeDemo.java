package tree;

/**
 * @Author: ruan
 * Date: 2021/9/17 14:31
 * @Description: 二叉排序树
 * 对于二叉排序树的任何一个非叶子节点要求左子节点的值小于当前节点值，右子节点的值大于当前子节点的值
 * ps：如果有相同值，可以将该节点放在左或者右
 */
public class BinarySortTreeDemo {
}
/**
 * 树节点
 */
class TreeNode{
    /**
     * 节点值
     */
    int value;
    /**
     * 左-子节点
     */
    TreeNode left;
    /**
     * 右-子节点
     */
    TreeNode right;
    /**
     * 相关构造器
     * @param value 节点值
     */
    public TreeNode(int value){
        this.value = value;
    }

    /**
     * 递归添加节点
     * @param treeNode 待添加节点
     */
    public void add(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        //判断传入的值和当前子树的根节点的值的关系
        if (treeNode.value < this.value){
            //如果当前节点的左子节点为空直接挂载
            if (this.left == null){
                this.left = treeNode;
            }else {
                //递归向左子树添加
                this.left.add(treeNode);
            }
        }
    }
}
