import java.util.Collections;

public class SetDifference extends SetCat {

    public SetDifference identity(){
        SetDifference EmptySet = (SetDifference) Collections.emptySet();
        return EmptySet;
    }

    public SetDifference applyDifference(SetDifference a, SetDifference b){
        SetDifference c = new SetDifference();
        for(Object object : a){
            if(!b.contains(object)){
                c.add(object);
            }
        }
        return c;
    }

    public void tryIdentity (SetDifference set){
        if (applyDifference(set, identity()) == set) {
            System.out.println("Identity checked: it works");
        }else{
            System.out.println("Identity Checked: error");
        }
    }

    public static boolean associativityDifference(SetDifference x, SetDifference y, SetDifference z){
        boolean result = true;
        SetDifference a = new SetDifference();
        SetDifference b = new SetDifference();
        SetDifference c = new SetDifference();
        SetDifference d = new SetDifference();
        a.applyDifference(x,y); //x-y
        b.applyDifference(a,z); //(x-y)-z
        c.applyDifference(y,z); //y-z
        d.applyDifference(x,c); //x-(y-z)
        if(b.equals(d) == result){
            System.out.println("Associativity checked: it works");
        }else{
            System.out.println("Associativity checked: error");
        }
        return result;
    }
}
