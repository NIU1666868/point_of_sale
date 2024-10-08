package pos_creditcard;

public abstract class Payment {
  protected double amountToPay;

  public Payment(double amountToPay) {
    this.amountToPay = amountToPay;
  }

  public abstract void print();

  public abstract BagOfMoney change(String option);
}
