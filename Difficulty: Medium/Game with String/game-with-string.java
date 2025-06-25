class Solution {
    public int minValue(String s, int k) {
        int ans=0;
        int arr[]=new int[26];
        
        for(char c:s.toCharArray()) arr[c-'a']++;

        while(k>0){
            int max=0;
            for(int i=0;i<26;i++){
                if(arr[i]>arr[max]) max=i;
            }
            arr[max]--; k--;
        }
        for(int i=0;i<26;i++) ans+=arr[i]*arr[i];
        
        return ans;
    }
}