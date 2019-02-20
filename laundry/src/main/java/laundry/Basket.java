package laundry;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    //piszkos ruhákat beletenni, csak innen lehet mosni, kezdési pont

    public List<Clothes> putinBasket(List<Clothes> allClothes, int maxBasketSize){
        List<Clothes> basketItems = new ArrayList<Clothes>();
        for (Clothes clothes : allClothes) {
            if (!clothes.isClean()) {
                basketItems.add(clothes);

            }
            if (basketItems.size() == (maxBasketSize)){
                System.out.println("The basket is full, start washing!");
                break;
            }
        }
        return basketItems;
    }


}
