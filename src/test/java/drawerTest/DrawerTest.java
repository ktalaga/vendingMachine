package drawerTest;

import drawer.CodeType;
import drawer.Drawer;
import org.junit.Before;
import org.junit.Test;
import products.Crisp;
import products.Drink;
import products.Product;
import products.Sweet;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DrawerTest {

    private Product sweet_1;
    private Product drink_1;
    private Product crisp_1;
    private ArrayList<Product> stock_1;
    private ArrayList<Product> stock_2;
    private ArrayList<Product> stock_3;
    private Drawer drawer_1;
    private Drawer drawer_2;
    private Drawer drawer_3;

    @Before
    public void before(){
        sweet_1 = new Sweet("Mars");
        drink_1 = new Drink("Coca-cola");
        crisp_1 = new Crisp("Walkers");
        stock_1 = new ArrayList<>();
        stock_2 = new ArrayList<>();
        stock_3 = new ArrayList<>();
        drawer_1 = new Drawer(stock_1, 0.60, CodeType.A1);
        drawer_2 = new Drawer(stock_2, 1.10, CodeType.A2);
        drawer_3 = new Drawer(stock_3, 0.65, CodeType.A3);
    }

    @Test
    public void hasStock() {
        assertEquals(stock_1, drawer_1.getStock());
        assertEquals(stock_2, drawer_2.getStock());
        assertEquals(stock_3, drawer_3.getStock());
    }

    @Test
    public void canSetStock() {
        drawer_1.setStock(stock_2);
        assertEquals(stock_2, drawer_1.getStock());
    }

    @Test
    public void hasPrice() {
        assertEquals(0.60, drawer_1.getPrice(), 0.00);
        assertEquals(1.10, drawer_2.getPrice(), 0.00);
        assertEquals(0.65, drawer_3.getPrice(), 0.00);
    }

    @Test
    public void canSetPrice() {
        drawer_1.setPrice(2.50);
        assertEquals(2.50, drawer_1.getPrice(), 0.00);
    }

    @Test
    public void hasCode() {
        assertEquals(CodeType.A1, drawer_1.getCode());
        assertEquals(CodeType.A2, drawer_2.getCode());
        assertEquals(CodeType.A3, drawer_3.getCode());
    }

    @Test
    public void canAddProductToDrawer() {
        drawer_1.addProductToDrawer(sweet_1);
        drawer_1.addProductToDrawer(drink_1);
        drawer_1.addProductToDrawer(crisp_1);
        assertEquals(3, drawer_1.getStock().size());
    }

    @Test
    public void canRemoveProductFromDrawer() {
        drawer_1.addProductToDrawer(sweet_1);
        drawer_1.addProductToDrawer(drink_1);
        drawer_1.addProductToDrawer(crisp_1);
        drawer_1.returnProductFromDrawer(sweet_1);
        assertEquals(2, drawer_1.getStock().size());
    }
}
