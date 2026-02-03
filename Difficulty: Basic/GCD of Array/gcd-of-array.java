// User function Template for Java

class Solution {
     public int gcd(int N , int arr[]) 
    { 
       //code here.
       int gcd=arr[0];
       for(int i=0;i<N-1;i++){
           gcd=gcd(gcd,arr[i+1]);
       }
       return gcd;
    } 
    static int gcd(int a,int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}