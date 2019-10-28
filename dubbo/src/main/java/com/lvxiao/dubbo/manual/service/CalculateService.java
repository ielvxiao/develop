package com.lvxiao.dubbo.manual.service;

import com.lvxiao.dubbo.manual.domain.Student;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 5:49 下午
 */
public interface CalculateService {
    String cal(Student sta, Student stb);
}
