import java.util.*;


public class SetCat extends HashSet {

    private Set set;

    public SetCat() {
        this.set = new HashSet<>();
    }


     public static Set<Set<Object>> CartesianProduct(SetCat... sets) {
        if (sets.length < 2)
            throw new IllegalArgumentException(
                "Can't have a product of fewer than two sets (got " +
                    sets.length + ")");

     return cartesianProduct(0, sets);
     }

     private static Set<Set<Object>> cartesianProduct(int index, SetCat... sets) {
        Set<Set<Object>> prod = new HashSet<Set<Object>>();
        if (index == sets.length) {
            prod.add(new HashSet<Object>());
        } else {
            for (Object obj : sets[index]) {
                for (Set<Object> set : cartesianProduct(index+1, sets)) {
                    set.add(obj);
                    prod.add(set);
     }
     }
     }
     return prod;
 }

}

