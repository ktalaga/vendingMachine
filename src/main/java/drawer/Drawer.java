package drawer;

import products.Product;

import java.util.ArrayList;

public class Drawer {

    private ArrayList<Product> stock;
    private double price;
    private CodeType code;

    public Drawer(ArrayList<Product> stock, double price, CodeType code) {
        this.stock = stock;
        this.price = price;
        this.code = code;
    }

    public ArrayList<Product> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Product> stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CodeType getCode() {
        return code;
    }

    public void setCode(CodeType code) {
        this.code = code;
    }

    public void addProductToDrawer(Product product){
        stock.add(product);
    }

    public Product returnProductFromDrawer(Product product){
        stock.remove(product);
        return product;
    }
}
