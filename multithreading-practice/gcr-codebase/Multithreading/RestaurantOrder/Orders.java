package RestaurantOrder;

public class Orders implements Runnable {
    String foodItem;

    public Orders(String foodItem){
        this.foodItem = foodItem;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" Started preparing "+foodItem);
        for(int i=25;i<=100;i+=25){
            System.out.println(Thread.currentThread().getName()+" preparing "+foodItem+": "+i+"% complete");

            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
