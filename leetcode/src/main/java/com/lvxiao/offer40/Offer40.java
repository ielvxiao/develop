package com.lvxiao.offer40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/20 10:41 上午
 */
public class Offer40 {
    /**
     * 使用堆解决
     */
    public int[] getLeastNumbersHeap(int[] arr, int k) {
        int[] res=null;
        if(k==0||arr.length==0){
            return new int[0];
        }
        res = new int[k];
        Queue<Integer> q = new PriorityQueue<>(k, Comparator.comparingInt(o -> -o));
        for(int a:arr){
            if(q.size()<k){
                q.offer(a);
            }else if(q.peek()>a){
                q.remove();
                q.offer(a);
            }
        }
        for(int i=0;i<k;i++){
            res[i]=q.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer40().getLeastNumbersQuickSearch(new int[]{0,1,2,1}, 1)));
    }
    /**
     * 使用快排
     */
    public int[] getLeastNumbersQuickSearch(int[] arr, int k) {
        if(k==0||arr.length==0){
            return new int[0];
        }
        return qSort(arr, 0, arr.length - 1, k-1);
    }


    private int[] qSort(int[] arr, int lo, int hi, int k) {
        int index = partition(arr, lo, hi);
        if (index == k) {
            return Arrays.copyOf(arr,k+1);
        }
        return index > k ? qSort(arr, index + 1, hi,k):qSort(arr, lo, index - 1,k);
    }
    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}
