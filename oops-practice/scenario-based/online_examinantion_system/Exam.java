package scenario_based.online_examinantion_system;
import java.util.*;

public class Exam {
    private String subject;
    private List<Question> questions;
    private EvaluationStrategy strategy;
    private boolean isFinished;

    public Exam(String subject, EvaluationStrategy strategy) {
        this.subject = subject;
        this.strategy = strategy;
        this.questions = new ArrayList<>();
        this.isFinished = false;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void submitExam(long timeTakenSeconds, long timeLimitSeconds) throws ExamTimeExpiredException {
        if (timeTakenSeconds > timeLimitSeconds) {
            throw new ExamTimeExpiredException("Submission Rejected. Time Limit (" + timeLimitSeconds + "s) Exceeded.");
        }
        
        isFinished = true;
        System.out.println("Exam Submitted Successfully for subject: " + subject);
    }

    public void generateResult() {
        if (!isFinished) {
            System.out.println("Exam not yet submitted.");
            return;
        }
        int score = strategy.evaluate(questions);
        System.out.println("Result: " + score + " marks.");
    }
}
