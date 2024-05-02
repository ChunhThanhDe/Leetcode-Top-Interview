import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeArrays(nums1, m, nums2, n);

        int k = m + n;
        quickSort(nums1, 0, k - 1);
        String result = "";

        for (int i = 0; i < k; i++) {
            result += nums1[i] + ", ";
        }

        if (result.length() > 0) {
            result = result.substring(0, result.length() - 2);
        }

        System.out.println("[" + result + "]");
    }

    public static void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i ++) {
            nums1[i] = nums2[i - m];
        }
    }

    public static void quickSort(int[] nums, int low, int high) {
        System.out.print("start quickSort ");
        for (int i = low; i <= high; i++) {

            if (i == low) {
                System.out.print("[");
            }

            System.out.print(nums[i]);

            if (i == high) {
                System.out.print("]\n");
            } else {
                System.out.print(", ");
            }
        }

        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            System.out.print("pivot Index: " + pivotIndex + "\n");
            System.out.print("quickSort left side " + "\n");
            quickSort(nums, low, pivotIndex - 1);
            System.out.print("end quickSort left side " + Arrays.toString(Arrays.stream(nums).toArray()) + "\n");
            System.out.print("quickSort right side" + "\n");
            quickSort(nums, pivotIndex + 1, high);
            System.out.print("end quickSort right side " + Arrays.toString(Arrays.stream(nums).toArray()) + "\n");
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        System.out.print("pivot value: " + pivot + "\n");
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                System.out.print("nums[" + j + "] = " + nums[j] + " <= pivot transfer to the left side\n");
                if (i != j) {
                    swap(nums, i, j);
                    System.out.print(Arrays.toString(Arrays.stream(nums).toArray()) + "\n");
                }

            } else {
                System.out.print("nums[" + j + "] = " + nums[j] + " > pivot transfer to the right side\n");
            }
        }

        System.out.print("swap pivot\n");
        swap(nums, i + 1, high);
        System.out.print("end partition " + Arrays.toString(Arrays.stream(nums).toArray()) + "\n");
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        System.out.print("swap " + "nums[" + i + "] = " + nums[i] + " and " + "nums[" + j + "]" + " = " + nums[j] + "\n");
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}