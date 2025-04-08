//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
    public ArrayList<Integer> jobSequencing(int[] d, int[] p) {
        // code here
        ArrayList<int []>a=new ArrayList<>();
        int n=d.length ,ans=0 ,t=0;
        
        for(int i=0;i<d.length;i++){
            a.add(new int[]{d[i],p[i]});
        }
        Collections.sort(a,(x,y)->y[1]-x[1]);
        
        int max=0;
        for(int i:d)max=Math.max(i,max);
        
        boolean arr[] = new boolean[max + 1];
        
        for(int i1[]:a){
            int x=i1[0];
            int y=i1[1];
            
            for(int i=x;i>0;i--){
                if(arr[i]==false){
                    arr[i]=true;
                    t++;
                    ans+=y;
                    break;
                }
            }
        }
        ArrayList<Integer>ret=new ArrayList<>();
        ret.add(t);
        ret.add(ans);
        
        return ret;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends