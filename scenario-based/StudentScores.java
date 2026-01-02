import java.util.*;
public class StudentScores {
    public static int highestMarks(int[] marks){
        int highest = Integer.MIN_VALUE;
        for(int i=0;i<marks.length;i++){
            if(marks[i]>highest){
                highest = marks[i];
            }
        }
        return highest;
    }
    public static int lowestMarks(int[] marks){
        int lowest = Integer.MAX_VALUE;
        for(int i=0;i<marks.length;i++){
            if(marks[i]<lowest){
                lowest = marks[i];
            }
        }
        return lowest;
    }
    public static int averageMarks(int[] marks){
        int sum = 0;
        for(int i=0;i<marks.length;i++){
                sum += marks[i];
        }
        return sum/marks.length;
    }
    public static void aboveAverage(int[] marks, int average){
        for(int i=0;i<marks.length;i++){
            if(marks[i]>average){
                int temp = i+1;
                System.out.println("Student no. "+temp+" has marks above average. marks = "+marks[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students: ");
        int noOfStudents = sc.nextInt();
        int[] marks = new int[noOfStudents];
        System.out.println("Enter the marks of Students: ");
        for(int i=0;i<marks.length;i++){
            marks[i] = sc.nextInt();
        }
        System.out.println("Highest marks is: "+highestMarks(marks));
        System.out.println("Lowest marks is: "+lowestMarks(marks));
        int average = averageMarks(marks);
        System.out.println("Average marks is: "+average);
        aboveAverage(marks, average);
        sc.close();
    }
}