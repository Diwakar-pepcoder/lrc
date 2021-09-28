import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
        
        int max = arr[0];
        for(int val: arr)max = Math.max(max, val);
        
        int exp = 1;
        
        while(max/exp>0){
            countSort(arr, exp);
            exp *= 10;
        }
  }

  public static void countSort(int[] arr, int exp) {
    
    int fre[] = new int[10];
    
    for(int val: arr){
        int digit = val/exp%10;
        
        fre[digit]++;
    }
    
    for(int i=1;i<10;i++){
        fre[i] += fre[i-1];
    }
    
    int ans[] = new int[arr.length];
    
    for(int i=arr.length-1;i>=0;i--){
        int d = arr[i]/exp%10;// index in fre array
        
        int ind = fre[d]-1;// index in ans array
        ans[ind] = arr[i];
        fre[d]--;
    }
    
    for(int i=0;i<arr.length;i++){
        arr[i] = ans[i];
    }
    
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}