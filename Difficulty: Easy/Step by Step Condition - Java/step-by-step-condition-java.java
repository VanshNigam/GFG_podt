class Geeks {
    static void isDivisibleByPrime(int n) {
        // Your code here
        String ans="";
        if(n%2==0)ans="Two";
        if(n%3==0)ans="Three";
        if(n%11==0)ans="Eleven";
        if(ans.length()!=0)
        System.out.println(ans);
        else
        System.out.println("-1");
    }
}