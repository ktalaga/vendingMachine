package coinReturn;

import coins.Coin;
import coins.CoinType;

import java.util.ArrayList;

public class CoinReturn {

    private ArrayList<Coin> returnedCoins;

    public CoinReturn(ArrayList<Coin> returnedCoins) {
        this.returnedCoins = returnedCoins;
    }

    public ArrayList<Coin> getReturnedCoins() {
        return returnedCoins;
    }

    public double getTotalAmountInCoinReturn(){
        double totalInCoinReturn = 0;
        for (Coin coin : returnedCoins){
            totalInCoinReturn += coin.getCoinType().getValue();
        }return totalInCoinReturn;
    }

    public void addCoinToCoinReturn(Coin coin){
        if(coin.getCoinType() != CoinType.ONEPENCE && coin.getCoinType() != CoinType.TWOPENCE){
            returnedCoins.add(coin);
        }
    }
}
