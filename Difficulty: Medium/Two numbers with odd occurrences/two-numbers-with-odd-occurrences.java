//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    public int[] twoOddNum(int arr[], int N) {
        // code here
        int xor=arr[0];
        for(int i=1;i<arr.length;i++)xor^=arr[i];
        
        //find set bit postion 
        int c=0;
        while((xor&(1<<c))==0){
            c++;
        }
        
        int ele1=0,ele2=0;
        for(int i=0;i<arr.length;i++){
            int x=arr[i];
            //set bit vale
            if((x&(1<<c))==0)ele1^=x;
            else ele2^=x;
        }
        return ele1 > ele2 ? new int[]{ele1, ele2} : new int[]{ele2, ele1};
    }
}