package 二十周Java课设.C题;

public class BinaryTreeTester {
    //BasicDemoOfMyBinaryTree
    public static void Test_01(){
        BinaryTreeNode<String> parentNode = new BinaryTreeNode<>("parent");
        BinaryTreeNode<String> sunNode = new BinaryTreeNode<>("sun");
        BinaryTreeNode<String> childNode = new BinaryTreeNode<>("child");
        BinaryTreeNode<String> sonNode = new BinaryTreeNode<>("son");
        BinaryTree myRoot = new BinaryTree(parentNode);
        myRoot.insertLeft(parentNode,sunNode);
        myRoot.insertLeft(sunNode,childNode);
        myRoot.insertRight(parentNode,sonNode);

        myRoot.PreOrder(parentNode);
        System.out.println("先序遍历完毕");
        myRoot.InOrder(parentNode);
        System.out.println("中序遍历完毕");
        myRoot.PostOrder(parentNode);
        System.out.println("后序遍历完毕");


        System.out.println("二叉树高度为："+myRoot.getHeight());
        System.out.println("二叉树节点个数为："+myRoot.getSize());
        System.out.println("根节点为"+myRoot.getRoot());
        System.out.println("二叉树是否为空"+myRoot.isEmpty());
    }
    public static void main(String[] args) {
        Test_01();
    }
}
