class Solution {
    public int totalElements(int[] arr) {
        // code here
        int x=0;
        int y=1;
        int ans=0;
        
        Map<Integer,Integer>mp=new HashMap<>();
        
        mp.put(arr[0],1);
        while(y<arr.length){
            mp.put(arr[y],mp.getOrDefault(arr[y],0)+1);
            
            while(mp.size()>2){
                if(mp.get(arr[x])==1)mp.remove(arr[x]);
                else mp.put(arr[x],mp.get(arr[x])-1);
                x++;
            }
            ans=Math.max(ans,y-x+1);
            y++;
        }
        return ans;
    }
}