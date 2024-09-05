class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        quickSort(citations, 0, n - 1);
        for(int i = n -1 ; i >= 0; i --){
            if ((n - i) > citations[i]){
                return n - i - 1;
            }
        }
        return n;
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                if (i != j) {
                    swap(nums, i, j);
                }

            }
        }
        
        swap(nums, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}