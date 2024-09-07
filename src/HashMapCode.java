import java.util.*;
import java.math.*;


public class HashMapCode {
    class HashMap<K, V>{
        //creating a node class and its constructor that we shall be using throghout this HashMap<> class
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        //creating the variables in hashmap
        int n;
        int N;
        LinkedList<Node> buckets[];
        //creating the constructor for hashmap and assigning N and the buckets to empty linked-lists
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i< 4; i++){
                buckets[i] = new LinkedList<>();
            }
        }
        public int getbucketindex(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }
        public int searchinLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i = 0; i < ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }
        //creating the first put function
        public void put(K key, V value){
            int bi = getbucketindex(key); //getting the bucket index
            int di = searchinLL(key, bi); //getting the data index
            if(di == -1){ //stating that the node doesn't exist
                buckets[bi].add(new Node(key, value));
                n++;
            }
            else{// stating that the node exists and now, we are just updating it
                buckets[bi].get(di).value = value;
            }

           if((double)n/N < 2.0){
               //rehash
           }
        }

    }




    //The main function
    public static void main(String[] args) {}

}
