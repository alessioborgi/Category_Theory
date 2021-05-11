import java.util.function.BinaryOperator;

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
