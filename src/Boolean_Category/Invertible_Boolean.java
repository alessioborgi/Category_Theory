package Boolean_Category;

/**
 * @author alessioborgi
 * @created 16 / 05 / 2021 - 11:35
 * @project CATEGORY_THEORY
 */
@FunctionalInterface
public interface Invertible_Boolean<T>{
    T inverse(T t, T u);
}

