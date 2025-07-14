class Solution {
    public boolean divby13(String s) {
        // code here
 int k=13;
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int dig=s.charAt(i)-'0';
            ans=ans*10+dig;
            ans%=k;
        }
        return ans%k==0;    }
}