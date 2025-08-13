class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        PriorityQueue<Integer>left=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer>right=new PriorityQueue<>();
        ArrayList<Double>ans=new ArrayList<>();
        
        for(int i:arr){
            if (left.isEmpty() || i <= left.peek()) left.add(i);
            } else {
                right.add(i);
            }
            if(left.size()>right.size()+1){
                right.add(left.poll());
            }else if(left.size()<right.size()){
                left.add(right.poll());
            }
        
            if(left.size()==right.size())ans.add((double)(left.peek()+right.peek())/2);
            else ans.add((double)left.peek());
            
        }
        return ans;
    }
}