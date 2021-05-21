package Boolean_Category;

import java.util.function.UnaryOperator;

/**
 * @author alessioborgi
 * @created 10 / 05 / 2021 - 22:40
 * @project LOGIN
 */
public interface SemiGroupUnary<T> extends UnaryOperator<T> {
    @Override
    T apply(T t);
}