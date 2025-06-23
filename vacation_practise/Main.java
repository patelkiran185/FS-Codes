import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    // TODO: Define private fields for name, income, debt, missedPayments
    // TODO: Add constructor, getters, setters
    private String name;
    private double income;
    private double debt;
    private int missedPayments;
    Customer(String name,double income,double debt,int missedPayments){
        this.name=name;
        this.debt=debt;
        this.income=income;
        this.missedPayments=missedPayments;
    }
    String getName(){
        return name;
    }
    void setName(String name){
        this.name=name;
    }
    double getIncome(){
        return income;
    }
    void setIncome(double income){
        this.income=income;
    }
    double getDebt(){
        return debt;
    }
    void setDebt(double debt){
        this.debt=debt;
    }
    int getMissedPayments(){
        return missedPayments;
    }
    void setMissedPayments(int missedPayments){
        this.missedPayments=missedPayments;
    }
    
}

class CreditReport {
    // TODO: Define Customer customer, double score, String riskLevel
    // TODO: Constructor and toString() method
    private Customer customer;
    private double score;
    private String riskLevel;
    CreditReport(Customer customer,double score,String riskLevel){
     this.customer=customer;
     this.score = score;
     this.riskLevel=riskLevel;
    }
    @Override
    public String toString(){
        return "Customer: "+ customer.getName()+", Score:"+score+", Risk Level: "+riskLevel;
    }
}

interface RiskAnalyzer {
    CreditReport analyzeRisk(Customer customer);
}

class CreditRiskAnalyzerImpl implements RiskAnalyzer {
@Override
public CreditReport analyzeRisk(Customer customer) {
    double income = customer.getIncome();
    double debt = customer.getDebt();
    int missedPayments = customer.getMissedPayments();
    
    
    double incomeScore = Math.min(1, income / 100000.0);
    double debtScore = 1 - Math.min(1, debt / 50000.0);
    double missedPaymentsScore = 1 - Math.min(1, missedPayments / 10.0);
    
    
    double finalScore = (0.4 * incomeScore) + (0.4 * debtScore) + (0.2 * missedPaymentsScore);
    finalScore = finalScore * 100;
    
    
    finalScore = Math.round(finalScore * 10.0) / 10.0;
    
    
    String riskLevel;
    if (finalScore >= 80) {
        riskLevel = "Low";
    } else if (finalScore >= 50) {
        riskLevel = "Medium";
    } else {
        riskLevel = "High";
    }
    
    return new CreditReport(customer, finalScore, riskLevel);
}
  
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double income = Double.parseDouble(sc.nextLine());
            double debt = Double.parseDouble(sc.nextLine());
            int missedPayments = Integer.parseInt(sc.nextLine());

            customers.add(new Customer(name, income, debt, missedPayments));
        }

        RiskAnalyzer analyzer = new CreditRiskAnalyzerImpl();

        for (Customer customer : customers) {
            CreditReport report = analyzer.analyzeRisk(customer);
            System.out.println(report);
        }
    }
}