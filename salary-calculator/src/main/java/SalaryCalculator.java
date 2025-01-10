public class SalaryCalculator {
    private static final double PENALTY = 0.15; //Penalty rate for skipping 5 or more days
    private static final double SALARY_BASE = 1000.00;
    private static final double SALARY_CAP = 2000.00;
    public static void main(String[] args) {
        
    }
    public double salaryMultiplier(int daysSkipped) {
        return (daysSkipped >= 5) ? 1 - PENALTY : 1;
    }

    public int bonusMultiplier(int productsSold) {
        return (productsSold >= 20) ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double finalSalary = SALARY_BASE * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);
        return (finalSalary > SALARY_CAP) ? SALARY_CAP : finalSalary;
    } 
}
