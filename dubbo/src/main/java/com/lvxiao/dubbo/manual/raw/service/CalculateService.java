package com.lvxiao.dubbo.manual.raw.service;

import com.lvxiao.dubbo.manual.raw.domain.Student;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 5:49 下午
 */
public interface CalculateService {
    String cal(Student sta, Student stb);
}
