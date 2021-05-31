package Integer_Category;

import java.beans.ConstructorProperties;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

//class to handle Semigroups,Monoids, Groups and Rings for the integers
public class IntegerCategory {

    public static class newSemigroup implements Semigroup<Integer> {
        String fx;

        //take a string from the constructor and it changes method apply accordingly
        public newSemigroup(String func) {
            fx = func;
        }

        public Integer apply(Integer t, Integer u) {
            return switch (fx) {
                case "+" -> t + u;
                case "-" -> t - u;
                case "*" -> t * u;
                case "/" -> t / u;
                case "%" -> t % u;
                case "^" -> (int) Math.pow(t, u);
                default -> 0;
            };
        }
    }

    public static class newMonoid implements Monoid<Integer> {

        int zero;
        String fx;
        //Constructor takes the operation as string and the identity as int
        public newMonoid(int e, String func) {
            zero = e;
            fx = func;
        }

        //return the identity
        @Override
        public Integer id() {
            return zero;
        }

        //use method apply from semigroup!
        public Integer apply(Integer t, Integer u) {
            return new newSemigroup(fx).apply(t, u);
        }

        //testing if a monoid is wellformed running lot of test with random integers
        //0 is not included cause among the possible operations there is also the division
        public boolean test() {
            for (int i = 0; i < 50; i++) {
                Integer randomN = ThreadLocalRandom.current().nextInt(0, 100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100, 0);
                try {
                    //NOT RECURSIVE, this calls the interface method
                    test(randomN);
                    test(randomM);
                } catch (Exception e) {
                    System.out.println("Exception caught => " + e.getMessage());
                    return false;
                }
            }
            return true;
        }
    }

    public static class newGroup implements Group<Integer> {

        int zero;
        String fx;
        String inv;
        //Constructor takes the operation and the inverse as string, the identity as int
        public newGroup(int e, String func, String invFunc) {
            zero = e;
            fx = func;
            inv = invFunc;
        }
        //operation
        public Integer apply(Integer t, Integer u) {
            return new newSemigroup(fx).apply(t, u);
        }
        //identity
        public Integer id() {
            return zero;
        }
        //handling the inversion
        public Integer invert(Integer t) {
            return switch (inv) {
                case "-a" -> -t;
                case "+a" -> t;
                case "0" -> 0;
                case "1" -> 1;
                default -> 0;
            };
        }

        //testing the group with random integers, returning a string with the exception message if caught
        public String test() {
            for (int i = 0; i < 50; i++) {
                Integer randomN = ThreadLocalRandom.current().nextInt(1, 100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100, -1);
                try {
                    //NOT RECURSIVE, this calls the interface method
                    test(randomN);
                    test(randomM);
                } catch (Exception e) {
                    System.out.println("Exception caught => " + e.getMessage());
                    return e.getMessage();
                }
            }
            return "TEST PASSED!";
        }

        //test if a group is abelian using the method from the interface
        public boolean isAbelian() {
            for (int i = 0; i < 50; i++) {
                Integer randomN = ThreadLocalRandom.current().nextInt(-100, 100);
                if (randomN.equals(0)) {
                    randomN++;
                }
                Integer randomM = ThreadLocalRandom.current().nextInt(-100, -1);
                Integer randomZ = ThreadLocalRandom.current().nextInt(1, 100);
                if (!isAbelian(randomN, randomM, randomZ)) {
                    System.out.println("Not Abelian");
                    return false;
                }
            }
            return true;
        }
    }

    public static class newRing implements Ring<Integer> {
        //according to Cat. theory, a ring is an abelian group under addition and a monoid under multiplication
        //so i create that 2 objects (see below)
        int zeroAdd;
        int zeroMul;
        String invA;
        String fxAdd;
        String fxMult;
        newGroup ringGroup;
        newMonoid ringMonoid;

        //constructor takes all the needed infos
        public newRing(int eA, int eM, String addition, String multiplication, String inversion) {
            zeroAdd = eA;
            zeroMul = eM;
            invA = inversion;
            fxAdd = addition;
            fxMult = multiplication;
            ringGroup = new newGroup(zeroAdd, fxAdd, invA);
            ringMonoid = new newMonoid(zeroMul, fxMult);
        }

        @Override
        public Integer idAdd() {
            return ringGroup.id();
        }

        @Override
        public Integer idMult() {
            return ringMonoid.id();
        }

        @Override
        public Integer invAdd(Integer t) {
            return ringGroup.invert(t);
        }

        @Override
        public Integer add(Integer t, Integer u) {
            return ringGroup.apply(t, u);
        }

        @Override
        public Integer mult(Integer t, Integer u) {
            return ringMonoid.apply(t, u);
        }

        private boolean distributivityTest() {
            for (int i = 0; i < 50; i++) {
                Integer randomN = ThreadLocalRandom.current().nextInt(-100, 100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100, 0);
                Integer randomZ = ThreadLocalRandom.current().nextInt(0, 100);
                Integer randomK = ThreadLocalRandom.current().nextInt(-100, 0);
                try {
                    distributivityTest(randomN, randomM, randomZ);
                    distributivityTest(randomN, randomZ, randomM);
                    distributivityTest(randomM, randomN, randomZ);
                    distributivityTest(randomM, randomK, randomZ);
                    distributivityTest(randomK, randomN, randomZ);
                } catch (Exception e) {
                    System.out.println("Exception caught => " + e.getMessage());
                    return false;
                }
            }
            return true;
        }
        //testing all the properties
        public boolean test() {
            return ringGroup.isAbelian() && ringMonoid.test() && distributivityTest();
        }

    }
}
