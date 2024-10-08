package pos_creditcard;

public class PaymentInCash extends Payment {
  BagOfMoney amountHanded;
  BagOfMoney change;

  public PaymentInCash(BagOfMoney amountHanded, double amountToPay) {
    super(amountToPay);
    assert amountHanded.money() >= amountToPay;
    this.amountHanded = amountHanded;
  }

  public BagOfMoney change(String option) {
    ChangeMaker changeMaker;
    if (option.equals("greedy")) {changeMaker = new GreedyChangeMaker();}
    else {changeMaker = new RandomChangeMaker();}
    double amount = amountHanded.money() - amountToPay;
    System.out.printf("money handed \n" );
    amountHanded.print();
    System.out.printf("\nadded payment to cash box\n");
    amountHanded.print();
    System.out.printf("\ntotal to pay "+ amountToPay + ", change to give " + amount);
    change = changeMaker.makeChange(amount);
    return change;
  }

  @Override
  public void print() {

    amountHanded.print();
    change.print();
  }
}
