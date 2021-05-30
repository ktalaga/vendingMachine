package coins;

public enum CoinType {



    ONEPENCE(0.01),
    TWOPENCE(0.02),
    FIVEPENCE(0.05),
    TENPENCE(0.10),
    TWENTYPENCE(0.20),
    FIFTYPENCE(0.50),
    ONEPOUND(1.00),
    TWOPOUND(2.00);

    private final double value;

    CoinType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
