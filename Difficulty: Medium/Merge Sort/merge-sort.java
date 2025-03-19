//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    void merge(int arr[],int st,int mid,int end){
        int left=st;
        int right=mid+1;
        ArrayList<Integer> ans=new ArrayList<>();
        
        while(left<=mid && right<=end){
            if(arr[left]<=arr[right]){
                ans.add(arr[left]);
                left++;
            }else{
                ans.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            ans.add(arr[left]);
            left++; 
        }
        while(right<=end){
            ans.add(arr[right]);
            right++; 
        }
        for(int i=st; i<=end; i++){
            arr[i]=ans.get(i-st);
        }
    }
    void devide(int arr[],int st,int end){
        if(st>=end)return ;
        int mid=(st+end)/2;
        
        devide(arr,st,mid);
        devide(arr,mid+1,end);
        
        merge(arr,st,mid,end);
    }

    void mergeSort(int arr[], int l, int r) {
        // code here
        devide(arr,l,r);
    }
}
