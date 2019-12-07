import java.lang.Thread;

class MyThread extends Thread{
	/**
		@Override
	*/
	public void run(){
		for(int i = 0; i<1000;i++){
			System.out.println("This is " + i);
		}
	}
}
/**
	@author:JarvisHsu
*/
public class Main{
	

	public static void Test_01(){
		MyThread t = new MyThread();
		System.out.println("main Thread begin!");
		try{
			t.start();
			/*System.out.println("main interrupetd");
			Thread.sleep(1);
			System.out.println("main interrupted");
			Thread.sleep(1);
			System.out.println("main interrupted");*/
			for(int i = 0 ; i < 10; i++){
				Thread.sleep(1);
				System.out.println("main interrupted");
			}
			t.join();
		}catch(InterruptedException e){
	        System.out.println(e); 
		}finally{
			System.out.println("main Tread over");
		}
	}


	public static void main(String[] args){	
		Test_01();
	}

}
