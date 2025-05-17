import java.util.*;

class Investment {
    private int companyId;
    private String companyName;
    private int noOfShares;
    private double valueOfOneShare;

    // Constructor
    public Investment(int companyId, String companyName, int noOfShares, double valueOfOneShare) {
        this.companyId = companyId;
        this.companyName = companyName;
        setNoOfShares(noOfShares);
        this.valueOfOneShare = valueOfOneShare;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNoOfShares() {
        return noOfShares;
    }

    public void setNoOfShares(int noOfShares) {
        if (noOfShares > 0) {
            this.noOfShares = noOfShares;
        } else {
            System.out.println("Shares not available");
        }
    }

    public double getValueOfOneShare() {
        return valueOfOneShare;
    }

    public void setValueOfOneShare(double valueOfOneShare) {
        this.valueOfOneShare = valueOfOneShare;
    }

    public double calculateTotalAmountOfInvestment(int sharesBought) {
        if (sharesBought <= noOfShares) {
            noOfShares -= sharesBought;
            return sharesBought * valueOfOneShare;
        } else {
            System.out.println("Not enough shares available");
            return -1;
        }
    }
}

public class InvestmentCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of companies you are investing in:");
        int companyCount = sc.nextInt();

        for (int i = 0; i < companyCount; i++) {
            System.out.println("Enter the company id:");
            int companyId = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("Enter the company Name:");
            String companyName = sc.nextLine();

            System.out.println("Enter the total number of shares available:");
            int noOfShares = sc.nextInt();

            System.out.println("Enter the value of one share:");
            double valueOfOneShare = sc.nextDouble();

            Investment investment = new Investment(companyId, companyName, noOfShares, valueOfOneShare);

            System.out.println("Enter the number of shares you want to buy:");
            int sharesBought = sc.nextInt();

            if (sharesBought <= investment.getNoOfShares()) {
                System.out.println("Total number of shares before buying = " + investment.getNoOfShares());

                double totalAmountInvestment = investment.calculateTotalAmountOfInvestment(sharesBought);

                if (totalAmountInvestment != -1) {
                    System.out.println("Total amount of investment = " + totalAmountInvestment);
                    System.out.println("Remaining available shares = " + investment.getNoOfShares());
                }
            } else {
                System.out.println("You cannot buy more shares than are available.");
            }
        }
    }
}