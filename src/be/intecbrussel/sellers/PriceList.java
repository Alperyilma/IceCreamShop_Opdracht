package be.intecbrussel.sellers;

import be.intecbrussel.eatables.MagnumType;

public class PriceList {
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList(){

    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice){
        setBallPrice(ballPrice);
        setRocketPrice(rocketPrice);
        setMagnumStandardPrice(magnumStandardPrice);
    }

    public void setBallPrice(double ballPrice) {
        if (ballPrice < 0.5){
            System.out.println("Wrong price");
        }
        this.ballPrice = ballPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        if (rocketPrice < 1){
            System.out.println("Wrong price");
        }
        this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        if (magnumStandardPrice < 1.5){
            System.out.println("Wrong price");
        }
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(MagnumType type) {
        switch (type) {
            case ALPINENUTS:
                return magnumStandardPrice * 1.5;
            case ROMANTICSTRAWBERRIES:
                return magnumStandardPrice * 2;
            default:
                return magnumStandardPrice;
        }
    }

}
