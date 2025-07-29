class Solution {
    public void sortByLength(String[] arr) {
        List<String> list = Arrays.asList(arr);
        Collections.sort(list, (a, b) -> a.length() - b.length());
        // No need to copy back since Arrays.asList returns a backed list
    }
}
