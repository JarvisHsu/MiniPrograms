package 二十周Java课设.A题;

public class StackTester {
    //myStack的操作
    private static void Test_01() {
        //初始化时入栈操作。
        System.out.println("初始化操作");
        String[] initial = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        SequentialStack<String> myStack = new SequentialStack<>(initial);
        //获取栈顶元素
        System.out.println("当前栈顶元素为：" + myStack.peek());
        //myStack.push("你好");

        //出栈
        System.out.println("出栈操作");
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println("\r\n当前栈空?" + myStack.isEmpty());
    }

    public static void main(String[] args) {
        Test_01();

    }
}
