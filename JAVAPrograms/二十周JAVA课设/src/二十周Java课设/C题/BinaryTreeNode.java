package 二十周Java课设.C题;

public class BinaryTreeNode<C> {
    private C data;//数据
    private BinaryTreeNode leftChildNode;   //左节点
    private BinaryTreeNode RightChildNode;  //右节点
    public BinaryTreeNode(C data){
        this.data = data;
    }

    //自动get和set方法
    public C getData() {
        return data;
    }

    public void setData(C data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(BinaryTreeNode leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public BinaryTreeNode getRightChildNode() {
        return RightChildNode;
    }

    public void setRightChildNode(BinaryTreeNode rightChildNode) {
        RightChildNode = rightChildNode;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                ", leftChildNode=" + leftChildNode +
                ", RightChildNode=" + RightChildNode +
                '}';
    }
}
