package scenario_based.inventory_management_system;

public class EmailAlertService implements AlertService {
    @Override
    public void sendAlert(String message) {
        System.out.println("[EMAIL ALERT]: " + message);
    }
}
