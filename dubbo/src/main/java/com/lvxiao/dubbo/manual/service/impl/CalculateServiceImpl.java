package com.lvxiao.dubbo.manual.service.impl;

import com.lvxiao.dubbo.manual.domain.Student;
import com.lvxiao.dubbo.manual.service.CalculateService;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 5:49 下午
 */
public class CalculateServiceImpl implements CalculateService {
    @Override
    public String cal(Student sta, Student stb) {
        return "学生年龄之和：" + (sta.getAge() + stb.getAge());
    }
}
