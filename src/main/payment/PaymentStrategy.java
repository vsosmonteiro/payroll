package main.payment;

// Padrão de projeto comportamental, o algoritmo para cálculo de pagamento assume
// diferentes tipos em tempo de execução
public interface PaymentStrategy {
    void pay();
}
