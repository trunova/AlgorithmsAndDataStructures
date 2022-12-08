package com.company;

public class Calculator {
    double creditAmount; //сумма кредита
    int creditTerm;      // время в месяцах
    double percent;      // %
    int loanRepaymentMethod; // вид кредита

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount){
        this.creditAmount = creditAmount;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm){
        this.creditTerm = creditTerm;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent){
        this.percent = percent;
    }

    public int getLoanRepaymentMethod() {
        return loanRepaymentMethod;
    }

    public void setLoanRepaymentMethod(int loanRepaymentMethod){
        this.loanRepaymentMethod = loanRepaymentMethod;
    }

    public Calculator(int loanRepaymentMethod, double percent, int creditTerm, double creditAmount){
        this.loanRepaymentMethod = loanRepaymentMethod;
        this.percent = percent;
        this.creditTerm = creditTerm;
        this.creditAmount = creditAmount;
    }
    public Calculator(){}
  //  public static double sum(String loanRepaymentMethod, double percent, int creditTerm, double creditAmount){
  public static double sum(Calculator calc){
      double sum = 0;
        if (calc.loanRepaymentMethod == 1){
            for (int i = 1; i <= calc.creditTerm; i++) {
                sum += sumN(calc, i);
            }
        }
        if (calc.loanRepaymentMethod == 0){
            sum = calc.creditTerm * sumN(calc, 0);
        }
        return sum;
    }

    public static double sumN(Calculator calculator, int n){
        double sum = 0;
        double i = calculator.percent / 1200; // месячная % ставка
        if (calculator.loanRepaymentMethod == 1){
            double b = calculator.creditAmount / calculator.creditTerm; // основной ежемесячный размер платежа
            double s = calculator.creditAmount - (b * (n - 1)); // текущий остаток задолжности
            sum = s * (i) + b;
        }
        if (calculator.loanRepaymentMethod == 0){
            double p = 1;
            for (int j = 0; j < calculator.creditTerm; j++) {
                p *= (1 + i);
            }
            sum = calculator.creditAmount * i * p / (p - 1);
        }
        return sum;
    }
}
