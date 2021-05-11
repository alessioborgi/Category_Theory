public class IntegerCategory{


    private class IntSum implements Group<Integer> {
        @Override
        public Integer apply(Integer t, Integer u) {
            return t+u;
        }

        @Override
        public Integer id() {
            return 0;
        }

        @Override
        public  Integer invert(Integer t) {
            return -t;
        }
    }

    private class IntMul implements Monoid<Integer>{
        @Override
        public Integer apply(Integer t, Integer u) {
            return t*u;
        }

        @Override
        public Integer id() {
            return 1;
        }

    }

    //testing things

    public void met(){
        try {
            new IntMul().test(6);
            new IntSum().test(9);
            System.out.println(new IntSum().apply(3,3)); // 6
            System.out.println(new IntMul().apply(3,3)); //9
        }
        catch (Exception e){
            System.out.println("Excpetion cought => " + e.getMessage());
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
