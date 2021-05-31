package Integer_Category;
import java.util.ArrayList;
//a class for handling semigroups,monoids,groups for the booleans
public class BooleanCategory {

    public static class newSemigroup implements Semigroup<Boolean> {
        String fx;
        //take a string from the constructor and it changes method apply accordingly
        public newSemigroup(String func) {
            fx = func;
        }

        public Boolean apply(Boolean t, Boolean u) {
            return switch (fx) {
                case "∧ (and)" -> t && u;
                case "V (or)" -> t || u;
                case "⊕ (xor)" -> t ^ u;
                default -> false;

            };
        }
    }

    public static class newMonoid implements Monoid<Boolean> {

        boolean zero;
        String fx;
        //Constructor takes the operation as string and the identity as bool
        public newMonoid(boolean e, String func) {
            zero = e;
            fx = func;
        }

        @Override
        public Boolean id() {
            return zero;
        }

        //use method apply from semigroup!
        public Boolean apply(Boolean t, Boolean u) {
            return new BooleanCategory.newSemigroup(fx).apply(t, u);
        }

        //testing if the monoid is correct for all inputs
        public boolean test() {
            try {
                test(true);
                test(false);
            } catch (Exception e) {
                System.out.println("Exception caught => " + e.getMessage());
                return false;
            }
            return true;
        }
    }

    public static class newGroup implements Group<Boolean> {

        boolean zero;
        String fx;
        String inv;
        //Constructor takes the operation and the inverse as string, the identity as bool
        public newGroup(boolean e, String func, String invFunc) {
            zero = e;
            fx = func;
            inv = invFunc;
        }
        //using the operation from semigroup
        public Boolean apply(Boolean t, Boolean u) {
            return new BooleanCategory.newSemigroup(fx).apply(t, u);
        }

        public Boolean id() {
            return zero;
        }
        //handling the inversion
        public Boolean invert(Boolean t) {
            return switch (inv) {
                case "+a" -> t;
                case "-a" -> !t;
                case "0" -> false;
                default -> true;
            };
        }

        //testing if the group is well formed, returing and array with two values: the boolean result and a string with the exception if caught
        public ArrayList test() {
            ArrayList AA = new ArrayList();
            try {
                test(true);
                test(false);
            } catch (Exception e) {
                System.out.println("Exception caught => " + e.getMessage());
                AA.add(false);
                AA.add(e.getMessage());
                return AA;
            }
            AA.add(true);
            AA.add("TEST PASSED!");
            return AA;
        }

        //very fun stuff here! To test if a group is abelian i need to pass all the possible combination of 3 boolean values (for associativity)
        //to do this i make all the possible combination of 3 bits,counting from 0 to 8 in decimal then converting the number in binary
        // and finally converting each bit to True/False (1 = true, 0 = false) and pass them to the interface test
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
