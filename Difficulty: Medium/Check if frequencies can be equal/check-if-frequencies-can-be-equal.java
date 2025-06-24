class Solution {
    boolean sameFreq(String s) {
        // code here
        int arr[]=new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<26;i++){
            if(arr[i]>0)mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        if(mp.size()==1)return true;
        if(mp.size()>2)return false;
        boolean f=false; 
        
        int second=0;int first=0;
        
        int sec=0;int fir=0;
        for(int x:mp.keySet()){
            if(f){
                second=x;
                sec=mp.get(x);
            }
            else {first=x;
                fir=mp.get(x);
            }
            f=true;
        }
        if(fir==1 && first==1)return true;
        if(sec==1 && second==1)return true;
        if(fir==1 &&first>second&& Math.abs(first-second)==1)return true;
        if(sec==1 &&first<second&& Math.abs(first-second)==1)return true;
        return false;
    }
}