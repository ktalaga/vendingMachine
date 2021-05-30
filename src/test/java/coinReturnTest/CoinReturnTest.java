package coinReturnTest;

import coinReturn.CoinReturn;
import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    private Coin coin_1;
    private Coin coin_2;
    private Coin coin_3;
    private Coin coin_4;
    private Coin coin_5;
    private Coin coin_6;
    private Coin coin_7;
    private Coin coin_8;
    private ArrayList<Coin> till;
    private CoinReturn coinReturn;

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
        till = new ArrayList<Coin>();
        coinReturn = new CoinReturn(till);
    }

    @Test
    public void hasTill(){
        assertEquals(till, coinReturn.getTill());
    }

    @Test
    public void refuseToAddOnePennyAndTwoPennyCoins(){
        coinReturn.addCoinToCoinReturn(coin_1);
        coinReturn.addCoinToCoinReturn(coin_2);
        assertEquals(0, coinReturn.getTill().size());

    }

    @Test
    public void canAddCoinsToCoinReturn() {
        coinReturn.addCoinToCoinReturn(coin_3);
        coinReturn.addCoinToCoinReturn(coin_4);
        coinReturn.addCoinToCoinReturn(coin_5);
        coinReturn.addCoinToCoinReturn(coin_6);
        coinReturn.addCoinToCoinReturn(coin_7);
        coinReturn.addCoinToCoinReturn(coin_8);
        assertEquals(6, coinReturn.getTill().size());
    }

    @Test
    public void canCalculateTotalInCoinReturn() {
        coinReturn.addCoinToCoinReturn(coin_3);
        coinReturn.addCoinToCoinReturn(coin_4);
        coinReturn.addCoinToCoinReturn(coin_5);
        coinReturn.addCoinToCoinReturn(coin_6);
        coinReturn.addCoinToCoinReturn(coin_7);
        coinReturn.addCoinToCoinReturn(coin_8);
        assertEquals(3.85, coinReturn.getTotalAmountInCoinReturn(), 0.00);
    }
}
