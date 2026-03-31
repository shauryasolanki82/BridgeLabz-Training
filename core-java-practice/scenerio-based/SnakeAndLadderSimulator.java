import java.util.Scanner;

public class SnakeAndLadderSimulator {
    static int rollTheDice(){
        return (int) (Math.random()*6)+1;
    }
    static String checkForOption(){
        int val=(int) (Math.random()*3);
        return val==0?"No Play":val==1?"Ladder":"Snake";
    }
    static void forOnePlayer(){
        int startPosition=0;
        int count=0;
        System.out.println("Initial position: "+startPosition);
        System.out.print("Position after every role: ");
        while(startPosition!=100){
            int diceValue=rollTheDice();
            count++;
            String option=checkForOption();
            switch(option){
                case "No Play":
                    break;
                case "Ladder":
                    if(startPosition+diceValue>100) break;
                    startPosition+=diceValue;
                    break;
                case "Snake":
                    startPosition-=diceValue;
                    if(startPosition<0) startPosition=0;
                    break;
            }
            System.out.print(startPosition+" ");
        }
        System.out.println("\nTotal number of dice rolls: "+count);
    }
    static int calculatePosition(int position){
        if(position == 100) {
            return 100;
        }
        int diceValue=rollTheDice();
        String option=checkForOption();
        switch(option){
            case "No Play":
                break;
            case "Ladder":
                if(position+diceValue>100) break;
                position+=diceValue;
                return calculatePosition(position);
            case "Snake":
                position-=diceValue;
                if(position<0) position=0;
                break;
        }
        return position;
    }
    static void forTwoPlayer(){
        int player1Position=0;
        int player2Position=0;
        boolean isPlayer1Turn=true;
        while(player1Position!=100 && player2Position!=100){
            if(isPlayer1Turn) {
                player1Position = calculatePosition(player1Position);
            } else {
                player2Position = calculatePosition(player2Position);
            }
            isPlayer1Turn = !isPlayer1Turn;
        }
        if(player1Position==100){
            System.out.println("Player 1 won the game");
        }else{
            System.out.println("Player 2 won the game");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of players 1 or 2: ");
        int numberOfPlayer=sc.nextInt();
        if(numberOfPlayer==1){
            forOnePlayer();
        }else{
            forTwoPlayer();
        }
    }
}
