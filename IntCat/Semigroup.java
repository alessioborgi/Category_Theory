package Integer_Category;

import java.util.function.BinaryOperator;

@FunctionalInterface
//simple interface for semigroups
public interface Semigroup<T> extends BinaryOperator<T>{

    @Override
    T apply(T t, T u);

}





