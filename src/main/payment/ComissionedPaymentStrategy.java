package main.payment;

import main.ComissionedEmployee;
import main.Sales;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class ComissionedPaymentStrategy implements PaymentStrategy {

    private final ComissionedEmployee employee;
    private final Sales sales;

    public ComissionedPaymentStrategy(ComissionedEmployee employee, Sales sales) {
        this.employee = employee;
        this.sales = sales;
    }

    @Override
    public void pay() {
        LocalDate now = LocalDate.now();

        // Checking if today is friday for the first time

        if (employee.getLastPayday() == null) {
            if (now.getDayOfWeek() != DayOfWeek.FRIDAY) {
                System.out.println("[COMISSIONADO] Hoje não é sexta-feira!");
                return;
            } else {
                employee.setLastPayday(now);
            }
        } else {
            long diffInDays = DAYS.between(now, employee.getLastPayday());
            if (diffInDays < 14) {
                System.out.println("[COMISSIONADO] Não se passaram 2 semanas desde o último pagamento!");
                return;
            }
        }

        // Filtering sales days in the last two weeks

        List<Double> salesValueFilter = new ArrayList<>();

        for (int i = 0; i < sales.getSalesday().size(); i++) {
            LocalDate saleDay = sales.getSalesday().get(i);
            if (employee.getLastPayday().isAfter(saleDay)) {
                salesValueFilter.add(sales.getSalesvalue().get(i));
            }
        }

        // Calculating earnings

        double earnings = employee.getSalary();
        for (Double value : salesValueFilter) {
            earnings += value * employee.getComission();
        }

        System.out.printf("[COMISSIONADO] Pagando #%d = %.2f\n", employee.getId(), earnings);
        employee.setLastPayday(now);
    }

}
