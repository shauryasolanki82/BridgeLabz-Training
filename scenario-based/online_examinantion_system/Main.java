package scenario_based.online_examinantion_system;

public class Main {
    public static void main(String[] args) {
        System.out.println("MCQ Exam (Objective)");
        EvaluationStrategy objectiveStrats = new ObjectiveEvaluation();
        Exam javaExam = new Exam("Java Basics", objectiveStrats);
        javaExam.addQuestion(new Question("What is the size of int?", "4", 10));
        javaExam.addQuestion(new Question("Is Java OOP? (yes/no)", "yes", 10));
        javaExam.getQuestions().get(0).setUserAnswer("4");
        javaExam.getQuestions().get(1).setUserAnswer("no");
        try {
            javaExam.submitExam(30, 60);
            javaExam.generateResult();
        } catch (ExamTimeExpiredException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Starting Theory Exam (Descriptive Strategy)");
        EvaluationStrategy descStrats = new DescriptiveEvaluation();
        Exam historyExam = new Exam("History", descStrats);
        historyExam.addQuestion(new Question("Explain Polymorphism.", "forms", 20));
        historyExam.getQuestions().get(0).setUserAnswer("Polymorphism means many forms.");
        try {
            System.out.println("Submitting late...");
            historyExam.submitExam(120, 60); 
            historyExam.generateResult();
        } catch (ExamTimeExpiredException e) {
            System.out.println("Submission Failed: " + e.getMessage());
        }
    }
}