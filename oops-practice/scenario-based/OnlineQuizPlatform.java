import java.util.*;

class InvalidQuizSubmissionException extends Exception {
	public InvalidQuizSubmissionException(String message) {
		super(message);
	}
}

class ResultProcessor {
	private String[] correctAnswers;
	private List<Integer> userScores;
	ResultProcessor(String[] correctAnswers) {
		this.correctAnswers = correctAnswers;
		this.userScores = new ArrayList<>();
	}

	public int processSubmission(String[] userAnswers) throws InvalidQuizSubmissionException {
		if (userAnswers == null || userAnswers.length != correctAnswers.length) {
			throw new InvalidQuizSubmissionException("Submission invalid: Expected " + correctAnswers.length
					+ " answers, but received " + (userAnswers == null ? 0 : userAnswers.length));
		}
		int score = 0;
		for (int i = 0; i < correctAnswers.length; i++) {
			if (userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
				score++;
			}
		}
		userScores.add(score);
		return score;
	}

	public String determineGrade(int score) {
		double percentage = ((double) score / correctAnswers.length) * 100;
		if (percentage >= 90)
			return "A";
		else if (percentage >= 80)
			return "B";
		else if (percentage >= 70)
			return "C";
		else if (percentage >= 60)
			return "D";
		else
			return "F";
	}

	public List<Integer> getAllScores() {
		return userScores;
	}
}

public class OnlineQuizPlatform {
	public static void main(String[] args) {
		String[] answerKey = { "A", "B", "C", "D", "A" };
		ResultProcessor processor = new ResultProcessor(answerKey);
		System.out.println("--- Online Quiz Result Processor ---\n");

		try {
			String[] user1Answers = { "A", "B", "C", "D", "A" };
			int score = processor.processSubmission(user1Answers);
			String grade = processor.determineGrade(score);
			System.out.println("User 1 Score: " + score + "/" + answerKey.length + " | Grade: " + grade);
		} catch (InvalidQuizSubmissionException e) {
			System.err.println(e.getMessage());
		}

		try {
			System.out.println("\nProcessing User 3 (Incomplete submission)...");
			String[] user3Answers = { "A", "B" }; // Missing answers
			int score = processor.processSubmission(user3Answers);
			System.out.println("User 3 Score: " + score);
		} catch (InvalidQuizSubmissionException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("All Recorded Scores: " + processor.getAllScores());
	}
}