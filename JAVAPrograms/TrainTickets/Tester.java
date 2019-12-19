package MiniPrograms.TrainTickets;

import java.util.ArrayList;

class Lock{
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
}
public class Tester {
    public static ArrayList<Client> clients = new ArrayList<>();
    public static ArrayList<TrainTicket> trainTickets = new ArrayList<>();
    public Tester(){
        //用户
        clients.add(new Client("张三"));
        clients.add(new Client("李四"));
        clients.add(new Client("王五"));
        clients.add(new Client("马六"));
        clients.add(new Client("杨七"));

        //车票种类
        trainTickets.add(new TrainTicket());
        trainTickets.add(new TrainTicket());
        trainTickets.add(new TrainTicket());
    }
    //测试车票和用户的信息正确性
    public static void Test_1(){
        Client client1 = new Client("张三");
        TrainTicket trainTicket1 = new TrainTicket();
        System.out.println(client1);
        System.out.println(trainTicket1);
        client1.buyTraTicket(trainTicket1);

    }
    public static void Test_2() throws InterruptedException {
        new Tester();
        Thread t1 = new Thread(() -> {
            synchronized (Lock.lock1) {
                clients.get(0).buyTraTicket(trainTickets.get(0));
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (Lock.lock1) {
                clients.get(1).buyTraTicket(trainTickets.get(0));
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (Lock.lock2) {
                clients.get(2).buyTraTicket(trainTickets.get(1));
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
