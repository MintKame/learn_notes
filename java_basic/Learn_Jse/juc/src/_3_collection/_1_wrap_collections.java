package _3_collection;
import java.util.*;

public class _1_wrap_collections {

    public static void main(String[] args) {

        Set<Integer> hSet = Collections.synchronizedSet(new HashSet());

        //what's special that can cause fail ?
        //  can't use iterator + modify by other thread

        //how to solve ? -> add synchronized
        synchronized (hSet){    //other methods already sync
            Iterator<Integer> it = hSet.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        }
    }
}


