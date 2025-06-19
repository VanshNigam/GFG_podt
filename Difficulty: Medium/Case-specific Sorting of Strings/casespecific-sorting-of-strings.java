class Solution {
    public static String caseSort(String s) {
        // code here
        StringBuilder ans=new StringBuilder();
        int small[]=new int[26];
        int big[]=new int[26];
        
        for(char c:s.toCharArray()){
            if (Character.isUpperCase(c)) big[c-'A']++;
            else small[c-'a']++;
        }
        
        int x=0,y=0;
        for(char c:s.toCharArray()){
            if (Character.isUpperCase(c)) {
                while(x<26){
                    if(big[x]>0){
                        big[x]--;
                        ans.append((char) ('A' + x));
                        break;
                    }x++;
                }
            }else{
                while(y<26){
                    if(small[y]>0){
                        small[y]--;
                        ans.append((char) ('a' + y));
                        break;
                    }y++;
                }
            }
        }
        return ans.toString();
    }
}