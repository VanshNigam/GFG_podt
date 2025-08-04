class Solution {
  public:
    bool skip(char z){
        if(z>=65 && z<=90)
          return false;
        if(z>=97 && z<=122)
          return false;
        if(z>=48 && z<=57)
          return false;
        return true;  
    }
  
    bool isPalinSent(string &s) {
        // code here
        int l=0, r=s.size()-1;
        
        while(l<=r){
            if(skip(s[l]))
              l++;
            else if(skip(s[r]))
              r--;
            else{
                char sm1 = (s[l]>=65 && s[l]<=90)?(s[l]+32):s[l]; 
                char sm2 = (s[r]>=65 && s[r]<=90)?(s[r]+32):s[r]; 
                
                if(sm1!=sm2)
                  return false;
                  
                l++;
                r--;
            }  
              
        }
        
        return true;
    }
};