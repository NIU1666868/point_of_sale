package pos_creditcard;

public class GreedyChangeMaker extends ChangeMaker {

  public CashRegister makeChange(double moneyChange) {
    CashRegister moneySub = new CashRegister();
    int pos = moneySub.quantityOfDenomination() - 1;
    while (moneyChange != 0 && pos >= 0) {
      double money = moneySub.denominations[pos];
        while (money <= moneyChange) {
          moneyChange = moneyChange - money;
          moneySub.addDenomination(money, moneySub.getValue(money) + 1);
        }
      pos--;
    }
    return moneySub;
  }
}
