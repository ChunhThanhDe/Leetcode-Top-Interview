class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        // Sort the array of citations in ascending order using QuickSort
        quickSort(citations, 0, n - 1);

        // Iterate from the end of the sorted array to find the H-index
        for (int i = n - 1; i >= 0; i--) {
            // Check if the number of papers with at least (n - i) citations is valid
            if ((n - i) > citations[i]) {
                // If so, the H-index is (n - i - 1) because we need to find the highest number of citations
                // where the number of papers with at least that many citations is valid
                return n - i - 1;
            }
        }
        // If no valid H-index is found, the H-index is n (the case where all papers have at least n citations)
        return n;
    }

    // QuickSort algorithm to sort the array in ascending order
    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(nums, low, high);

            // Recursively sort the elements before and after the pivot
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    // Partition the array around a pivot element
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            // If the current element is less than or equal to the pivot, swap it with the element at i
            if (nums[j] <= pivot) {
                i++;
                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }

        // Place the pivot element in the correct position
        swap(nums, i + 1, high);
        return i + 1;
    }

    // Swap two elements in the array
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
