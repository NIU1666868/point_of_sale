package pos_creditcard;

import java.util.HashMap;

public class CashRegister {
  private HashMap<Double, Integer> cashRegisterMoney = new HashMap<>();
  public double[] denominations = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00};

  CashRegister() {
    for (int i = 0; i < denominations.length; i++) {
      cashRegisterMoney.put(denominations[i], 0);
    }
  }

  CashRegister(double [] cash, int [] quantities) {
    for (int i = 0; i < cash.length; i++) {
      cashRegisterMoney.put(cash[i], quantities[i]);
    }
  }

  public int getValue(double denomination) {
    return cashRegisterMoney.getOrDefault(denomination, 0);
  }

  public void addDenomination(double cash, int quantity) {
    cashRegisterMoney.put(cash, quantity);
  }

  public boolean contains(CashRegister money) {
    for (double denomination : money.denominations) {
        if (money.getValue(denomination) <= this.getValue(denomination)) {
          return true;
        }
    }
    return false;
  }

  public void add(CashRegister money){
    for (double denomination : money.cashRegisterMoney.keySet()) {
      int currentQuantity = cashRegisterMoney.getOrDefault(denomination, 0);
      int addedQuantity = money.cashRegisterMoney.getOrDefault(denomination, 0);
      int newQuantity = currentQuantity + addedQuantity;
      addDenomination(denomination, newQuantity);
    }
  }

  public void subtract(CashRegister money) {
    for (double denomination : money.cashRegisterMoney.keySet()) {
      int currentQuantity = cashRegisterMoney.getOrDefault(denomination, 0);
      int subtractedQuantity = money.cashRegisterMoney.getOrDefault(denomination, 0);
      int newQuantity = currentQuantity - subtractedQuantity;
      if(newQuantity >= 0) {addDenomination(denomination, newQuantity);}
      else {addDenomination(denomination, 0);}
    }
  }

  public void printCashRegisterMoney() {
    for (double denomination : cashRegisterMoney.keySet()) {
      int denominationQuantity = cashRegisterMoney.getOrDefault(denomination, -1);
      System.out.println(denomination + " " + denominationQuantity);
    }
  }

  public double isWorth(){
    double total = 0;
    for(double denomination: cashRegisterMoney.keySet()) {
      int quantity = cashRegisterMoney.get(denomination);
      total += denomination * quantity;
    }
    return total;
  }

  public int quantityOfDenomination() {
    return denominations.length;
  }
}
