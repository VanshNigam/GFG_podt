class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        Map<Character,Integer>mp=new HashMap<>();
        
        int x=0 ,ans=-1;

        for(int y=0;y<s.length();y++){
            mp.put(s.charAt(y),mp.getOrDefault(s.charAt(y),0)+1);
            while(mp.size()>k){
                char r=s.charAt(x);
                if(mp.get(r)>1)mp.put(r,mp.get(r)-1);
                else mp.remove(r);
                x++;
            }
            if(mp.size()==k)ans=Math.max(ans,y-x+1);
        }
        return ans;
    }
}