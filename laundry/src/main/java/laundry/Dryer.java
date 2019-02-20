package laundry;

import java.util.ArrayList;
import java.util.List;

public class Dryer {
    public List<Clothes> dryClothes(List<Clothes> afterWashing){ //tuti clean mert a gépből jön
        List<Clothes> afterDrying = new ArrayList<Clothes>();

        for (Clothes cloth : afterWashing){
            Clothes dcloth = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), cloth.isClean(), true, false);
            afterDrying.add(dcloth);
        }
    return afterDrying;
    }
}
