class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here.
        int len=arr.length;
        
        int half_length=(len%2!=0) ? (len/2)+1 :  (len/2);
        
        int lucky_count=0;
        
        List<Integer> arrlst=new ArrayList<>();
        
        for(int i=0;i<len;i++){
            if(arr[i]%k==0){
                lucky_count++;
            }
            else{
                
                arrlst.add( (k-(arr[i] % k)) % k );
            }
        }
        if(half_length<=lucky_count){
            return 0;
        }
        
        Collections.sort(arrlst);
        
        int win_count=0,i=0;
        while(lucky_count!=half_length){
            win_count=win_count+arrlst.get(i);    
            lucky_count++;
            i++;
        }
        
        return win_count;
        
    }
}

