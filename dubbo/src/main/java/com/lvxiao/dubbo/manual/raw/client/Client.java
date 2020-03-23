package com.lvxiao.dubbo.manual.raw.client;

import com.lvxiao.dubbo.manual.raw.domain.Student;
import com.lvxiao.dubbo.manual.raw.handler.CallProxyHandler;
import com.lvxiao.dubbo.manual.raw.service.CalculateService;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/28 5:53 下午
 */
public class Client {
    public static void main(String[] args) {
        CallProxyHandler handler = new CallProxyHandler("127.0.0.1", 1111);
        CalculateService calculateService = handler.getService(CalculateService.class);
        Student sta = new Student(1);
        Student stb = new Student(2);
        String result = calculateService.cal(sta, stb);
        System.out.println(result);
    }
}

