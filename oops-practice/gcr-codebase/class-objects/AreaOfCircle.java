import java.util.Scanner;
class Circle{
    double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public void Area(){
        double area = 3.14*Math.pow(radius, 2);
        System.out.println(area);
    }
    public void Circumference(){
            double circumference = 2*3.14*radius;
            System.out.println(circumference);
        }
}
public class AreaOfCircle {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the radius of the circle");
       double radius = sc.nextDouble();
       Circle circle = new Circle(radius);  
       circle.Area();
       circle.Circumference();
       sc.close();
    }
}
