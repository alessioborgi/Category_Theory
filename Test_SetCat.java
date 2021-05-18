import java.util.*;

public class Test_SetCat {

    public static void main(String[] args) {

        SetUnion union1 = new SetUnion();
        union1.add(6);
        union1.add(3);
        union1.add(11);
        union1.add(5);
        union1.add(7);
        union1.add(0);
        union1.add(2);

        SetUnion union2 = new SetUnion();
        union2.add(15);
        union2.add(9);
        union2.add(1);
        union2.add(85);
        union2.add(5);
        union2.add(3);
        union2.add(4);

        SetUnion union3 = new SetUnion();
        System.out.println(SetUnion.associatvityUnion(union1, union2, union3));

        SetUnion test1 = new SetUnion();
        test1.add(6);
        test1.add(3);
        test1.add(11);
        test1.add(5);
        test1.add(7);
        test1.add(0);
        test1.add(2);

        SetCat test2 = new SetCat();
        test2.add(15);
        test2.add(9);
        test2.add(1);
        test2.add(85);
        test2.add(5);
        test2.add(3);
        test2.add(4);

        SetCat test3 = new SetCat();
        System.out.println(test3.CartesianProduct(test1, test2));


    }
}
