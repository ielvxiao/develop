package com.lvxiao.problem89;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/9 3:32 下午
 */
public class Problem89 {
    /**
     * 格雷码生成，根据其规则生成即可
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<1<<n;i++){
            res.add(i^i>>1);
        }
        return res;
    }
}
