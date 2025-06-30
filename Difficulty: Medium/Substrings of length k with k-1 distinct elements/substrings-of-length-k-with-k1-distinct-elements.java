class Solution {
    public int substrCount(String s, int k) {
        // code here
        int arr[]=new int[26];
        int ans=0;
        for(int i=0;i<k;i++){
            arr[s.charAt(i)+0-'a']++;
        }
        int c=0;
        for(int j=0;j<26;j++){
            if(arr[j]>0)c++;
        }
        if(c==k-1)ans++;
        
        for(int i=k;i<s.length();i++){
            c=0;
            arr[s.charAt(i)+0-'a']++;
            arr[s.charAt(i-k)+0-'a']--;
            
            for(int j=0;j<26;j++){
                if(arr[j]>0)c++;
            }
            if(c==k-1)ans++;
        }
        return ans;
    }
}