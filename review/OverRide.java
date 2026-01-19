package review;
import java.util.*;
class Parent{
    String name;
    Parent(String name){
        this.name = name;
    }
    public void display(){
        System.out.println("parent class");
    }
}
class Child extends Parent{
    String name;
    Child(String name){
        super(name);
        this.name = name;
    }
    @Override
    public void display(){
        System.out.println(name);
    }
    public void surName(String name){
        System.out.println(name);
    }
    public void surName(){
        System.out.println("Solanki");
    }
}
public class OverRide{
    public static void main(String[] args) {
        Parent p = new Parent("abc");
        Child c = new Child("xyz");
        p.display();
        c.display();
    }
}