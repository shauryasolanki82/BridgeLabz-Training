public class Temprature {
    public static float getTemp(){
        float temp = (float)(Math.random()*110)-50;
        return temp;
    } 
    public static int highestTemp(float[][] temp){
        float highest = Integer.MIN_VALUE;
        int day =0;
        for(int i=0;i<7;i++){
            for(int j=0;j<24;j++){
                if(temp[i][j] > highest){
                    highest = temp[i][j];
                    day = i;
                }
            }
        }
        return day;
    } 
    public static int lowestTemp(float[][] temp){
        float lowest = Integer.MAX_VALUE;
        int day =0;
        for(int i=0;i<7;i++){
            for(int j=0;j<24;j++){
                if(temp[i][j] < lowest){
                    lowest = temp[i][j];
                    day = i;
                }
            }
        }
        return day;
    } 
    public static void AverageTemp(float[][] temp){
        for(int i=0;i<7;i++){
            float sum = 0;
            for(int j=0;j<24;j++){
                sum+=temp[i][j];
            }
            float avg = sum/24;
            int day = i+1;
            System.out.println("Day "+day+" Average temprature is: "+avg);
        }
    }

    public static void main(String[] args) {
        float[][] temp = new float[7][24];
        for(int i=0;i<7;i++){
            for(int j=0;j<24;j++){
                temp[i][j] = getTemp();
            }
        }
        int highest = highestTemp(temp);
        int lowest = lowestTemp(temp);
        System.out.println("Highest temprature is on Day: "+highest);
        System.out.println("Lowest temprature is on Day: "+lowest);
        AverageTemp(temp);
    }
}
