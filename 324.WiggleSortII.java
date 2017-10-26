// O(nlogn) Time O(n) space
public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            copy[i] = nums[i];
        }
        for (int i = 0; i < nums.length; ++i) {
            int w = i % 2;
            if(w == 0)//Take 2,   1,   0
                nums[i] = copy[(nums.length - 1) / 2 - i / 2];
            else     //Take   5,   4,   3
                nums[i] = copy[nums.length - 1 - i / 2];
        }
        //Take in this order to avoid the case: [4,5,5,6]
    }
}
// O(n) Time O(1) space
class Solution {
  public void wiggleSort(int[] nums) {
    int median = findKthLargest(nums, (nums.length + 1) / 2);
    int n = nums.length;
    int left = 0, i = 0, right = n - 1;

    while (i <= right) {
      int mappedIndex = newIndex(i, n);  //Iterate through 1,3,5,7,0,2,4,6,8...
      int current = nums[mappedIndex];
      /**
       * move current number based on its value, deciding whether it should go to a
       * larger-than median position, or a smaller-than median position.
       *
       * Next larger-than median position is denoted by newIndex[Left]
       * Next smaller-than median position is denoted by newIndex[Right]
       */
      if (current > median) {
        swap(nums, newIndex(left, n), mappedIndex);
        ++left;
        ++i;
      } else if (current < median) {
        swap(nums, newIndex(right, n), mappedIndex);
        --right;
      } else
        ++i;
    }
  }

  private int newIndex(int index, int n) {
    /** example for this mapping
     * n = 6, n|1 = 7
     * Original idx: 0    1    2    3    4    5
     * Mapped idx:   1    3    5    0    2    4
     */
    return (1 + 2 * index) % (n | 1);
  }

  private int findKthLargest(int[] a, int k) {
    int n = a.length;
    int p = quickSelect(a, 0, n - 1, n - k + 1);
    return a[p];
  }

  private int quickSelect(int[] a, int lo, int hi, int k) {
    int i = lo, j = hi, pivot = a[hi];
    while (i < j) {
      if (a[i++] > pivot) swap(a, --i, --j);
    }
    swap(a, i, hi);
    int m = i - lo + 1;
    if (m == k) return i;
    else if (m > k) return quickSelect(a, lo, i - 1, k);
    else return quickSelect(a, i + 1, hi, k - m);
  }

  private void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}