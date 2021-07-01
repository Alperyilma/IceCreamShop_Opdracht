package be.intecbrussel.application;

import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Flavor;
import be.intecbrussel.eatables.MagnumType;
import be.intecbrussel.sellers.*;

public class IceCreamShopAppV2 {
    public static void main(String[] args) {

        PriceList priceList = new PriceList(0.5, 1, 1.5);
        Stock stock = new Stock(8, 9, 7, 5);
        IceCreamSeller iceCreamSeller = new IceCreamCar(priceList, stock);

        Eatable[] eatables = new Eatable[0];

        try {
            eatables = new Eatable[] {
                    iceCreamSeller.orderMagnum(MagnumType.ROMANTICSTRAWBERRIES),
                    iceCreamSeller.orderIceRocket(),
                    iceCreamSeller.orderIceRocket(),
                    iceCreamSeller.orderCone(new Flavor[]{Flavor.VANILLA, Flavor.CHOCOLATE})};
            for (Eatable iceCar : eatables){
                iceCar.eat();
            }
            System.out.println("The profit is: " + iceCreamSeller.getProfit());

        } catch (NoMoreIceCreamException nm) {
            System.out.println(nm.getMessage());
        }
    }
}
