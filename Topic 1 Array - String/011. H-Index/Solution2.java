import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        // Sort the array of citations in ascending order
        // Arrays.sort() is a utility method provided by Java to sort arrays.
        // The sorting algorithm used depends on the type of array:
        // - For primitive types (e.g., int[], char[]), Arrays.sort() uses a variant of QuickSort called Dual-Pivot QuickSort,
        //      - Time Complexity: Average Case is O(n log n), Best Case is O(n log n) and Worst Case is O(n^2)
        // - For objects (e.g., Integer[], String[]), Arrays.sort() uses TimSort,
        //      - Time Complexity: O(n log n) is all case
        Arrays.sort(citations);
        
        int n = citations.length;

        // Iterate through the sorted citations array
        for (int i = 0; i < n; i++) {
            // Check if the current citation count is greater than or equal to
            // the number of papers that have at least this many citations
            if (citations[i] >= n - i) {
                // If true, the H-index is the number of papers with at least this many citations
                return n - i;
            }
        }

        // If no valid H-index is found, return 0
        return 0;
    }
}
