package pos_creditcard;

public class GreedyChangeMaker extends ChangeMaker {

  public BagOfMoney makeChange(double amount) {
    BagOfMoney moneySub = new BagOfMoney();
    int pos = moneySub.quantityOfDenomination() - 1;
    while (amount != 0 && pos >= 0) {
      double money = moneySub.denominations[pos];
        while (money <= amount) {
          amount -= money;
          moneySub.addDenomination(money, moneySub.getValue(money) + 1);
        }
      pos--;
    }
    return moneySub;
  }
}
