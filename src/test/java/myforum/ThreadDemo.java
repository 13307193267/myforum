package myforum;

public class ThreadDemo extends Thread{

	public void run(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Is My extends Thread "+ i);
		}
	}
}
