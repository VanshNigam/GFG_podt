

// User function Template for Java
class Solution {
    public int cntSubarrays(int nums[], int k) {
        // code here
         Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int psum[] = new int[n];// PRIFIX SUM

        psum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + nums[i];
        }

        int c = 0;//COUNT 
        for (int j = 0; j < n; j++) {
            if (psum[j] == k) {
                c++;
            }
            int temp = psum[j] - k;
            if (mp.containsKey(temp)) {
                c+=mp.get(temp);//ADD FREQUENCY
            }
            if (!mp.containsKey(psum[j])) {
                mp.put(psum[j],1);
            }else{
                mp.put(psum[j],mp.get(psum[j])+1);
            }
        }
        return c;
    }
}