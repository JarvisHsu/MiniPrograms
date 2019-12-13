package MiniPrograms.TrainTickets;

class Lock{
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
}
public class Tester {
    public Tester(){
        //用户
        Client client1 = new Client("张三");
        Client client2 = new Client("李四");
        Client client3 = new Client("王五");
        Client client4 = new Client("马六");
        //车票种类
        TrainTicket trainTicket1 = new TrainTicket();
        TrainTicket trainTicket2 = new TrainTicket();
        TrainTicket trainTicket3 = new TrainTicket();
    }

    public static void Test_1(){
        Client client1 = new Client("张三");
        TrainTicket trainTicket1 = new TrainTicket();
        System.out.println(client1);
        System.out.println(trainTicket1);
        client1.buyTraTicket(trainTicket1);

    }
    public static void Test_2() throws InterruptedException {
        Client client1 = new Client("张三");
        Client client2 = new Client("李四");
        Client client3 = new Client("王五");
        Client client4 = new Client("马六");
        //车票种类
        TrainTicket trainTicket1 = new TrainTicket();
        TrainTicket trainTicket2 = new TrainTicket();
        TrainTicket trainTicket3 = new TrainTicket();
        Thread t1 = new Thread(() -> {
            synchronized (Lock.lock1) {
                client1.buyTraTicket(trainTicket1);
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (Lock.lock1) {
                client2.buyTraTicket(trainTicket1);
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (Lock.lock2) {
                client3.buyTraTicket(trainTicket2);
            }
        });
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


    }

    public static void main(String[] args) throws InterruptedException {
        //Test_1();
        Test_2();

    }
}
