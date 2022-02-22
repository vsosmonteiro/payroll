package main;

import java.util.ArrayList;
import java.util.List;

// Padrão de projeto criacional, prover uma única instância de database durante toda a execução do programa
public class EmployeeDatabase {

    private static EmployeeDatabase database;
    private final List<Employee> employees;

    private EmployeeDatabase() {
        this.employees = new ArrayList<>();
    }

    public static EmployeeDatabase getInstance() {
        if (database == null) {
            database = new EmployeeDatabase();
        }
        return database;
    }

    public Employee get(int id) {
        return employees.get(id);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void add(Employee e) {
        this.employees.add(e);
    }

    public int size() {
        return employees.size();
    }

}
