import java.util.HashSet;
import java.util.Iterator;

public class Hashing {
    public static void main(String[] args) {
        System.out.println("Hi");
        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        set.add(14);
        set.remove(14);
        if(set.contains(12)){
            System.out.println("Yes "+ 12);
        }
        if(set.contains(1)){
            System.out.println("No " + 1);
        }
        Iterator<Integer> it = set.iterator();
        //set.remove(14);
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
