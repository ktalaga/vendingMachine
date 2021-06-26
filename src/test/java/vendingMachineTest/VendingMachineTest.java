package vendingMachineTest;

import coinReturn.CoinReturn;
import coins.Coin;
import coins.CoinType;
import drawer.CodeType;
import drawer.Drawer;
import org.junit.Before;
import org.junit.Test;
import products.Crisp;
import products.Drink;
import products.Product;
import products.Sweet;
import vendingMachine.VendingMachine;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private Coin coin_1;
    private Coin coin_2;
    private Coin coin_3;
    private Coin coin_4;
    private Coin coin_5;
    private Coin coin_6;
    private Coin coin_7;
    private Coin coin_8;
    private ArrayList<Coin> coinsReturned;
    private CoinReturn coinReturn;
    private CoinReturn coinReturn_2;
    private Product sweet_1;
    private Product sweet_2;
    private Product sweet_3;
    private Product drink_1;
    private Product crisp_1;
    private ArrayList<Product> stock_1;
    private ArrayList<Product> stock_2;
    private ArrayList<Product> stock_3;
    private Drawer drawer_1;
    private Drawer drawer_2;
    private Drawer drawer_3;
    private VendingMachine vendingMachine;
    private ArrayList<Drawer> drawers;
    private ArrayList<Drawer> drawers_2;
    private ArrayList<Coin> listOfCoinsEntered;
    private ArrayList<Coin> listOfCoinsEntered_2;
    private ArrayList<Coin> till;

    @Before
    public void before(){
        coin_1 = new Coin(CoinType.ONEPENCE);
        coin_2 = new Coin(CoinType.TWOPENCE);
        coin_3 = new Coin(CoinType.FIVEPENCE);
        coin_4 = new Coin(CoinType.TENPENCE);
        coin_5 = new Coin(CoinType.TWENTYPENCE);
        coin_6 = new Coin(CoinType.FIFTYPENCE);
        coin_7 = new Coin(CoinType.ONEPOUND);
        coin_8 = new Coin(CoinType.TWOPOUND);
        coinsReturned = new ArrayList<Coin>();
        coinReturn = new CoinReturn(coinsReturned);
        coinReturn_2 = new CoinReturn(coinsReturned);
        sweet_1 = new Sweet("Mars");
        sweet_2= new Sweet("Mars");
        sweet_3 = new Sweet("Mars");
        drink_1 = new Drink("Coca-cola");
        crisp_1 = new Crisp("Walkers");
        stock_1 = new ArrayList<>();
        stock_2 = new ArrayList<>();
        stock_3 = new ArrayList<>();
        stock_1.add(sweet_1);
        stock_1.add(sweet_2);
        stock_1.add(sweet_3);
        drawer_1 = new Drawer(stock_1, 0.60, CodeType.A1);
        drawer_2 = new Drawer(stock_2, 1.10, CodeType.A2);
        drawer_3 = new Drawer(stock_3, 0.65, CodeType.A3);
        drawer_1.addProductToDrawer(sweet_1);
        drawers = new ArrayList<>();
        drawers_2 = new ArrayList<>();
        drawers.add(drawer_1);
        drawers.add(drawer_2);
        drawers.add(drawer_3);
        drawers_2.add(drawer_1);
        listOfCoinsEntered = new ArrayList<>();
        listOfCoinsEntered_2 = new ArrayList<>();
        till = new ArrayList<>();
        till.add(coin_3);
        till.add(coin_4);
        till.add(coin_5);
        till.add(coin_6);
        till.add(coin_7);
        till.add(coin_8);

        vendingMachine = new VendingMachine(drawers, coinReturn, listOfCoinsEntered, till);
    }

    @Test
    public void hasDrawers() {
        assertEquals(drawers, vendingMachine.getDrawers());
    }

    @Test
    public void canSetDrawers() {
        vendingMachine.setDrawers(drawers_2);
        assertEquals(drawers_2, vendingMachine.getDrawers());
    }

    @Test
    public void hasCoinReturn() {
        assertEquals(coinReturn, vendingMachine.getCoinReturn());
    }

    @Test
    public void canSetCoinReturn() {
        vendingMachine.setCoinReturn(coinReturn_2);
        assertEquals(coinReturn_2, vendingMachine.getCoinReturn());
    }

    @Test
    public void getListOfCoinsEntered() {
        assertEquals(listOfCoinsEntered, vendingMachine.getListOfCoinsEntered());
    }

    @Test
    public void canSetListOfCoinsEntered() {
        vendingMachine.setListOfCoinsEntered(listOfCoinsEntered_2);
        assertEquals(listOfCoinsEntered_2, vendingMachine.getListOfCoinsEntered());
    }

    @Test
    public void getTill() {
        assertEquals(till, vendingMachine.getTill());
    }

    @Test
    public void canCalculateTotalInTill() {
        assertEquals(3.85, vendingMachine.getTotalInTill(), 0.00);
    }

    @Test
    public void canAddCoinsToVendingMachine() {
        vendingMachine.addCoinToVendingMachine(coin_3);
        vendingMachine.addCoinToVendingMachine(coin_8);
        assertEquals(2, vendingMachine.getListOfCoinsEntered().size());
    }

    @Test
    public void canRefuseToAccept1PenceAnd2PenceCoins() {
        vendingMachine.addCoinToVendingMachine(coin_1);
        vendingMachine.addCoinToVendingMachine(coin_2);
        assertEquals(0, vendingMachine.getListOfCoinsEntered().size());
    }

    @Test
    public void canCalculateTotalOfAllCoinsEntered() {
        vendingMachine.addCoinToVendingMachine(coin_3);
        vendingMachine.addCoinToVendingMachine(coin_8);
        assertEquals(2.05, vendingMachine.getTotalOfListOfCoinEntered(), 0.00);
    }

    @Test
    public void canBuyProductIfMoneyInsertedIsEqualToPriceOfProduct() {
        vendingMachine.addCoinToVendingMachine(coin_4);
        vendingMachine.addCoinToVendingMachine(coin_6);
        vendingMachine.buyProduct(CodeType.A1);
        assertEquals(4.45, vendingMachine.getTotalInTill(),0.00);
        assertEquals(sweet_2, vendingMachine.buyProduct(CodeType.A1));

    }

    @Test
    public void cannotBuyIfMoneyInsertedIsLessThanPriceOfProduct() {
        vendingMachine.addCoinToVendingMachine(coin_4);
        vendingMachine.buyProduct(CodeType.A1);
        assertEquals(null, vendingMachine.buyProduct(CodeType.A1));
    }

    @Test
    public void canSetTotalOfCoinsEnteredTo0() {
        vendingMachine.addCoinToVendingMachine(coin_8);
        vendingMachine.setTotalOfCoinsEnteredTo0();
        assertEquals(0.00, vendingMachine.getTotalOfListOfCoinEntered(), 0.00);
    }

    @Test
    public void canVendProduct() {
        vendingMachine.vendProduct(CodeType.A1);
        assertEquals(sweet_2, vendingMachine.vendProduct(CodeType.A1));
    }

    @Test
    public void canGetCoinByTypeFromTill() {
        vendingMachine.getCoinByTypeFromTill(CoinType.FIFTYPENCE);
//        assertEquals(coin_6, vendingMachine.getCoinByTypeFromTill(CoinType.FIFTYPENCE));
        assertEquals(5, vendingMachine.getTill().size());
        assertEquals(3.35, vendingMachine.getTotalInTill(), 0.00);
    }

    @Test
    public void canCalculateChangeToBeReturned() {
        assertEquals(1.40, vendingMachine.calculateChange(2.00, 0.60), 0.00);
    }

    @Test
    public void canReturnChange() {
        vendingMachine.addCoinToVendingMachine(coin_4);
        vendingMachine.buyProduct(CodeType.A1);
//        write a method to get drawer by CodeType and calculate change instead of typing 1.40 in the line below
        vendingMachine.returnChange(1.40);
        assertEquals(0.0, vendingMachine.getCoinReturn().getTotalAmountInCoinReturn(), 0.00);
    }

    @Test
    public void canGetDrawerByCodeType() {
        assertEquals(drawer_1, vendingMachine.getDrawerByCodeType(CodeType.A1));
    }
}
