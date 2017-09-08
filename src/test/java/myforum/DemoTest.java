package myforum;

public class DemoTest {

	public static void main(String [] arg){
		ThreadDemo ds = new ThreadDemo();
		ds.start();
		
		RunnableDemo dd = new RunnableDemo();
		Thread td = new Thread(dd);
		td.start();
		
		for(int i=0;i<10;i++){
			try {
				ThreadDemo.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Ö÷Ïß³Ì"+i);
		}
	}
}
