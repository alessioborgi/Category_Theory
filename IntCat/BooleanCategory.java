
public class BooleanCategory {

    static class newSemigroup implements Semigroup<Boolean> {
        String fx;

        public newSemigroup(String func) {
            fx = func;
        }

        public Boolean apply(Boolean t, Boolean u) {
            return switch (fx) {
                case "and" -> t && u;
                case "or" -> t || u;
                case "xor" -> t ^ u;
                case "nand" -> !(t && u);   //not associative
                case "nor" -> !(t || u);      //not associative
                case "xnor" -> !(t ^ u);    //not associative
                default -> false;

            };
        }
    }

    static class newMonoid implements Monoid<Boolean> {

        boolean zero;
        String fx;

        public newMonoid(boolean e, String func) {
            zero = e;
            fx = func;
        }

        @Override
        public Boolean id() {
            return zero;
        }

        public Boolean apply(Boolean t, Boolean u) {
            return new BooleanCategory.newSemigroup(fx).apply(t, u);
        }

        public boolean test() {
            try {test(true);
                test(false);}
            catch (Exception e){
                System.out.println("Exception caught => " + e.getMessage());
                return false;}
        return true;}
    }




}
