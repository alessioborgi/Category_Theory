public interface Group<T> extends Monoid<T> {

    T invert(T t);

    //a method to test if the Group is well formed
    @Override
    default void test(T t) throws Exception {
        Monoid.super.test(t);
        if (apply(t, invert(t)).equals(id())) {
            //System.out.println("Correct: Lawful Inversion");
        } else {
            throw new Exception("Error: Unlawful Inversion");
        }
    }

    default boolean isAbelian(T t,T u,T r){
        try {
                test(t);
            }
        catch (Exception e){
            System.out.println("Expression caught => " + e.getMessage());
            return false;
        }
        return apply(t, u).equals(apply(u, t)) && apply(t, apply(u, r)).equals(apply(apply(t, u), r));
    }
}