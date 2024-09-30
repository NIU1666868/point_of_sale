package pos_creditcard;
import java.util.Random;

public class RandomChangeMaker extends ChangeMaker {

  @Override
  public void change(double moneyChange) {
    // Define the range for random selection of denominations
    int min = 0;
    int max = getNumDenomination() - 1;
    Random random = new Random();
    // While there is still change to be given
    while (moneyChange != 0) {
      // Generate a random index between min and max
      int i = random.nextInt((max - min) + 1) + min;
      // Check if there is a denomination available at the random index
      // and if the cash at that index is less than or equal to the remaining change
      if (getQuantity(i) > 0 && getCash(i) <= moneyChange) {
        moneyChange -= getCash(i);
      }
    }
  }
}
