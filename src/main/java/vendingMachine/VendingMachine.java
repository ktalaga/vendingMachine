package vendingMachine;

import coinReturn.CoinReturn;
import coins.Coin;
import coins.CoinType;
import drawer.CodeType;
import drawer.Drawer;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private CoinReturn coinReturn;
    private ArrayList<Coin> listOfCoinsEntered;

    public VendingMachine(ArrayList<Drawer> drawers, CoinReturn coinReturn, ArrayList<Coin> listOfCoinsEntered) {
        this.drawers = drawers;
        this.coinReturn = coinReturn;
        this.listOfCoinsEntered = listOfCoinsEntered;
    }

    public ArrayList<Drawer> getDrawers() {
        return drawers;
    }

    public void setDrawers(ArrayList<Drawer> drawers) {
        this.drawers = drawers;
    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public void setCoinReturn(CoinReturn coinReturn) {
        this.coinReturn = coinReturn;
    }

    public ArrayList<Coin> getListOfCoinsEntered() {
        return listOfCoinsEntered;
    }

    public void setListOfCoinsEntered(ArrayList<Coin> listOfCoinsEntered) {
        this.listOfCoinsEntered = listOfCoinsEntered;
    }

    public void addCoinToVendingMachine(Coin coin){
        if(coin.getCoinType() != CoinType.ONEPENCE && coin.getCoinType() != CoinType.TWOPENCE){
            listOfCoinsEntered.add(coin);
        }
    }

    public double getTotalOfListOfCoinEntered(){
        double credit = 0;
        for(Coin coin : listOfCoinsEntered){
            credit += coin.getCoinType().getValue();
        }return credit;
    }

    public Product buyProduct(CodeType codeEntered){
        for(Drawer drawer : drawers){
            if(drawer.getCode() == codeEntered){
                if(drawer.getPrice() <= getTotalOfListOfCoinEntered()){
                    return drawer.returnProductFromDrawer(drawer.getStock().remove(0));
                }
            }
        }return null;
    }
}
