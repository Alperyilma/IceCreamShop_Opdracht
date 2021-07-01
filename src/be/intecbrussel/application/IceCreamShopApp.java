package be.intecbrussel.application;

import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Flavor;
import be.intecbrussel.eatables.MagnumType;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;

public class IceCreamShopApp {
    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList(0.5, 1, 1.5);
        IceCreamSeller iceCreamSeller = new IceCreamSalon(priceList);

        Eatable[] eatables = {
                iceCreamSeller.orderMagnum(MagnumType.ROMANTICSTRAWBERRIES),
                iceCreamSeller.orderMagnum(MagnumType.ALPINENUTS),
                iceCreamSeller.orderMagnum(MagnumType.BLACKCHOCOLATE),

                iceCreamSeller.orderIceRocket(),

                iceCreamSeller.orderCone(new Flavor[]{Flavor.CHOCOLATE, Flavor.VANILLA, Flavor.BANANA})};

        for (Eatable iceSalon: eatables) {

            iceSalon.eat();
        }


        System.out.println("The profit is: " + iceCreamSeller.getProfit());
    }
}
