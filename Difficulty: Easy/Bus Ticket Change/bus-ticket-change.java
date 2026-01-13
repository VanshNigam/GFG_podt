class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int n=arr.length;
        if(n==0) return true;
        int five=arr[0]==5?1:0;
        int ten=0;
        if(five==0) return false;
        for(int i=1;i<n;i++){
            
            if(arr[i]==5){
                five++;
            }else if(arr[i]==10){
                if(five==0) return false;
                five--;
                ten++;
            }else{
                if((ten==0 && five<3) || five==0) return false;
                if(ten==0 && five>=3){ 
                    five-=3;
                    continue;
                }else{
                    ten--;
                    five--;
                }
            }
        }
        return true;
    }
}