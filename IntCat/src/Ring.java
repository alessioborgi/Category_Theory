
public interface Ring<T> {

    T add(T t,T u);
    T mult(T t,T u);
    T idAdd();
    T invAdd(T t);
    T idMult();

    default void distributivityTest(T t,T u, T r) throws Exception{
        if (mult(t,add(u,r)).equals(add(mult(t,u),mult(t,r)))){
            //System.out.println("Correct distribution);
        }
        else {
            throw new Exception("Error: Distribution is not satisfied");
        }
    }
}
