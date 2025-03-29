//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] d, int[] p) {
       int n = d.length;
        Job[] arr = new Job[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Job(d[i], p[i]);
        }
        
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        int maxJobDeadline = 0;
        for (Job a : arr) {
            maxJobDeadline = Math.max(maxJobDeadline, a.deadline);
        }
        
        int[] fillTime = new int[maxJobDeadline];
        Arrays.fill(fillTime, -1);
        
        int profit = 0, jobsDone = 0;
        for (Job a : arr) {
            for (int i = a.deadline - 1; i >= 0; i--) {
                if (fillTime[i] == -1) {
                    fillTime[i] = i;
                    profit += a.profit;
                    jobsDone++;
                    break;
                }
            }
        }
        
        return new ArrayList<>(Arrays.asList(jobsDone, profit));
    }

    class Job {
        int deadline, profit;
        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
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