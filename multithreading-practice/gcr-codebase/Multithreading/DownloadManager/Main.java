public class Main{
    public static void main(String[] args) throws InterruptedException{
        MyThread t1 = new MyThread("Document.pdf");
        MyThread t2 = new MyThread("image.jpg");
        MyThread t3 = new MyThread("Video.mp4");

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloading complete!");
    }
}