package main.payment;

import main.HourlyEmployee;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HourlyPaymentStrategy implements PaymentStrategy {

    private final HourlyEmployee employee;

    public HourlyPaymentStrategy(HourlyEmployee employee) {
        this.employee = employee;
    }

    @Override
    public void pay() {
        LocalDate now = LocalDate.now();

        if (employee.getLastPayday() == null) {
            if (now.getDayOfWeek() != DayOfWeek.FRIDAY) {
                System.out.println("[HORISTA] Não se passou 1 semana desde o último pagamento!");
                return;
            } else {
                employee.setLastPayday(now);
            }
        }

        // Calculating earnings

        double earnings = 0.0;
        for (Integer timecard : employee.getTimecard()) {
            earnings += timecard * employee.getHourtime();
        }

        System.out.printf("[HORISTA] Pagando #%d = %.2f\n", employee.getId(), earnings);

        employee.getTimecard().clear();
        employee.setLastPayday(now);
    }

}
