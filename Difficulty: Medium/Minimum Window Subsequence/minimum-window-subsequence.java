class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        int i=0;
        int j=0;
        int n=s1.length();
        int m=s2.length();
        int st=-1;
        int len = Integer.MAX_VALUE;
        
        while(i<n){
            if(s1.charAt(i)==s2.charAt(j))j++;
            
            if(j==m){//got as substring
                int end=i;
                j--;
                while(j>=0){
                    if(s1.charAt(i)==s2.charAt(j))j--;
                    i--;
                }
                i++;j++;
                int currlen=end-i+1;
                if(currlen<len){
                    len=currlen;st=i;
                }
            }
            i++;
        }
        if(len==Integer.MAX_VALUE)return "";
        return s1.substring(st, st + len);

    }
}
