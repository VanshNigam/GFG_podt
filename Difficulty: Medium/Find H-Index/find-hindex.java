

// User function Template for Java
class Solution {
    // Function to find hIndex
    public int hIndex(int[] a) {
       int max=0;
    for(int x:a)max=Math.max(x,max);
    int arr[]=new int[max+1];
    
    for(int i=0;i<a.length;i++){
        int x=a[i];
        arr[x]++;
    }
    for(int  j=arr.length-2;j>=0;j-- ){
        arr[j]+=arr[j+1];
    }
    for(int  j=arr.length-1;j>=0;j-- ){
        if(arr[j]>=j)return j;
        // System.out.println(arr[j]+" at "+j);
    }
    return -1;
    }
}