import java.util.*;


public class SetUnion extends SetCat {

    public SetUnion identity() {
        SetUnion EmptySet = (SetUnion) Collections.emptySet();
        return EmptySet;
    }

    public SetUnion applyUnion(SetUnion a, SetUnion b){

        SetUnion c = new SetUnion();
        for (Object obj : a) {c.add(obj);}

        for (Object object : b) {c.add(object);}
        return  c; //there will be no repetitions since Sets already have the primitive propriety of not having repetitions in them
    }

    public void tryIdentity (SetUnion object){
        if (applyUnion(object, identity()) == object){
            System.out.println("Identity checked: works");}
        else{
            System.out.println("Identity checked: error");
        }
    }

    public static boolean associatvityUnion(SetUnion x, SetUnion y, SetUnion z){
        boolean vero = true;
        SetUnion d = new SetUnion();
        SetUnion e = new SetUnion();
        SetUnion f = new SetUnion();
        SetUnion g = new SetUnion();
        d.applyUnion(x, y);//contains x||y
        e.applyUnion(z,d);//contains (x||y)||z
        f.applyUnion(y, z); //contains y||z
        g.applyUnion(f, x); // contains x||(y||z)
        if(e.equals(g) == vero){
            System.out.println("Associativity checked: it works");
        }else{
            System.out.println("Associativity checked: error");
        }
        return vero;
    }
}
