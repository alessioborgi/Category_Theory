import java.util.*;

import java.lang.Integer;

public class TestVector {

    public static void main(String[] args) {

        Vector<Integer> z = new Vector<Integer>();
        Vector<Integer> x = new Vector<Integer>();

        x.add(2);
        x.add(3);
        x.add(5);
        z.add(1);
        z.add(1);
        z.add(0);

        System.out.println(z);
        System.out.println(x);
        System.out.println(x.addition(z));
        System.out.println(x.scalarMul(-1));
        System.out.println(x.length());
        System.out.println(x.dotProduct(x.scalarMul(-1)));
        System.out.println(x.IdMul(x));
        System.out.println(x.subtraction(z));
        //System.out.println(x.scalarDiv(0));
        System.out.println(x.scalarDiv(2));
        System.out.println(z.IdDiv(z));
    }
}
