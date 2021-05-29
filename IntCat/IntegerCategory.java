package Integer_Category;

import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class IntegerCategory {

    public static class newSemigroup implements Semigroup<Integer> {
        String fx;

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

        public newMonoid(int e, String func) {
            zero = e;
            fx = func;
        }

        @Override
        public Integer id() {
            return zero;
        }

        public Integer apply(Integer t, Integer u) {
            return new newSemigroup(fx).apply(t, u);
        }

        public boolean test() {
            for (int i = 0; i < 50; i++) {
                Integer randomN = ThreadLocalRandom.current().nextInt(0, 100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100, 0);
                try {
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

        public newGroup(int e, String func, String invFunc) {
            zero = e;
            fx = func;
            inv = invFunc;
        }

        public Integer apply(Integer t, Integer u) {
            return new newSemigroup(fx).apply(t, u);
        }

        public Integer id() {
            return zero;
        }

        public Integer invert(Integer t) {
            return switch (inv) {
                case "-a" -> -t;
                case "+a" -> t;
                case "0" -> 0;
                case "1" -> 1;
                default -> 0;
            };
        }

        public String test() {
            for (int i = 0; i < 50; i++) {
                Integer randomN = ThreadLocalRandom.current().nextInt(1, 100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100, -1);
                try {
                    test(randomN);
                    test(randomM);
                } catch (Exception e) {
                    System.out.println("Exception caught => " + e.getMessage());
                    return e.getMessage();
                }
            }
            return "TEST PASSED!";
        }

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

        int zeroAdd;
        int zeroMul;
        String invA;
        String fxAdd;
        String fxMult;
        newGroup ringGroup;
        newMonoid ringMonoid;

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

        public boolean test() {
            return ringGroup.isAbelian() && ringMonoid.test() && distributivityTest();
        }

    }
}
