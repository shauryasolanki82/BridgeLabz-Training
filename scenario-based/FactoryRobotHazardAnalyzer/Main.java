import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RobotSafetyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Arm Presicion (0.0-1.0)");
        double armPrecision = sc.nextDouble();
        System.out.println("Enter Worker Density (1-20)");
        int workerDensity = sc.nextInt();
        System.out.println("Enter Machinery State (Worn/Faulty/Critical");
        String machineryState = sc.next();
        RobotHazardAuditor rha = new RobotHazardAuditor();
        double output = rha.CalculateHazardRisk(armPrecision, workerDensity, machineryState);
        System.out.println("Robot Hazard Risk Score: "+output);
        sc.close();
    }
}
