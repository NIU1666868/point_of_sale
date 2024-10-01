package pos_creditcard;
import java.util.HashMap;

abstract class ChangeMaker {
  protected HashMap<Double, Integer> denominations = new HashMap<>();; //Key=Cash, Value=Quantity
  protected double[] denominationCash = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, //Default cash
                                        2.00, 5.00, 10.00, 20.00, 50.00};

  ChangeMaker() {
    for (int i = 0; i < denominationCash.length; i++) {
      denominations.put(denominationCash[i], 0);
    }
  }

  ChangeMaker(double [] cash, int [] quantities) {
    for (int i = 0; i < cash.length; i++) {
      denominations.put(cash[i], quantities[i]);
    }
  }

  public void addDenomination(double cash, int quantity) {
    denominations.put(cash, quantity);
  }

  public int getNumDenomination() {return denominations.size();}

  public int getQuantity(int index) {
    return denominations.getOrDefault(denominationCash[index], -1);
  }

  public double getCash(int index) {
    return denominationCash[index];
  }

  public abstract void change(double moneyChange);
}
