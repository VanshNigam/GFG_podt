//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().quickSort(arr, 0, n - 1);
            printArray(arr);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low<high){
        int mid=partition(arr,low,high);
           quickSort(arr,low,mid-1); 
           quickSort(arr,mid+1,high); 
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot=arr[low];
        int l=low+1;
        int r=high;
        
        while(l<=r){
            while(l<=r && arr[l]<pivot)l++;
            while(r>=l && arr[r]>pivot)r--;
            
            if(l<=r)
            {
                int t=arr[l];
                arr[l]=arr[r];
                arr[r]=t;
                l++;
                r--;
            }
        }
        arr[low]=arr[r];
        arr[r]=pivot;
        return r;
    }
}
