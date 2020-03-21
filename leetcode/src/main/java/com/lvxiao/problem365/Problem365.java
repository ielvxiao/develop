package com.lvxiao.problem365;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/3/21 2:20 下午
 */
public class Problem365 {

    public static void main(String[] args) {
        System.out.println(new Problem365().canMeasureWater(3, 5, 4));
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z || (z > x && z > y) || z == 0) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n + x < x + y && visited.add(n + x)) {
                q.offer(n + x);
            }
            if (n + y < x + y && visited.add(n + y)) {
                q.offer(n + y);
            }
            if (n -x > 0 && visited.add(n -x)) {
                q.offer(n -x);
            }
            if (n -y > 0 && visited.add(n -y)) {
                q.offer(n -y);
            }
            if (q.contains(z)) {
                return true;
            }
        }
        return false;
    }

}
