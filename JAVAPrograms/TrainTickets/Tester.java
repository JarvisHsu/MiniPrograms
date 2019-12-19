//package MiniPrograms.TrainTickets;

import java.util.ArrayList;

class Lock{
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
}
/**
 *@author JarvisHsu 徐佳伟
 */
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
	//测试三个用户买两种票的线程运行机制。
    public static void Test_2() throws InterruptedException {
        new Tester();
        Thread t1 = new Thread(() -> {
			//加锁
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
		//线程开始
        t1.start();
        t2.start();
        t3.start();
		//线程等待结束
        t1.join();
        t2.join();
        t3.join();


    }
	//异常抛给JVM，Test通过static运行。
    public static void main(String[] args) throws InterruptedException {
        //Test_1();
        Test_2();

    }
}
