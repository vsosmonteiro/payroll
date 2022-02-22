package main;

import main.payment.PaymentFactory;
import main.payment.PaymentStrategy;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Menu {
    public static void main(String[] args) {
       int entrada=-1;

       EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance();

       ArrayList<Integer>paymenttime=new ArrayList<>();
       ArrayList<Integer>paymentday=new ArrayList<>();
       ArrayList<Integer>PaymentWeekDay=new ArrayList<>();
       ArrayList<Sales>SalesList= new ArrayList<>();
       Scanner scan=new Scanner(System.in);
        while (entrada != 0) {
            System.out.println("1-adicionar empregado");
            System.out.println("2-remover empregado");
            System.out.println("3-lançar cartão de ponto ");
            System.out.println("4-lançar resultado de venda");
            System.out.println("5-lançar taxa de serviço");
            System.out.println("6-alterar detalhes de empregado");
            System.out.println("7-rodar folha de pagamento");
            System.out.println("8-undo//redo");
            System.out.println("9-agendar pagamento");
            System.out.println("10-novas agendas de pagamento");
            System.out.println("0-fechar programa");
            entrada=scan.nextInt();
            switch (entrada)
            {
                case 1:
                    System.out.println("você escolheu 1");
                   EmployeeFunctions addictioner=new EmployeeFunctions();
                    employeeDatabase.add(addictioner.Addworker(employeeDatabase.size()+1));
                    int paydate=employeeDatabase.get(employeeDatabase.size()-1).id;
                    paymenttime.add(paydate-1);
                    System.out.println(employeeDatabase.size());

                    break;
                case 2:
                    System.out.println("você escolheu 2");
                    System.out.println("digite o id do empregado a ser removido");
                    int remid;
                    remid=(scan.nextInt())-1;
                    if(remid>employeeDatabase.size())
                    {
                        System.out.println("numero invalido");
                    }
                    else
                    {
                        employeeDatabase.get(remid).setFired(1);
                    }
                    break;
                case 3:
                    System.out.println("você escolheu 3");
                    System.out.println("digite o id do empregado para lancar o ponto");
                    remid=(scan.nextInt()-1);
                    System.out.println("digite a quantidade de horas trabalhadas");
                    int workedhours;
                    Employee test;
                    test=employeeDatabase.get(remid);
                    workedhours=scan.nextInt();
                    if(test instanceof HourlyEmployee) {
                        ((HourlyEmployee) test).setTimecard(workedhours);
                    }
                    Employee test2 =employeeDatabase.get(remid);
                    if (test2 instanceof HourlyEmployee)
                    {
                        System.out.println(((HourlyEmployee) test2).getTimecard());
                    }

                    break;
                case 4:
                    System.out.println("você escolheu 4");
                    System.out.println("digite o id do empregado");
                    remid=(scan.nextInt()-1);
                    System.out.println("digite a data da venda");
                    String dateSale;
                    String clean=scan.nextLine();
                    dateSale=scan.nextLine();
                    System.out.println("digite o valor da venda");
                    Double value=scan.nextDouble();
                    if (SalesList.isEmpty())
                    {
                        Sales fkSale=new Sales(remid);
                        SalesList.add(fkSale);
                        System.out.println(fkSale.id);

                    }

                    Sales testeSale = new Sales(-1);

                    int result=testeSale.SearchSales(SalesList,remid);
                    if(result!=-1)
                    {
                        SalesList.get(result).setSalesday(LocalDate.parse(dateSale));
                        SalesList.get(result).setSalesvalue(value);
                        System.out.println(SalesList.get(result));

                    }


                    break;
                case 5:
                    System.out.println("você escolheu 5");
                    System.out.println("digite o id do empregado para lancar a taxa de serviço");
                    remid=(scan.nextInt()-1);
                    Double tax;
                    System.out.println("digite o valor da taxa");
                    tax=scan.nextDouble();
                    employeeDatabase.get(remid).setServicetax(tax);
                    System.out.println(employeeDatabase.get(remid).getServicetax());

                    break;
                case 6:
                    System.out.println("você escolheu 6");
                    System.out.println("digite o id do empregado a ser editado");
                    remid =(scan.nextInt()-1);
                    System.out.println("digite o item a ser editado");
                    String cleaner= scan.nextLine();
                    String editItem=scan.nextLine();
                    System.out.println(editItem);
                    System.out.println("digite o novo valor");
                    String newvalue=scan.next();
                    EmployeeFunctions editer= new EmployeeFunctions();
                    if(employeeDatabase.get(remid).getId()==0)
                    {
                        employeeDatabase.get(remid).equals(editer.EditSalaried((SalariedEmployee) employeeDatabase.get(remid)
                                ,editItem,newvalue));
                    }
                    if(employeeDatabase.get(remid).getId()==1)
                    {
                        employeeDatabase.get(remid).equals(editer.EditHourly((HourlyEmployee) employeeDatabase.get(remid)
                                ,editItem,newvalue));
                        HourlyEmployee testeemp;
                        testeemp= (HourlyEmployee) employeeDatabase.get(0);
                        System.out.println(testeemp.Hourtime);

                    }
                    if (employeeDatabase.get(remid).getId()==2)
                    {
                        employeeDatabase.get(remid).equals(editer.EditComissioned((ComissionedEmployee) employeeDatabase.get(remid)
                                ,editItem,newvalue));
                    }

                    break;
                case 7:
                    System.out.println("você escolheu 7");
                    System.out.println("rodar folha de pagamento");

                    PaymentFactory factory = new PaymentFactory(SalesList);
                    List<PaymentStrategy> payments = new ArrayList<>();

                    System.out.println("Realizando pagamentos...");
                    for (Employee employee : employeeDatabase.getEmployees()) {
                        payments.add(factory.create(employee));
                    }
                    for (PaymentStrategy payment : payments) payment.pay();

                    break;
                case 8:
                    System.out.println("você escolheu 8");
                    break;
                case 9:
                    System.out.println("você escolheu 9");
                    System.out.println("digite o id do empregado");
                    remid =(scan.nextInt()-1);
                    System.out.println(paymenttime.get(remid));
                    System.out.println("digite o novo metodo de pagamento// 0=mensal 1=semanal 2= bi semanal");
                    paydate=scan.nextInt();
                    paymenttime.set(remid, paydate);
                    System.out.println(paymenttime.get(remid));



                    break;
                case 10:
                    System.out.println("você escolheu 10");
                    System.out.println("digite a agenda de pagamento");
                    clean =scan.nextLine();
                    String agendaOfPay=scan.nextLine();
                    System.out.println("digite o id do empregado");
                    remid=(scan.nextInt()-1);
                    String [] words=agendaOfPay.split(" ",3);
                    int time,day,weekday;


                    if(words[1].equals("mensal"))
                    {
                        paymenttime.set(remid,0);
                        time=1;
                        if(words[2].equals("$"))
                        {
                            day=999;
                        }
                        else
                        {
                            day=Integer.parseInt(words[2]);
                        }

                    }
                    else {

                        if(words[3].equals("segunda"))weekday=0;
                        if(words[3].equals("terça"))weekday=1;
                        if(words[3].equals("quarta"))weekday=2;
                        if(words[3].equals("quinta"))weekday=3;
                        if(words[3].equals("sexta"))weekday=4;

                        if (words[1].equals("semanal") && words[2].equals("1")) {
                            time = 2;
                            paymenttime.set(remid,1);
                        }

                        if (words[1].equals("semanal") && words[2].equals("2")) {
                            paymenttime.set(remid,2);
                            time = 3;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }


}
