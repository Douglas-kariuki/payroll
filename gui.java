import java.util.Scanner;

public class PayrollCalculator {
    private String employeeName;
    private double ratePerHour;
    private double hoursPerDay;
    private int daysWorked;
    private final double taxRate = 0.15;
    private final double philhealthRate = 0.05;
    private final double sssRate = 0.02;

    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter employee's name (Registration Number): ");
        employeeName = scanner.nextLine();

        System.out.print("Enter rate per hour: ");
        ratePerHour = scanner.nextDouble();

        System.out.print("Enter hours per day: ");
        hoursPerDay = scanner.nextDouble();

        System.out.print("Enter number of days worked: ");
        daysWorked = scanner.nextInt();
    }

    public void calculateSalary() {
        double grossSalary = ratePerHour * hoursPerDay * daysWorked;
        double taxDeduction = grossSalary * taxRate;
        double philhealthDeduction = grossSalary * philhealthRate;
        double sssDeduction = grossSalary * sssRate;
        double netSalary = grossSalary - taxDeduction - philhealthDeduction - sssDeduction;

        displaySalary(grossSalary, netSalary);
    }

    public void displaySalary(double grossSalary, double netSalary) {
        System.out.println("\nPayroll Summary:");
        System.out.println("Employee Name: " + employeeName);
        System.out.printf("Gross Salary: $%.2f%n", grossSalary);
        System.out.printf("Tax Deduction (15%%): $%.2f%n", taxRate * grossSalary);
        System.out.printf("Philhealth Deduction (5%%): $%.2f%n", philhealthRate * grossSalary);
        System.out.printf("SSS Deduction (2%%): $%.2f%n", sssRate * grossSalary);
        System.out.printf("Net Salary: $%.2f%n", netSalary);
    }

    public static void main(String[] args) {
        PayrollCalculator payrollCalculator = new PayrollCalculator();
        payrollCalculator.getInput();
        payrollCalculator.calculateSalary();
    }
}
