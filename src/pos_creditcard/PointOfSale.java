package pos_creditcard;

import java.util.ArrayList;


public class PointOfSale {
  private ProductCatalog productCatalog;
  private ArrayList<Sale> sales;
  private int idLastSale = 0;
  private final String FILE_NAME = "src/pos/catalog.txt";
  private BagOfMoney cashRegister;

  public PointOfSale() {
    productCatalog = new ProductCatalog(FILE_NAME);
    sales = new ArrayList<>();
    double[] money = {10., 20., 5., 2., 1., 0.50, 0.20, 0.10, 0.01, 0.02, 0.05};
    int[] quantity = {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99};
    cashRegister = new BagOfMoney(money, quantity);
    System.out.println("\ncash box initially loaded with ");
    cashRegister.print();
    System.out.println("\n");
  }

  public int makeNewSale() {
    idLastSale++;
    Sale newSale = new Sale(idLastSale);
    sales.add(newSale);
    return idLastSale;
  }

  public void addLineItemToSale(int idSale, String productName, int quantity) {
    ProductSpecification productSpecification = productCatalog.searchByName(productName);
    Sale sale = searchSaleById(idSale);
    sale.addLineItem(productSpecification, quantity);
  }

  private Sale searchSaleById(int id) {
    for (Sale s : sales) {
      if (s.getId() == id) {
        return s;
      }
    }
    return null;
  }

  public void printReceiptOfSale(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printReceipt();
  }

  public void payOneSaleCash(int saleId, BagOfMoney amountHanded, String option) {
    Sale sale = searchSaleById(saleId);
    BagOfMoney change = sale.payCash(amountHanded, cashRegister, option);
    if (sale.isPaid()) {
      updateCashRegister(amountHanded, change);
      System.out.println("\nafter payment and giving change the cash box has");
      cashRegister.print();
    }
    else {System.out.printf("Can't make payment\n");}
  }

  public void payOneSaleCreditCard(int saleId, String ccnumber) {
    Sale sale = searchSaleById(saleId);
    sale.payCreditCard(ccnumber);
  }

  public void printPayment(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printPayment();
  }

  public void updateCashRegister(BagOfMoney amount, BagOfMoney change) {
    cashRegister.subtract(change);
    cashRegister.add(amount);
  }

  public boolean isSalePaid(int id) {
    return searchSaleById(id).isPaid();
  }

  // this is for the user interface
  public ArrayList<String> getProductNames() {
    return productCatalog.getProductNames();
  }
}

