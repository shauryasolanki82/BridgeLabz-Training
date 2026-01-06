import java.util.*;
public class EduQuiz {
    public static int calculateScore(String[] correctAnswers, String[] studentAnswers, String[] gkQuestions){
        Scanner sc = new Scanner(System.in);
        int i=1;
        int score = 0;
        while(i<=10){
            System.out.println("Question no. "+i+" "+ gkQuestions[i-1]);
            String ans = sc.nextLine();
            studentAnswers[i-1] = ans.toLowerCase();
            if(studentAnswers[i-1].equals(correctAnswers[i-1])){
                 System.out.println("Question no. "+ i +" Correct Answer");
                score++;
            }
            else{
                System.out.println("Question no. "+ i +" Wrong Answer");
            }
            i++;
        }
        sc.close();
        return score;
    }
    public static void main(String[] args) {
        String[] correctAnswers = {"paris", "mahatma gandhi", "mars", "pacific ocean", "alexander graham bell", "bengal tiger", "nile river", "yen", "seven", "carbon dioxide"};
        String[] studentAnswers = new String[10];
        String[] gkQuestions = {
    "What is the capital of France?",
    "Who is known as the Father of the Nation in India?",
    "Which planet is known as the Red Planet?",
    "What is the largest ocean in the world?",
    "Who invented the telephone?",
    "What is the national animal of India?",
    "Which is the longest river in the world?",
    "What is the currency of Japan?",
    "How many continents are there on Earth?",
    "Which gas do plants absorb from the atmosphere?"
     };
    System.out.println("Your total Score is: "+calculateScore(correctAnswers, studentAnswers, gkQuestions));
    }
}
