package productTest;

import org.junit.Before;
import org.junit.Test;
import products.Crisp;
import products.Drink;
import products.Product;
import products.Sweet;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private Product sweet_1;
    private Product drink_1;
    private Product crisp_1;

    @Before
    public void before(){
        sweet_1 = new Sweet("Mars");
        drink_1 = new Drink("Coca-cola");
        crisp_1 = new Crisp("Walkers");
    }

    @Test
    public void hasName() {
        assertEquals("Mars", sweet_1.getName());
        assertEquals("Coca-cola", drink_1.getName());
        assertEquals("Walkers", crisp_1.getName());
    }
}
