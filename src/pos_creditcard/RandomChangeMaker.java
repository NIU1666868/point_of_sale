package pos_creditcard;
import java.util.Random;

public class RandomChangeMaker extends ChangeMaker {

  @Override
  public BagOfMoney makeChange(double amount) {
    BagOfMoney moneySub = new BagOfMoney();
    Random random = new Random();
    int pos;
    int min = 0;
    int max = moneySub.quantityOfDenomination() - 1;
    while (amount != 0) {
      pos = random.nextInt((max - min) + 1) + min;
      double money = moneySub.denominations[pos];
      if (money <= amount) {
        amount -= money;
        moneySub.addDenomination(money, moneySub.getValue(money) + 1);
      }
    }
    return moneySub;
  }
}