package coinTest;

import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    private Coin coin_1;
    private Coin coin_2;
    private Coin coin_3;
    private Coin coin_4;
    private Coin coin_5;
    private Coin coin_6;
    private Coin coin_7;
    private Coin coin_8;

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
    }

    @Test
    public void hasType() {
        assertEquals(CoinType.ONEPENCE, coin_1.getCoinType());
        assertEquals(CoinType.TWOPENCE, coin_2.getCoinType());
        assertEquals(CoinType.FIVEPENCE, coin_3.getCoinType());
        assertEquals(CoinType.TENPENCE, coin_4.getCoinType());
        assertEquals(CoinType.TWENTYPENCE, coin_5.getCoinType());
        assertEquals(CoinType.FIFTYPENCE, coin_6.getCoinType());
        assertEquals(CoinType.ONEPOUND, coin_7.getCoinType());
        assertEquals(CoinType.TWOPOUND, coin_8.getCoinType());
    }

    @Test
    public void hasValue() {
        assertEquals(0.01, coin_1.getCoinType().getValue(), 0.00);
        assertEquals(0.02, coin_2.getCoinType().getValue(), 0.00);
        assertEquals(0.05, coin_3.getCoinType().getValue(), 0.00);
        assertEquals(0.10, coin_4.getCoinType().getValue(), 0.00);
        assertEquals(0.20, coin_5.getCoinType().getValue(), 0.00);
        assertEquals(0.50, coin_6.getCoinType().getValue(), 0.00);
        assertEquals(1.00, coin_7.getCoinType().getValue(), 0.00);
        assertEquals(2.00, coin_8.getCoinType().getValue(), 0.00);
    }
}
