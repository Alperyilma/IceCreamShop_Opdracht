package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller{

    private PriceList priceList;
    private Stock stock;
    private double profit;


    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }


    @Override
    public Cone orderCone(Flavor[] balls) throws NoMoreIceCreamException {
        return prepareCone(balls);
    }

    private Cone prepareCone(Flavor[] balls) throws NoMoreIceCreamException {
        if (stock.getCones() <= 0 || stock.getBalls() <= 0){
            throw new NoMoreIceCreamException("No more Balls or Cones");
        }else {
            profit += priceList.getBallPrice();
            stock.setBalls(stock.getBalls() - balls.length);
            stock.setCones(stock.getCones() - 1);
            System.out.println("Preparing your ice cream");

        }
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        return prepareRocket();
    }

    public IceRocket prepareRocket()throws NoMoreIceCreamException{
        if (stock.getIceRockets() <= 0){
            throw new NoMoreIceCreamException("No more ice rocket");
        }else {
            profit += priceList.getRocketPrice();
            stock.setIceRockets(stock.getIceRockets() - 1);
            System.out.println("Your ice rocket is coming");

        }
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(MagnumType type) throws NoMoreIceCreamException {
        return prepareMagnum(type);
    }

    public Magnum prepareMagnum(MagnumType type)throws NoMoreIceCreamException{
        if (stock.getMagni() <= 0){
            throw new NoMoreIceCreamException("No more magnum");
        }else {
            profit += priceList.getMagnumPrice(type);
            stock.setMagni(stock.getMagni() - 1);
            System.out.println("Your magnum is coming");

        }
        return new Magnum(type);
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
