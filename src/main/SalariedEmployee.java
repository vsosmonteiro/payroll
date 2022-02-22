package main;

public class SalariedEmployee extends Employee {
    int Salary;

    public SalariedEmployee(String name, String address, int type, int id, int fired
            ,int sindicate,int salary) {
        super(name, address, type, id, fired,sindicate);
        this.Salary=salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getSalary() {
        return Salary;
    }
}
