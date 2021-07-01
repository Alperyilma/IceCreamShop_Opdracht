package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{

    private PriceList priceList;

    private double totalProfit;


    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public Cone orderCone(Flavor[] balls) {
        Cone newCone = new Cone(balls);
        totalProfit += priceList.getBallPrice() * balls.length;
        return newCone;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket newIceRocket = new IceRocket();
        totalProfit += priceList.getRocketPrice();
        return newIceRocket;
    }

    @Override
    public Magnum orderMagnum(MagnumType type) {
        Magnum newMagnum = new Magnum(type);
        totalProfit += priceList.getMagnumPrice(type);
        return newMagnum;
    }

    @Override
    public String toString() {
        return "IceCramSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
