package designpatterns.solid;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        PaymentMethod debitCardPayment = new DebitCardPayment();
        PaymentMethod paypalPayment = new PayPalCardPayment();
        paymentProcessor.processPayment(debitCardPayment, 100.00);
        paymentProcessor.processPayment(paypalPayment, 55.00);

    }
}
abstract class PaymentMethod {
    abstract void pay(double amount);
}

class PaymentProcessor {
    void processPayment(PaymentMethod paymentMethod, double amout) {
        paymentMethod.pay(amout);
    }
}

class DebitCardPayment extends PaymentMethod {
    @Override
    void pay(double amount) {
        System.out.println("Payment of "+ amount + " was made via Debit Card Payment Process ");
    }
}

class PayPalCardPayment extends PaymentMethod {

    @Override
    void pay(double amount) {
        System.out.println("Payment of "+ amount + " was made via Paypal");
    }
}

