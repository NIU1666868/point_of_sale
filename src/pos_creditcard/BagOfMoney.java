package pos_creditcard;

import java.util.HashMap;

public class BagOfMoney {
  private HashMap<Double, Integer> moneyInBag = new HashMap<>();
  public double[] denominations = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00};

  BagOfMoney() {
    for (int i = 0; i < denominations.length; i++) {
      moneyInBag.put(denominations[i], 0);
    }
  }

  BagOfMoney(double [] cash, int [] quantities) {
    for (int i = 0; i < cash.length; i++) {
      moneyInBag.put(cash[i], quantities[i]);
    }
  }

  public int getValue(double denomination) {
    return moneyInBag.getOrDefault(denomination, 0);
  }

  public void addDenomination(double cash, int quantity) {
    moneyInBag.put(cash, quantity);
  }

  public boolean contains(BagOfMoney money) {
    for (double denomination : denominations) {
      if (this.getValue(denomination) < money.getValue(denomination)) {
        return false;
      }
    }
    return true;
  }

  public void add(BagOfMoney money){
    for (double denomination : money.moneyInBag.keySet()) {
      int currentQuantity = moneyInBag.getOrDefault(denomination, 0);
      int addedQuantity = money.moneyInBag.getOrDefault(denomination, 0);
      int newQuantity = currentQuantity + addedQuantity;
      addDenomination(denomination, newQuantity);
    }
  }

  public void subtract(BagOfMoney money) {
    for (double denomination : money.moneyInBag.keySet()) {
      int currentQuantity = moneyInBag.getOrDefault(denomination, 0);
      int subtractedQuantity = money.moneyInBag.getOrDefault(denomination, 0);
      int newQuantity = currentQuantity - subtractedQuantity;
      if(newQuantity >= 0) {addDenomination(denomination, newQuantity);}
      else {addDenomination(denomination, 0);}
    }
  }

  public void print() {
    for (double denomination : moneyInBag.keySet()) {
      if (moneyInBag.get(denomination) >= 1) {
        int denominationQuantity = moneyInBag.getOrDefault(denomination, -1);
        System.out.println(denominationQuantity + " of " + denomination);
      }
    }
  }

  public double money(){
    double total = 0;
    for(double denomination: moneyInBag.keySet()) {
      int quantity = moneyInBag.get(denomination);
      total += denomination * quantity;
    }
    return total;
  }

  public int quantityOfDenomination() {
    return denominations.length;
  }
}
