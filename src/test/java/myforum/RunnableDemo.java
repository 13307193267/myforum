package myforum;

public class RunnableDemo implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("Is My implements Runnable"+ i);
		}
	}

}
