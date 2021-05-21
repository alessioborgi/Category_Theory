package Integer_Category;
import java.util.function.BinaryOperator;
/**
 * @author alessioborgi
 * @created 10 / 05 / 2021 - 21:46
 * @project LOGIN
 */

@FunctionalInterface
public interface Semigroup<T> extends BinaryOperator<T>{

    @Override
    T apply(T t, T u);

    default void AssociativityTest(T t,T u) throws Exception{
        if(apply(t,u).equals(apply(u,t))) {
            System.out.println("Associativity test passed.");
        }
        else {throw new Exception("Associativity test failed.");}
    }
}