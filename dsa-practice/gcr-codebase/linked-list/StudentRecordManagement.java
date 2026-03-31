import java.util.*;
class Node{
    int rollNo;
    char grade;
    int age;
    String name;
    Node next = null;
    public Node(int rollNo, char grade, int age, String name){
        this.rollNo = rollNo;
        this.grade = grade;
        this.age = age;
        this.name = name;
        this.next = null;
    }
}
public class StudentRecordManagement {
    // insert at front
    static Node insertAtFront(Node head, int rollNo, char grade, int age, String name) {
        Node node = new Node(rollNo, grade, age, name);
        if(head==null)
        {
            return node;
        }
        node.next = head;
        head=node;
        return head;
    }
    // insert at last
    static Node insertAtLast(Node head, int rollNo, char grade, int age, String name){
        Node ptr = head;
         Node node = new Node(rollNo, grade, age, name);
        if(head==null)
        {
            return node;
        }
        while(ptr.next!=null){
            ptr=ptr.next;
        }
       
        ptr.next = node;
        return head;
    }
    // insert at specific position
    static Node insertAtSpecificPosition(Node head, int pos, int rollNo, char grade, int age, String name){
        Node ptr = head;
        Node node = new Node(rollNo, grade, age, name);
        if(pos==1)
            return insertAtFront(head, rollNo, grade, age, name);
        while(ptr.next!=null && pos!=1){
            pos--;
            ptr=ptr.next;
        }
        if(ptr.next==null)
        {
            System.out.println("invalid position");
            return head;
        }
        Node ptr2 = ptr.next;
        ptr.next = node;
        node.next=ptr2;
        return head;
    }
    // printing linkedlist
    static void printList(Node head){
        Node ptr = head;
        while(ptr!=null){
            System.out.println(ptr.name+" "+ptr.rollNo+" "+ptr.age+" "+ptr.grade);
            ptr=ptr.next;
        }
    }
    // delete node from specific position
    static Node deleteSpecificRollNo(Node head, int rollNo){
        Node ptr = head;
        while(ptr.next!=null && ptr.next.rollNo!=rollNo){
            ptr=ptr.next;
        }
        if(ptr.next.rollNo==rollNo){
        ptr.next=ptr.next.next;
        }
        return head;
    }
    //search student by rollno
    static void searchByRollNo(Node head, int rollNo){
        Node ptr = head;
        while(ptr!=null && ptr.rollNo!=rollNo){
            ptr = ptr.next;
        }
        if(ptr==null){
            System.out.println("Invalid");
        }
        else if(ptr.rollNo == rollNo){
            System.out.println("Student with rollno. "+ptr.rollNo+" is "+ptr.name);
        }
        else{
            System.out.println("Student with this rollno is not found");
        }
    }
    //upgrade grade by rollNo
    static void updateGradeByRollno(Node head, int rollNo, char grade){
        Node ptr = head;
        while(ptr!=null && ptr.rollNo!=rollNo){
            ptr = ptr.next;
        }
        if(ptr==null){
            return;
        }
        if(ptr.rollNo == rollNo){
            ptr.grade = grade;
            System.out.println("Grade updated successfully");
        }
        else{
            System.out.println("Student with this rollno is not found");
        }
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Node head = new Node(1,'A', 10,"Akash");
    head.next = new Node(2, 'A', 12, "Vikash");
    head.next.next = new Node(3, 'B', 13, "Naman");
    // calling functions
    head = insertAtFront(head, 4, 'B', 14, "Vivek");
    head = insertAtLast(head, 10, 'F', 15 , "Tejpal");
    head = insertAtSpecificPosition(head , 2 , 11, 'D', 14, "Veerpal");
    head = deleteSpecificRollNo(head, 2);
    searchByRollNo(head, 2);
    updateGradeByRollno(head, 4, 'A');
    printList(head);
    sc.close();
    }
}
