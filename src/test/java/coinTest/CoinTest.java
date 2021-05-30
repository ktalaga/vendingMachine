package coinTest;

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
        coin_1 = new Coin(CoinType.1PENCE);
        coin_2 = new Coin(CoinType.2PENCE);
        coin_3 = new Coin(CoinType.5PENCE);
        coin_4 = new Coin(CoinType.10PENCE);
        coin_5 = new Coin(CoinType.20PENCE);
        coin_6 = new Coin(CoinType.50PENCE);
        coin_7 = new Coin(CoinType.1POUND);
        coin_8 = new Coin(CoinType.2POUND);
    }

    @Test
    public void hasType() {
        assertEquals(CoinType.1PENCE, coin_1.getType());
        assertEquals(CoinType.2PENCE, coin_2.getType());
        assertEquals(CoinType.5PENCE, coin_3.getType());
        assertEquals(CoinType.10PENCE, coin_4.getType());
        assertEquals(CoinType.20PENCE, coin_5.getType());
        assertEquals(CoinType.50PENCE, coin_6.getType());
        assertEquals(CoinType.1POUND, coin_7.getType());
        assertEquals(CoinType.2POUND, coin_8.getType());
    }

    @Test
    public void hasValue() {
        assertEquals(0.01, coin_1.getValue());
        assertEquals(0.02, coin_2.getValue());
        assertEquals(0.05, coin_3.getValue());
        assertEquals(0.10, coin_4.getValue());
        assertEquals(0.20, coin_5.getValue());
        assertEquals(0.50, coin_6.getValue());
        assertEquals(1.00, coin_7.getValue());
        assertEquals(2.00, coin_8.getValue());
    }
}
