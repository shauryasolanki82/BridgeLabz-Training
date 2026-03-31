package lambda_expression;
import java.util.function.Consumer;

public class SmartHomeLightingAutomation {
	public static void main(String[] args) {
		Consumer<String> motion = t -> System.out.println("Motion detected: Lights ON in " + t);
		Consumer<String> time = t -> System.out.println("Time trigger: Dim lights in " + t);
		Consumer<String> voice = t -> System.out.println("Voice command: Party mode in " + t);
		motion.accept("Lobby");
		time.accept("Conference Hall");
		voice.accept("Auditorium");
	}
}