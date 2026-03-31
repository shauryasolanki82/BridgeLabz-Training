public class MyThread extends Thread{
    String fileName;
    public MyThread(String fileName){
        this.fileName = fileName;
    }
    public void run(){
    for(int i=0;i<=100;i+=10){
        System.out.println("["+Thread.currentThread().getName()+"] Downloading "+fileName+" :"+i+"%");
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
}