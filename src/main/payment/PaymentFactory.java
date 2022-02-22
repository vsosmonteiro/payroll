package main.payment;

import main.*;

import java.util.List;

// Padrão de projeto criacional, prover diferentes tipos de objeto dependendo da entrada
public class PaymentFactory {

    private final List<Sales> sales;

    public PaymentFactory(List<Sales> sales) {
        this.sales = sales;
    }

    public PaymentStrategy create(Employee employee) {
        if (employee instanceof ComissionedEmployee) {
            return new ComissionedPaymentStrategy((ComissionedEmployee) employee, sales.get(employee.getId()));
        } else if (employee instanceof HourlyEmployee) {
            return new HourlyPaymentStrategy((HourlyEmployee) employee);
        } else if (employee instanceof SalariedEmployee) {
            return new SalariedPaymentStrategy((SalariedEmployee) employee);
        } else {
            return null;
        }
    }

}
