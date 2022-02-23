# Folha de pagamento
## padrões de projeto
- **singleton**: implementado para recuperar a instância de banco de dados dos empregados(em memoria)
	
  referencia: https://github.com/vsosmonteiro/payroll/blob/master/src/main/EmployeeDatabase.java

- **strategy**: implementado para distinguir as diferentes formas de pagamento, dependendo do tipo de empregado

  referencia: https://github.com/vsosmonteiro/payroll/blob/master/src/main/payment/PaymentStrategy.java

- **factory**: implementado para instanciar o strategy de pagamento de acordo com o tipo do funcionario 

  referencia: https://github.com/vsosmonteiro/payroll/blob/master/src/main/payment/PaymentFactory.java
