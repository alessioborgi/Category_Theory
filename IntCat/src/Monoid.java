public interface Monoid<T> extends Semigroup<T>{

    T id();

    //a method tu test if a Monoid is well formed
    default void test(T t) throws Exception {

        if (apply(t, id()).equals(t)) {
            System.out.println("Correct: Lawful Monoid"); }

        else {
            throw new Exception("Error: Unlawful Monoid"); }
    }

}
