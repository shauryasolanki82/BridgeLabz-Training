package functional_interface;

public class BackgroundJobExecution {

	public static void main(String[] args) {
		Runnable r=()->{
			System.out.println("Background job started");
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Background job completed");
		};
		Thread thread=new Thread(r);
		thread.start();
		System.out.println("Main thread continues..");
	}

}
