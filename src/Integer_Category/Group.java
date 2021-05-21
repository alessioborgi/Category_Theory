package Integer_Category;

/**
 * @author alessioborgi
 * @created 13 / 05 / 2021 - 08:06
 * @project LOGIN
 */

public interface Group<T> extends Monoid<T> {
    T invert(T t);

    //a method tu test if the Group is well formed
    @Override
    default void test(T t) throws Exception{
        if ( apply(t,id()).equals(t) && apply(t,invert(t)).equals(id())){
            System.out.println("Correct: Lawful Group");
        }
        else {
            throw new Exception("Error: Unlawful Monoid");
        }
    }

}