package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /*
        20. Описать в виде класса калькулятор для расчета платежей по кредиту.
        Кредит задается параметрами: сумма кредита, срок кредита в месяцах, фиксированная
        процентная ставка, способ погашения кредита (дифференцированные платежи /
        аннуитетные платежи). Класс должен позволять задать каждый их этих параметров, а
        также рассчитать сумму платежей в n-ый по счету месяц, а таже общую суммы платежей
        по кредиту.
        Интерфейс может быть консольным.
     */

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите сумму кредита: ");
        calc.setCreditAmount(Double.parseDouble(bufferedReader.readLine()));
        System.out.println("Введите срок кредита в месяцах: ");
        calc.setCreditTerm(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Введите фиксированную процентную ставку:");
        calc.setPercent(Double.parseDouble(bufferedReader.readLine()));
        System.out.println("Введите способ погашения кредита ('1' - если дифференцированный платёж " +
                "или '0' - если аннуитетный платёж):");
        calc.setLoanRepaymentMethod(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("Введите № месяца:");
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Платёж по кредиту в " + n + " месяц = " + Calculator.sumN(calc, n));
        System.out.println("Общая сумма платежей по кредиту = " + Calculator.sum(calc));
    }
}
