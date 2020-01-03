package 二十周Java课设.B题;

public class QueueTester {
    private static void Test_01() {
        QueueInterface<String> myQueue = new LoopQueue<>(5);
        myQueue.addQueue("1");
        myQueue.addQueue("4");
        myQueue.addQueue("3");
        myQueue.addQueue("7");
        myQueue.addQueue("6");
        myQueue.addQueue("5");
        myQueue.addQueue("0");
        System.out.println(myQueue.peek());
        System.out.println("当前队列为空?" + myQueue.isEmpty());
        while (!myQueue.isEmpty()) {
            System.out.print(myQueue.removeQueue() + " ");
        }
        System.out.println("\r\n当前队列为空?" + myQueue.isEmpty());
    }

    public static void main(String[] args) {
        Test_01();
    }
}
