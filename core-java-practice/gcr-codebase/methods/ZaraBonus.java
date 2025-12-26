package methods;

public class ZaraBonus {

    public static double[][] generateEmployeeData() {
        double[][] data = new double[10][2];
        
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (int)(Math.random() * 90000) + 10000; 
            data[i][1] = (int)(Math.random() * 11); 
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] empData) {
        double[][] financials = new double[10][2];
        for (int i = 0; i < empData.length; i++) {
            double currentSalary = empData[i][0];
            double yearsService = empData[i][1];
            double bonusPercentage;
            if (yearsService > 5) {
                bonusPercentage = 0.05; // 5%
            } else {
                bonusPercentage = 0.02; // 2%
            }
            double bonusAmount = currentSalary * bonusPercentage;
            double newSalary = currentSalary + bonusAmount;
            financials[i][0] = newSalary;   
            financials[i][1] = bonusAmount; 
        }
        return financials;
    }

    public static void display(double[][] empData, double[][] finData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        System.out.printf("%-10s %-15s %-10s %-15s %-15s%n", "Emp ID", "Old Salary", "Years", "Bonus Amt", "New Salary");
        for (int i = 0; i < 10; i++) {
            double oldSal = empData[i][0];
            double years = empData[i][1];
            double newSal = finData[i][0];
            double bonus = finData[i][1];
            totalOldSalary += oldSal;
            totalNewSalary += newSal;
            totalBonus += bonus;
            System.out.printf("%-10d %-15.2f %-10.0f %-15.2f %-15.2f%n", 
                    (i + 1), oldSal, years, bonus, newSal);
        System.out.printf("Total Old Salary Payout:  %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Payout:       %.2f%n", totalBonus);
        System.out.printf("Total New Salary Payout:  %.2f%n", totalNewSalary);
        System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData();
        double[][] financialData = calculateBonusAndNewSalary(employeeData);
        display(employeeData, financialData);
    }
}
