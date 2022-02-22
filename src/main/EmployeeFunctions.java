package main;

import java.util.Scanner;
public class EmployeeFunctions {
    public Employee Addworker(int eid) {
        Scanner scan = new Scanner(System.in);
        int etype;
        String ename;
        int eSalary;
        int esindicate;
        String eaddress;
        System.out.println("digite o nome do empregado");
        ename = scan.nextLine();
        System.out.println("digite o salario do empregado //se horista o valor da hora");
        eSalary = Integer.parseInt(scan.nextLine());
        System.out.println("digite se o empregado participa de sindicato 1- participa//0-nao participa");
        esindicate = Integer.parseInt(scan.nextLine());
        System.out.println("digite o endereço do empregado");
        eaddress = scan.nextLine();
        System.out.println("digite o tipo do empregado: 0-assalariado//1-horista//2-comissionado");
        etype = Integer.parseInt(scan.nextLine());
        if (etype == 0) {
            SalariedEmployee novoEmployee = new SalariedEmployee(ename, eaddress, etype,
                    eid, 0, esindicate, eSalary);
            return novoEmployee;
        }
        if (etype == 1) {
            HourlyEmployee novoEmployee = new HourlyEmployee(ename, eaddress, etype,
                    eid, 0, esindicate, eSalary);
            return novoEmployee;
        }

        System.out.println("digite a porcentagem da comissão");
        double comission;
        comission = Double.parseDouble(scan.nextLine());
        ComissionedEmployee novoEmployee = new ComissionedEmployee(ename, eaddress, etype,
                eid, 0, esindicate, eSalary, comission);
        return novoEmployee;


    }

    public SalariedEmployee EditSalaried(SalariedEmployee employee, String change, String newdata) {

        {

            System.out.println(change);
            if (change.equals("nome")) {
                employee.setName(newdata);

            }
            if (change.equals("endereço") || change.equals("endereco")) {
                employee.setAddress(newdata);
            }
            if (change.equals("salario")) {

                ((SalariedEmployee) employee).setSalary(Integer.parseInt(newdata));
            }
            if (change.equals("sindicato")) {

                employee.setSindicate(Integer.parseInt(newdata));
            }
            if (change.equals("tipo")) {
                employee.setType(Integer.parseInt(newdata));

            }


        }

        return employee;

    }


    public HourlyEmployee EditHourly(HourlyEmployee employee, String change, String newdata) {
        System.out.println("aqui");
        if (change.equals("nome")) {
            employee.setName(newdata);

        }
        if (change.equals("endereço") || change.equals("endereco")) {
            employee.setAddress(newdata);
        }
        if (change.equals("sindicato")) {

            employee.setSindicate(Integer.parseInt(newdata));
        }
        if (change.equals("tipo")) {
            employee.setType(Integer.parseInt(newdata));

        }
        if (change.equals("valorhora")) {
            System.out.println("aqui2");

            employee.setHourtime(Integer.parseInt(newdata));
        }
        return employee;
    }


    public ComissionedEmployee EditComissioned(ComissionedEmployee employee, String change, String newdata) {
        System.out.println(change);
        if (change.equals("nome")) {
            employee.setName(newdata);

        }
        if (change.equals("endereço") || change.equals("endereco")) {
            employee.setAddress(newdata);
        }
        if (change.equals("salario")) {

             employee.setSalary(Integer.parseInt(newdata));
        }
        if (change.equals("sindicato")) {

            employee.setSindicate(Integer.parseInt(newdata));
        }
        if (change.equals("tipo")) {
            employee.setType(Integer.parseInt(newdata));

        }
        if(change.equals("comissão")|| change.equals("comissao"))
        employee.setComission(Double.parseDouble(newdata));
        return employee;
    }

}