public class SetIntersection extends SetCat{

    public SetIntersection identity(SetIntersection a) { return a;}

    public void tryIdentity (SetIntersection b){
        for (Object obj: b){
            if (applyInter(b, identity(b)) == b){
                System.out.println("Identity checked: works");}
            else{
                System.out.println("Identity checked: error");
            }
        }
    }

    public SetIntersection applyInter(SetIntersection x, SetIntersection y) {

        SetIntersection z = new SetIntersection();
        for (Object obj : x) {
            if (y.contains(obj)) {
                z.add(obj);

            }
        }
        return z;
    }


    public static boolean associativityInter(SetIntersection a, SetIntersection b, SetIntersection c){
        boolean flag = true;
        SetIntersection d = new SetIntersection();
        SetIntersection e = new SetIntersection();
        SetIntersection f = new SetIntersection();
        SetIntersection g = new SetIntersection();
        d.applyInter(a,b);//contains x&&y
        e.applyInter(c,d);//contains (x&&y)&&z
        f.applyInter(b,c); //contains y&&z
        g.applyInter(f,a); // contains x&&(y&&z)
        if(e.equals(g) == flag){
            System.out.println("Associativity checked: it works");
        }else{
            System.out.println("Associativity checked: error");
        }
        return flag;

    }
}
