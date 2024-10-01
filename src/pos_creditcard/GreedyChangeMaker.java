package pos_creditcard;

public class GreedyChangeMaker{

  public void change(double moneyChange) {

    while (moneyChange != 0)
    {
      for (int i = denominationCash.length() - 1; i >= 0; i--)
      {
        if (denominationCash[i] <= moneyChange && denominations[i].value != 0)
        {
          moneyChange = moneyChange - denominationCash[i];
          updateCashRegister(denominationCash[i]);
          break;
        }
      }
    }

  }
}
