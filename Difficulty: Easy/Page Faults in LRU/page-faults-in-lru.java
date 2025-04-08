//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    static int pageFaults(int N, int C, int arr[]){

        int c=0,ans=0,x=0;
        ArrayList<Integer>a=new ArrayList<>();
        
        for(int i=0;i<N;i++){
            int curr=arr[i];
            int ind=-1;

            for (int j = 0; j < a.size(); j++) {
                if(a.get(j)==curr){
                    ind=j;
                    break;
                }
            }
            if(ind!=-1)
                a.remove(ind);
            else {
                x++;
                if(a.size()==C)
                    a.remove(0);
            }
            a.add(curr);
        }
        return x;
    }
}