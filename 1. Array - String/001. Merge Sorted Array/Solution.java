class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1; // index of the last element in the sorted of nums1
        int j = n - 1; // index of the last element in nums2
        int k = m + n -1; // index of the last position in nums1 affter merging

        // loop until all elements from nums2 are merged into nums1
        while (j >= 0){
            // if nums1 has element left and the current element in nums1 is larger
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--]; // place nums1's element at position k
            } else {
                nums1[k--] = nums2[j--] // Otherwise, place nums2's element at position k
            }
        }
    }
}