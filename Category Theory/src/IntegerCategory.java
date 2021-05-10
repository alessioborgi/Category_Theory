
public class IntegerCategory{

    //Int Adddition Group (bifunc,id,inverse)
    public static class IntAdd {
        public static Semigroup<Integer> func = (a,b) -> a+b;
        public static int id = 0;
        public static Invertibile<Integer> inv = (a) -> -a; // to Delete
    }

    //Int multiplic. Group !!NOT REALLY, CAN'T SATISFY inverse property (inv.prop = applying the bifunc to a element and its inverse should return the id)
    //We can't inverse a integer cause it's inverse is a float ( 1 / something is a float)
    //I should delete de inverse and so this become a MONOID (just bifunc,id).
    public static class IntMult {
        public static Semigroup<Integer> func = (a,b) -> a*b;
        public static int id = 1;
        public static Invertibile<Float> inv = (a) -> 1/a;
    }

    //testing things
    public float h = 5;
    float opposto = IntMult.inv.inverse(h);
    int result = IntMult.func.apply(3,4);
    int result2 = IntAdd.func.apply(50,100);
    int opposto2 = IntAdd.inv.inverse(9);

    public int a = 7;
    public int b = 3;

    public void met(){
        System.out.println(result); // 3*4
        System.out.println(opposto); // 1/5
        System.out.println(result2); // 50+100
        System.out.println(opposto2);// -9
        System.out.println(IntAdd.func.apply(7,IntAdd.inv.inverse(7)));
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        IntegerCategory firstInt = new IntegerCategory();
        firstInt.met();

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }

}
