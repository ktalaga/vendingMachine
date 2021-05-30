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
    private ArrayList<Coin> till;


    public VendingMachine(ArrayList<Drawer> drawers, CoinReturn coinReturn, ArrayList<Coin> listOfCoinsEntered, ArrayList<Coin> till) {
        this.drawers = drawers;
        this.coinReturn = coinReturn;
        this.listOfCoinsEntered = listOfCoinsEntered;
        this.till = till;
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

    public void addCoinToVendingMachine(Coin coin) {
        if (coin.getCoinType() != CoinType.ONEPENCE && coin.getCoinType() != CoinType.TWOPENCE) {
            listOfCoinsEntered.add(coin);
        }
    }

    public double getTotalOfListOfCoinEntered() {
        double credit = 0;
        for (Coin coin : listOfCoinsEntered) {
            credit += coin.getCoinType().getValue();
        }
        return credit;
    }

    public void setTotalOfCoinsEnteredTo0() {
        listOfCoinsEntered.clear();
    }

    public ArrayList<Coin> getTill() {
        return till;
    }

    public void setTill(ArrayList<Coin> till) {
        this.till = till;
    }

    public Product vendProduct(CodeType codeEntered) {
        for (Drawer drawer : drawers) {
            if (drawer.getCode() == codeEntered) {
                return drawer.returnProductFromDrawer(drawer.getStock().remove(0));
            }
        }
        return null;
    }

    public double getTotalInTill() {
        double total = 0;
        for (Coin coinInTill : till) {
            total += coinInTill.getCoinType().getValue();
        }
        return total;
    }

    public Product buyProduct(CodeType codeEntered) {

        for (Drawer drawer : drawers) {
            double totalInTillBeforePayment = getTotalInTill();
            if (drawer.getCode() == codeEntered) {
                if (drawer.getPrice() <= getTotalOfListOfCoinEntered()) {
                    for (Coin coinEntered : getListOfCoinsEntered()) {
                        till.add(coinEntered);
                        if (totalInTillBeforePayment == getTotalInTill() - getTotalOfListOfCoinEntered()) {
                            return vendProduct(codeEntered);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Coin getCoinByTypeFromTill(CoinType coinTypeSearched) {
        for (Coin coin : till){
            if(coinTypeSearched == coin.getCoinType()){
                return till.remove(till.indexOf(coin));
            }
        }
        return null;
    }
}
