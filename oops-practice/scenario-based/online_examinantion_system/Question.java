package scenario_based.online_examinantion_system;

public class Question {
    private String questionText;
    private String correctAnswer;
    private String userAnswer;
    private int marks;

    public Question(String questionText, String correctAnswer, int marks) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
        this.userAnswer = ""; // Default empty
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getUserAnswer() { return userAnswer; }
    public String getCorrectAnswer() { return correctAnswer; }
    public int getMarks() { return marks; }
    
    @Override
    public String toString() {
        return "Q: " + questionText + " [Marks: " + marks + "]";
    }
}
