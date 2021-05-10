import java.util.function.BinaryOperator;

@FunctionalInterface
public interface Semigroup<T> extends BinaryOperator<T>{
    @Override
    T apply(T t, T u);
}
