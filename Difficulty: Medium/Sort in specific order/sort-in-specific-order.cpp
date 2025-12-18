class Solution {
public:
    void sortIt(vector<int>& arr) {

        sort(arr.begin(), arr.end(), [](int a, int b) {

            // even-even → ascending
            if (a % 2 == 0 && b % 2 == 0)
                return a < b;

            // odd-odd → descending
            if (a % 2 != 0 && b % 2 != 0)
                return a > b;

            // even before odd
            return a % 2 != 0;
        });
    }
};
