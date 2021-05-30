package coinReturn;

import coins.Coin;
import coins.CoinType;

import java.util.ArrayList;

public class CoinReturn {

    private ArrayList<Coin> till;

    public CoinReturn(ArrayList<Coin> till) {
        this.till = till;
    }

    public ArrayList<Coin> getTill() {
        return till;
    }

    public double getTotalAmountInCoinReturn(){
        double totalInCoinReturn = 0;
        for (Coin coin : till){
            totalInCoinReturn += coin.getCoinType().getValue();
        }return totalInCoinReturn;
    }

    public void addCoinToCoinReturn(Coin coin){
        if(coin.getCoinType() != CoinType.ONEPENCE && coin.getCoinType() != CoinType.TWOPENCE){
            till.add(coin);
        }
    }
}
