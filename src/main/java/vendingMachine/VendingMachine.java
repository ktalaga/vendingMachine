package vendingMachine;

import coinReturn.CoinReturn;
import coins.Coin;
import drawer.Drawer;

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
}
