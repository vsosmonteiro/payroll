package main;

public class ComissionedEmployee extends Employee {
    int Salary;
    double comission;

    public ComissionedEmployee(String name, String address, int type, int id, int fired
            ,int sindicate,int salary,double comission)
    {
        super(name, address, type, id, fired,sindicate);
        this.Salary=salary;
        this.comission=comission;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    public int getSalary() {
        return Salary;
    }

    public double getComission() {
        return comission;
    }
}
