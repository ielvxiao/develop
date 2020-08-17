package com.lvxiao.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * forward（转发）：
 *
 * 是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,因为这个跳转过程实在服务器实现的，并不是在客户端实现的所以客户端并不知道这个跳转动作，所以它的地址栏还是原来的地址.
 *
 * redirect（重定向）：
 *
 * 是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.
 *
 * 转发是服务器行为，重定向是客户端行为。
 * @author lvxiao
 * @date 2020/8/17
 */
@Controller
public class ForwardAndRedirectController {

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:https://www.baidu.com/";
    }

    @GetMapping("/forward")
    public String forward() {
        return "forward:/";
    }
}
