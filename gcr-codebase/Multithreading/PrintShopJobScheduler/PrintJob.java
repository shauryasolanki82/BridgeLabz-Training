package PrintShopJobScheduler;

public class PrintJob implements Runnable {
    String jobName;
    int noOfPages;
    int priorityLevel;

    public PrintJob(String jobName, int noOfPages, int priorityLevel){
        this.jobName = jobName;
        this.noOfPages = noOfPages;
        this.priorityLevel = priorityLevel;
    }
    public void run(){
        System.out.println("Started: " + jobName +" Priority: " + Thread.currentThread().getPriority());

        System.out.println("Printing "+jobName+" page 1 of "+noOfPages);
    }
}
