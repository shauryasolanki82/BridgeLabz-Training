package scenario_based.online_examinantion_system;
import java.util.List;

public class ObjectiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(List<Question> questions) {
        int totalScore = 0;
        for (Question q : questions) {
            if (q.getUserAnswer().equalsIgnoreCase(q.getCorrectAnswer())) {
                totalScore += q.getMarks();
            }
        }
        return totalScore;
    }
}
