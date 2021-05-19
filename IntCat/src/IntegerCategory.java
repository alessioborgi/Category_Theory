import java.util.concurrent.ThreadLocalRandom;
//import java.lang.Math;

public class IntegerCategory{

    static class newSemigroup implements Semigroup<Integer>{
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

    static class newMonoid implements Monoid<Integer> {

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

    static class newGroup implements Group<Integer>{

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
            if (inv.equals("-")){return -t;}
            return t;
        }

        public boolean test() {
            return new newMonoid(zero, fx).test();
        }

        public boolean isAbelian(){
            for(int i = 0; i < 50; i++){
                Integer randomN = ThreadLocalRandom.current().nextInt(-100,100);
                Integer randomM = ThreadLocalRandom.current().nextInt(-100,0);
                Integer randomZ = ThreadLocalRandom.current().nextInt(0,100);
                if (! isAbelian(randomN,randomM,randomZ)){return false;}
            }
        return true;}
    }

    static class newRing implements Ring<Integer>{}

    /*private class IntSum implements Group<Integer> {
        @Override
        public Integer apply(Integer t, Integer u) { return t+u; }

        public Integer id() { return 0; }

        public  Integer invert(Integer t) { return -t; }
    }*/

    /*private class IntMul implements Monoid<Integer>{
        @Override
        public Integer apply(Integer t, Integer u) {
            return t*u;
        }

        public Integer id() {
            return 1;
        }
    }*/

    /*private class BoolAnd implements Monoid<Boolean>{
        @Override
        public Boolean apply(Boolean t, Boolean u) { return t && u;}

        public Boolean id(){ return true;}
        }*/

    //testing things

    public void met(){
        try {
            newGroup add = new newGroup(0,"+","-");
            newMonoid mult = new newMonoid(1,"*");
            newSemigroup sub = new newSemigroup("-");
            System.out.println(add.isAbelian());
            if (mult.test() && add.test()){
                System.out.println(sub.apply(8,9));
                System.out.println(mult.apply(3,4));}
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
    }

}
