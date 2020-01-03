package 二十周Java课设.C题;

public class BinaryTree {
    //根节点
    private BinaryTreeNode root;

    //初始化二叉树
    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    //二叉树判空isEmpty()
    public boolean isEmpty() {
        return root == null;
    }
    //判断二叉树的高度getHeight()

    /**
     * 求二叉树的高度：
     * 首先要一种获取以某个节点为子树的高度的方法，使用递归调用。
     * 如果一个节点为空，那么这个节点肯定是一颗空树，高度为0；
     * 如果不为空，那么我们要遍历地比较它的左子树高度和右子树高度，
     * 高的一个为这个子树的最大高度，然后加上自己本身的高度就是了
     * 获取二叉树的高度，只需要调用第一种方法，即传入根节点
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryTreeNode node) {
        if (node == null) {//递归结束条件，当这个节点为空时。
            return 0;//这个节点是一颗空树，高度为0
        } else {
            //得到左子树的高度
            int leftHeight = getHeight(node.getLeftChildNode());
            //得到右子树的高度
            int rightHeight = getHeight(node.getRightChildNode());
            //返回子树高度更高的一支，+1表示要算上自身
            return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
        }
    }

    //获取二叉树的节点数getSize()
    public int getSize() {
        return getSize(root);
    }

    private int getSize(BinaryTreeNode node) {
        if (node == null) {
            return 0;//节点为空，返回0，表示无节点.
        } else {
            return 1 + getSize(node.getRightChildNode()) + getSize(node.getLeftChildNode());
        }
    }

    //清空二叉树clearBinaryTree()
    public void clearBinaryTree() {
        clearBinaryTree(root);
    }

    private void clearBinaryTree(BinaryTreeNode node) {
        if (node != null) {
            clearBinaryTree(node.getLeftChildNode());
            clearBinaryTree(node.getRightChildNode());
        }
    }

    //查找node节点在二叉树中的父节点并返回父节点getParentNode()
    public BinaryTreeNode getParentNode(BinaryTreeNode node) {
        return (root == null || root == node) ? null : getParentNode(root, node);
    }

    private BinaryTreeNode getParentNode(BinaryTreeNode thisBinaryTree, BinaryTreeNode nodeWithLookup) {
        //二叉树为空，则这个节点没有父节点
        if (thisBinaryTree == null) {
            return null;
        }
        //如果这个节点的父节点为根节点，返回根节点
        if (thisBinaryTree.getLeftChildNode() == nodeWithLookup || thisBinaryTree.getRightChildNode() == nodeWithLookup) {
            return thisBinaryTree;
        }
        //向左右子树递归寻找父节点
        if (getParentNode(thisBinaryTree.getLeftChildNode(), nodeWithLookup) != null) {
            return getParentNode(thisBinaryTree.getLeftChildNode(), nodeWithLookup);
        } else {
            return getParentNode(thisBinaryTree.getRightChildNode(), nodeWithLookup);
        }
    }

    //获取某个节点的左子树
    public BinaryTreeNode getleftTree(BinaryTreeNode node) {
        return node.getLeftChildNode();
    }

    //获取某个节点的右子树
    public BinaryTreeNode getrightTree(BinaryTreeNode node) {
        return node.getRightChildNode();
    }

    //给某个节点插入左节点insertLeft ()
    public void insertLeft(BinaryTreeNode parent, BinaryTreeNode newnode) {
        parent.setLeftChildNode(newnode);
    }

    //给某个节点插入右节点insertRight ()
    public void insertRight(BinaryTreeNode parent, BinaryTreeNode newnode) {
        parent.setRightChildNode(newnode);
    }

    //二叉树的先序遍历PreOrder()
    public void PreOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.getData()); //先访问根节点
            PreOrder(node.getLeftChildNode());  //先根遍历左子树
            PreOrder(node.getRightChildNode());  //先根遍历右子树
        }
    }

    //二叉树的中序遍历InOrder()
    public void InOrder(BinaryTreeNode node) {
        if (node != null) {
            InOrder(node.getLeftChildNode());  //中根遍历左子树
            System.out.println(node.getData());    //访问根节点
            InOrder(node.getRightChildNode());  //中根遍历右子树
        }
    }

    //二叉树的后序遍历
    public void PostOrder(BinaryTreeNode node) {
        if (node != null) {
            PostOrder(node.getLeftChildNode());  //后根遍历左子树
            PostOrder(node.getRightChildNode());  //后根遍历右子树
            System.out.println(node.getData());   //访问根节点
        }
    }

    //自动get和set方法
    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
}
