package scenario_based.online_examinantion_system;

import java.util.List;

public class DescriptiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(List<Question> questions) {
        int totalScore = 0;
        for (Question q : questions) {
            if (q.getUserAnswer().toLowerCase().contains(q.getCorrectAnswer().toLowerCase())) {
                totalScore += q.getMarks();
            }
        }
        return totalScore;
    }
}
