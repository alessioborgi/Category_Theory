package Integer_Category;
import java.util.ArrayList;

public class BooleanCategory {

    public static class newSemigroup implements Semigroup<Boolean> {
        String fx;

        public newSemigroup(String func) {
            fx = func;
        }

        public Boolean apply(Boolean t, Boolean u) {
            return switch (fx) {
                case "∧" -> t && u;
                case  "V" -> t || u;
                case "⊕" -> t ^ u;
                case "nand" -> !(t && u);   //not associative
                case "nor" -> !(t || u);      //not associative
                case "xnor" -> !(t ^ u);    //not associative
                default -> false;

            };
        }
    }

    public static class newMonoid implements Monoid<Boolean> {

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

    public static class newGroup implements Group<Boolean> {

        boolean zero;
        String fx;
        String inv;

        public newGroup(boolean e, String func, String invFunc) {
            zero = e;
            fx = func;
            inv = invFunc;
        }

        public Boolean apply(Boolean t, Boolean u) {
            return new BooleanCategory.newSemigroup(fx).apply(t, u);
        }

        public Boolean id() {
            return zero;
        }

        public Boolean invert(Boolean t) {
            return switch (inv) {
                case "+a" -> t;
                case "-a" -> !t;
                case "0" -> false;
                default -> true;
            };
        }

        public ArrayList test() {
            ArrayList AA = new ArrayList();
            try{test(true);
                test(false);}
            catch (Exception e) {System.out.println("Exception caught => " + e.getMessage());
                AA.add(false);
                AA.add(e.getMessage());
                return AA;}
            AA.add(true);
            AA.add("TEST PASSED!");
            return AA;}

        public boolean isAbelian() {
            boolean flag;
            Character c;
            String bits;
            for (int i = 0; i < 8; i++) {
                ArrayList<Boolean> bbits = new ArrayList<Boolean>();
                bits = String.format("%3s", Integer.toBinaryString(i)).replace(' ', '0');
                for (int j = 0; j < 2; j++) {
                    c = bits.charAt(j);
                    if (c.equals('0')) {
                        bbits.add(false);
                    } else {
                        bbits.add(true);
                    }
                }
                flag = isAbelian(bbits.get(0), bbits.get(1), bbits.get(0));
                if (!flag) {
                    return false;
                }
            }
            return true;
        }
    }




}
