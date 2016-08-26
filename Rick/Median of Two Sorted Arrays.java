public class Solution {
    private int findKthSmallest(int[] a, int m, int begin1, int[] b, int n, int begin2, int k){
        if(m > n)   return findKthSmallest(b, n, begin2, a, m, begin1, k);
        if(m == 0)  return b[begin2 + k - 1];
        if(k == 1)  return Integer.min(a[begin1], b[begin2]);
        int partA = Integer.min(k / 2, m), partB = k - partA;
        if (a[begin1 + partA - 1] == b[begin2 + partB - 1]){
            return a[begin1 + partA - 1];
        }else if(a[begin1 + partA - 1] > b[begin2 + partB - 1]){
            return findKthSmallest(a, m, begin1, b, n - partB, begin2 + partB, k - partB);
        }else{
            return findKthSmallest(a, m - partA, begin1 + partA, b, n, begin2, k - partA);
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length, sum = n + m;
        if(sum % 2 != 0){
            return findKthSmallest(nums1, m, 0, nums2, n, 0, sum/2+1);
        }else{
            return (
            findKthSmallest(nums1, m, 0, nums2, n, 0, sum/2) 
            + findKthSmallest(nums1, m, 0, nums2, n, 0, sum/2+1)
            ) / 2.0;
        }
    }

}