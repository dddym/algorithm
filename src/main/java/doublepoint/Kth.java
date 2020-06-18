package doublepoint;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 题目描述：找到倒数第 k 个的元素。
 * @author liuda@baixing.com
 * @date 2020-06-19 00:58
 */
public class Kth {

    /**
     * 排序，时间复杂度O(NlogN)，空间复杂度 O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆排序，使用小顶堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * 使用快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new Kth().findKthLargest(nums, 2));
        int[] nums1 = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new Kth().findKthLargest1(nums1, 2));
        int[] nums2 = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new Kth().findKthLargest1(nums2, 2));
    }

}
