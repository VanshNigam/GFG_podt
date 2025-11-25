class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;

        int xr = 0;
        for (int i = 0; i < n; i++) {
            xr ^= arr[i];
            xr ^= (i + 1);
        }

        int number = (xr & -xr);   // rightmost set bit

        int zero = 0, one = 0;

        for (int i = 0; i < n; i++) {
            if ((arr[i] & number) != 0)
                one ^= arr[i];
            else
                zero ^= arr[i];
        }

        for (int i = 1; i <= n; i++) {
            if ((i & number) != 0)
                one ^= i;
            else
                zero ^= i;
        }

        // FIX: decide which is repeating
        int repeating = 0, missing = 0;
        for (int val : arr) {
            if (val == zero) {
                repeating = zero;
                missing = one;
                break;
            }
            if (val == one) {
                repeating = one;
                missing = zero;
                break;
            }
        }

        return new ArrayList<>(Arrays.asList(repeating, missing));
    }
}
