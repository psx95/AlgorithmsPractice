public class RotatedSortedArray {
  private int max = 0;
  private int min = 0;

  public int search(int[] nums, int target) {
    max = nums.length - 1;
    int result = -1;
    if (max == 0 && target == nums[0]) {
      return 0;
    }
    while (max > 0) {
      result = searchHelper(nums, max, 0, target);
      if (result != -1) {
        break;
      }
    }
    return result;
  }

  int searchHelper(int[] nums, int end, int start, int target) {
    while (nums[start] > nums[end]) {
      start = (start + end) / 2 + 1;
    }
    max = start - 1;
    return binarySearch(nums, end, start, target);
  }

  int binarySearch(int[] arr, int h, int l, int target) {
    if (h >= l) {
      int mid = l + (h - l) / 2;
      if (arr[mid] == target)
        return mid;
      else {
        if (arr[mid] > target) {
          return binarySearch(arr, mid - 1, l, target);
        } else {
          return binarySearch(arr, h, mid + 1, target);
        }
      }
    }
    return -1;
  }
}
