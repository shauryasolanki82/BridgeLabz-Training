package scenario_based.online_examinantion_system;
import java.util.List;

public interface EvaluationStrategy {
    int evaluate(List<Question> questions);
}
