import java.util.*;

public class Sorting {








    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei-si+1];
        int x = 0;
        int idx1 = si;
        int idx2 = mid+1;
        while(idx1 <= mid && idx2 <= ei) {
            if(arr[idx1] <= arr[idx2]) {

            }
        }
    }


    public static void divide(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei-si)/2;
        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        conquer(arr,si, mid, ei);
    }








    public static void main(String[] args) {
        int arr[] = {1,3,4,2};


/*        //bubble sort : heaviest element at the end
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j< arr.length - 1; j++){
               if(arr[j] > arr[j+1]){
                   //swap
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
            }
        } */
/*        //selection sort : keeping the lighter index at the beginning by swapping using appropriate indexing
        for(int i = 0; i < arr.length; i++){
            int selected = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[selected] > arr[j]){
                    //swap indexes
                    selected = j;
                }
            }
            //swap
            int temporary = arr[i];
            arr[i] = arr[selected];
            arr[selected] = temporary;
        } */

        //insertion sort : basically we are shifting based on weights. Lightest to the left
/*        for(int i = 1; i < arr.length; i ++) {
            int current = arr[i];
            int j = i-1;
            while( j >=0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        } */
        //printing the sorted array
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(1/2);
    }
}
