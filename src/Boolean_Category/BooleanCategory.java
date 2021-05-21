package Boolean_Category;
import Integer_Category.Group;
import Integer_Category.IntegerCategory;
import Integer_Category.Semigroup;
/**
 * @author alessioborgi
 * @created 10 / 05 / 2021 - 22:39
 * @project LOGIN
 */
public class BooleanCategory {

    //We have to undesrtand what to put on id. Its inversion is the NAND?
    private class Bool_And implements Group<Boolean> {
        @Override
        public Boolean apply(Boolean t, Boolean u) {
            return t & u;
        }

        @Override
        public Boolean id() {
            return true;
        }

        @Override
        public  Boolean invert(Boolean t) {
            return !t;
        }
    }

    //Also here we have to understand what to put on id. Its inversion is the NOR?
    private class Bool_Or implements Group<Boolean> {
        @Override
        public Boolean apply(Boolean t, Boolean u) {
            return t | u;
        }

        @Override
        public Boolean id() {
            return true;
        }

        @Override
        public  Boolean invert(Boolean t) {
            return !t;
        }
    }

    //Here we have to implement GroupUnary. We have to understand what id is. Its inversion is the NOT?
    private class Bool_Buffer implements Group<Boolean> {
        @Override
        public Boolean apply(Boolean t, Boolean u) {
            return t & u;
        }

        @Override
        public Boolean id() {
            return true;
        }

        @Override
        public  Boolean invert(Boolean t) {
            return !t;
        }
    }

    //Here we have to implement GroupUnary. We have to understand what id is. Its inversion is the XNOR?
    private class Bool_Xnor implements Group<Boolean> {
        @Override
        public Boolean apply(Boolean t, Boolean u) {
            return t ^ u;
        }

        @Override
        public Boolean id() {
            return true;
        }

        @Override
        public  Boolean invert(Boolean t) {
            return !t;
        }
    }





    //Boolean And Group (bifunc,id,inverse)
    public static class BooleanAnd {
        public static Semigroup<Boolean> func = (a, b) -> a & b;
        public static int id = 0;
    }

    //Boolean Or Group (bifunc,id,inverse)
    public static class BooleanOr {
        public static Semigroup<Boolean> func = (a, b) -> a | b;
        public static int id = 1;
    }

    //Boolean Xor Group (bifunc,id,inverse)
    public static class BooleanXor {
        public static Semigroup<Boolean> func = (a, b) -> a ^ b;
        public static int id = 2;
    }

    //Boolean Buffer Group (bifunc,id,inverse)
    public static class Boolean_Buffer{
        public static SemiGroupUnary<Boolean> func = (a) -> a;
        public static int id = 3;
    }

    //Boolean Not Group (bifunc,id,inverse)
    public static class Boolean_Not{
        public static SemiGroupUnary<Boolean> func = (a) -> !a;
        public static int id = 4;
    }

    //Boolean Nand Group (bifunc,id,inverse)
    public static class BooleanNand {
        public static Semigroup<Boolean> func = (a, b) -> !(a & b);
        public static int id = 5;
    }

    //Boolean Nor Group (bifunc,id,inverse)
    public static class BooleanNor {
        public static Semigroup<Boolean> func = (a, b) -> !(a | b);
        public static int id = 6;
    }

    //Boolean Xnor Group (bifunc,id,inverse)
    public static class BooleanXnor {
        public static Semigroup<Boolean> func = (a, b) -> !(a ^ b);
        public static int id = 7;
    }



    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        boolean t = true;
        boolean f = false;

        boolean bool_and = BooleanCategory.BooleanAnd.func.apply(f, f);
        boolean bool_and1 = BooleanCategory.BooleanAnd.func.apply(f, t);
        boolean bool_and2 = BooleanCategory.BooleanAnd.func.apply(t, f);
        boolean bool_and3 = BooleanCategory.BooleanAnd.func.apply(t, t);
        System.out.println("AND Table:      " + bool_and + "   " + bool_and1 + "   " + bool_and2+ "   " + bool_and3);

        boolean bool_or = BooleanCategory.BooleanOr.func.apply(f, f);
        boolean bool_or1 = BooleanCategory.BooleanOr.func.apply(f, t);
        boolean bool_or2 = BooleanCategory.BooleanOr.func.apply(t, f);
        boolean bool_or3 = BooleanCategory.BooleanOr.func.apply(t, t);
        System.out.println("OR Table:      " +bool_or + "   " + bool_or1 + "   " + bool_or2+ "   " + bool_or3);

        boolean bool_xor = BooleanCategory.BooleanXor.func.apply(f, f);
        boolean bool_xor1 = BooleanCategory.BooleanXor.func.apply(f, t);
        boolean bool_xor2 = BooleanCategory.BooleanXor.func.apply(t, f);
        boolean bool_xor3 = BooleanCategory.BooleanXor.func.apply(t, t);
        System.out.println("XOR Table:      " +bool_xor + "   " + bool_xor1 + "   " + bool_xor2+ "   " + bool_xor3);

        boolean bool_buffer = BooleanCategory.Boolean_Buffer.func.apply(f);
        boolean bool_buffer1 = BooleanCategory.Boolean_Buffer.func.apply(t);
        System.out.println("BUFFER Table:      " +bool_buffer + "   " + bool_buffer1);

        boolean bool_not = BooleanCategory.Boolean_Not.func.apply(f);
        boolean bool_not1 = BooleanCategory.Boolean_Not.func.apply(t);
        System.out.println("NOT Table:      " +bool_not + "   " + bool_not1);

        boolean bool_nand = BooleanCategory.BooleanNand.func.apply(f, f);
        boolean bool_nand1 = BooleanCategory.BooleanNand.func.apply(f, t);
        boolean bool_nand2 = BooleanCategory.BooleanNand.func.apply(t, f);
        boolean bool_nand3 = BooleanCategory.BooleanNand.func.apply(t, t);
        System.out.println("NAND Table:      " +bool_nand + "   " + bool_nand1 + "   " + bool_nand2+ "   " + bool_nand3);

        boolean bool_nor = BooleanCategory.BooleanNor.func.apply(f, f);
        boolean bool_nor1 = BooleanCategory.BooleanNor.func.apply(f, t);
        boolean bool_nor2 = BooleanCategory.BooleanNor.func.apply(t, f);
        boolean bool_nor3 = BooleanCategory.BooleanNor.func.apply(t, t);
        System.out.println("NOR Table:      " +bool_nor + "   " + bool_nor1 + "   " + bool_nor2+ "   " + bool_nor3);

        boolean bool_xnor = BooleanCategory.BooleanXnor.func.apply(f, f);
        boolean bool_xnor1 = BooleanCategory.BooleanXnor.func.apply(f, t);
        boolean bool_xnor2 = BooleanCategory.BooleanXnor.func.apply(t, f);
        boolean bool_xnor3 = BooleanCategory.BooleanXnor.func.apply(t, t);
        System.out.println("XNOR Table:      " +bool_xnor + "   " + bool_xnor1 + "   " + bool_xnor2+ "   " + bool_xnor3);





        BooleanCategory firstBool = new BooleanCategory();

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }
}
