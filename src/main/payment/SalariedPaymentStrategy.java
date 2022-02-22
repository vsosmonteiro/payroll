package main.payment;

import main.SalariedEmployee;

import java.util.Calendar;

public class SalariedPaymentStrategy implements PaymentStrategy {

    private final SalariedEmployee employee;

    public SalariedPaymentStrategy(SalariedEmployee employee) {
        this.employee = employee;
    }

    @Override
    public void pay() {
        if (!isLastWorkingDay()) {
            System.out.println("[ASSALARIADO] Não é o último dia útil do mês!");
            return;
        }

        System.out.printf("[ASSALARIADO] Pagando #%d = R$ %d\n", employee.getId(), employee.getSalary());
    }

    private static boolean isLastWorkingDay() {
        Calendar lastWorkingDay = Calendar.getInstance();
        lastWorkingDay.set(Calendar.DAY_OF_MONTH, lastWorkingDay.getActualMaximum(Calendar.DAY_OF_MONTH));

        while (!(lastWorkingDay.get(Calendar.DAY_OF_WEEK) >= 2 && lastWorkingDay.get(Calendar.DAY_OF_WEEK) <= 6)) {
            lastWorkingDay.add(Calendar.DAY_OF_MONTH, -1);
        }

        Calendar target = Calendar.getInstance();

        return lastWorkingDay.get(Calendar.YEAR) == target.get(Calendar.YEAR)
            && lastWorkingDay.get(Calendar.MONTH) == target.get(Calendar.MONTH)
            && lastWorkingDay.get(Calendar.DAY_OF_MONTH) == target.get(Calendar.DAY_OF_MONTH);
    }

}
