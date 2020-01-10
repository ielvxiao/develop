package com.lvxiao.problem49;

import java.util.*;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/10 2:58 下午
 */
public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(tmp, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
