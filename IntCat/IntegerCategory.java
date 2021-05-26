

import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class IntegerCategory{

    public static class newSemigroup implements Semigroup<Integer>{
        String fx;
        public newSemigroup(String func){
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
            return new newSemigroup(fx).apply(t,u);
        }

        public boolean test(){
            for (int i = 0; i < 50; i++) {
                Integer randomN = ThreadLocalRandom.current().nextInt(0,100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100,0);
                try{test(randomN);
                    test(randomM);}
                catch(Exception e){
                    System.out.println("Exception caught => " + e.getMessage());
                    return false;
                }
            }
            return true;}
    }

    public static class newGroup implements Group<Integer>{

        int zero;
        String fx;
        String inv;

        public newGroup(int e, String func, String invFunc){
            zero = e;
            fx = func;
            inv = invFunc;
        }

        public Integer apply(Integer t, Integer u) {
            return new newSemigroup(fx).apply(t,u);
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


        public String test(){
            for (int i = 0; i < 50; i++) {
                Integer randomN = ThreadLocalRandom.current().nextInt(0,100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100,0);
                try{test(randomN);
                    test(randomM);}
                catch(Exception e){
                    System.out.println("Exception caught => " + e.getMessage());
                    return e.getMessage();
                }
            }
            return "TEST PASSED!";}

        public boolean isAbelian(){
            for(int i = 0; i < 50; i++){
                Integer randomN = ThreadLocalRandom.current().nextInt(-100,100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100,0);
                Integer randomZ = ThreadLocalRandom.current().nextInt(0,100);
                if (! isAbelian(randomN,randomM,randomZ)){return false;}
            }
            return true;}
    }

    public static class newRing implements Ring<Integer>{

        int zeroAdd;
        int zeroMul;
        String invA;
        String fxAdd;
        String fxMult;
        newGroup ringGroup;
        newMonoid ringMonoid;

        public newRing(int eA,int eM,String addition,String multiplication,String inversion){
            zeroAdd = eA;
            zeroMul = eM;
            invA = inversion;
            fxAdd = addition;
            fxMult = multiplication;
            ringGroup = new newGroup(zeroAdd,fxAdd,invA);
            ringMonoid = new newMonoid(zeroMul,fxMult);
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
            return ringGroup.apply(t,u);
        }

        @Override
        public Integer mult(Integer t, Integer u) {
            return ringMonoid.apply(t,u);
        }

        private boolean distributivityTest(){
            for(int i = 0; i < 50; i++){
                Integer randomN = ThreadLocalRandom.current().nextInt(-100,100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100,0);
                Integer randomZ = ThreadLocalRandom.current().nextInt(0,100);
                Integer randomK = ThreadLocalRandom.current().nextInt(-100,0);
                try {
                    distributivityTest(randomN, randomM, randomZ);
                    distributivityTest(randomN, randomZ, randomM);
                    distributivityTest(randomM, randomN, randomZ);
                    distributivityTest(randomM, randomK, randomZ);
                    distributivityTest(randomK, randomN, randomZ);
                }
                catch (Exception e){
                    System.out.println("Exception caught => " + e.getMessage());
                    return false;
                }
            }
            return true;}

        public boolean test(){
            return ringGroup.isAbelian() && ringMonoid.test() && distributivityTest();
        }

    }

   /**
    public void met(){
        try {
            BooleanCategory.newMonoid BoolOR = new BooleanCategory.newMonoid(true,"and");
            newGroup add = new newGroup(0, "+", "-");
            newMonoid mult = new newMonoid(1, "/");
            newSemigroup sub = new newSemigroup("-");
            newRing intRing = new newRing(0, 1, "+", "*", "-");
            //System.out.println(add.isAbelian());
            System.out.println(BoolOR.apply(true,true));
            System.out.println(BoolOR.test());
            if (mult.test() && add.test() && intRing.test()) {
                System.out.println(sub.apply(8, 9)); //-1
                System.out.println(mult.apply(8, 4)); //12
                System.out.println(intRing.add(7, 3)); //10 or 4
                System.out.println(intRing.mult(8, 4)); //-20
            }
        }
        catch (Exception e){
            System.out.println("Exception caught => " + e.getMessage());
        }
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        IntegerCategory firstInt = new IntegerCategory();
        firstInt.met();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }*/

}
