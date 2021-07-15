package com.lvxiao.problem31;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-07-13
 */
class Main {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(255, true);
        System.out.println(bitSet.get(64));
    }
}

public class Problem31 {
    private class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int index = nums.length - 1;
        //保存 比nums[i]小的数字与其对应的index
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (index >= 0) {
            int num = nums[index];
            if (!map.isEmpty() && map.lastKey() > num) {
                Entry<Integer, Integer> entry1 = map.higherEntry(num);
                nums[index++] = entry1.getKey();
                if (entry1.getValue() == 1) {
                    map.remove(entry1.getKey());
                } else {
                    map.put(entry1.getKey(), map.get(entry1.getKey()) - 1);
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
                while (!map.isEmpty()) {
                    Entry<Integer, Integer> entry = map.firstEntry();
                    Integer key = entry.getKey();
                    nums[index++] = key;
                    if (entry.getValue() == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
                return;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
            index--;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
