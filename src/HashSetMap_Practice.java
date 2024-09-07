import java.util.*;

public class HashSetMap_Practice {
    public static void Intersection(int arr1[], int arr2[]){
     //creating a hashset for arr1 and then looping over it and adding to hash-set 1
     HashSet<Integer> set1 = new HashSet<>();
        for (int k : arr1) {
            set1.add(k);
        }
     //now, looping over 2 and adding whats not contained in 1 to the last array
     HashSet<Integer> set3 = new HashSet<>();
        for (int i : arr2) {
            if (set1.contains(i)) {
                set3.add(i);
            }
        }
     System.out.print(set3);
    }
    public static void main(String[] args) {
        //System.out.println("Ok");
        int num1[] = {7,3,9};
        int num2[] = {6,3,9,2,9,4};
        Intersection(num1, num2);
    }
}
