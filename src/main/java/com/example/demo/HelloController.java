package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.CreateMallMerchantParam;
import com.example.demo.model.NotifyPlayerNewMessageCommand;
import com.example.demo.service.UserService;
import netscape.javascript.JSObject;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class HelloController {
    @Autowired
    UserService userService;


    @RequestMapping("test/hello")
    public String hello(@RequestParam("content")Boolean content, @RequestParam(value = "online",defaultValue = "1",required = false)Boolean isOnline){
        System.out.println("The content is "+content);
        System.out.println("The isOnline is "+isOnline);
        return "Hello World";
    }

    @RequestMapping("test/hello2")
    public String hello2(@RequestParam("id")int id,@RequestParam("className")String className,@RequestParam("age")Long age){
        System.out.println("studentId  "+id);
        System.out.println("studentName "+className);
        System.out.println("studentAge"+age);
        return "Hello World";
    }

    //三种构造模式
    //1、重写，传不同的参数，给默认赋值来实现
    //2、建造者模式，通过builder来构建。当有多个类型，多个特有属性的时候，是不适用的
    //3、当需要构建的有多个参数，有多种独特的属性，这时候怎么办？


    @RequestMapping("test/user")
    public String getUser(@RequestParam("userId")String userId){
        return userService.getUserById(userId);
    }

    @RequestMapping("test/testRedis")
    public String testRedis(@RequestParam("userId")String userId){
        return userService.testRedisSet(userId);
    }

    @RequestMapping("test/testRedisTemplate")
    public String testRedisTemplate(@RequestParam("userId")String userId){
        System.out.println("userId = "+userId);
        return userService.testRedisTemplateAdd(userId);
    }

    //测试 zset的add
    @RequestMapping("test/testRedisTemplateZadd")
    public String testRedisTemplateZadd(@RequestParam("userId")String userId){
        return userService.testZAdd(userId);
    }

    //测试 zset的zreverange
    @RequestMapping("test/testRedisTemplateZReverseRange")
    public String testRedisTemplateZReverseRange(@RequestParam("userId")String userId){
        return userService.testZReverseRange(userId);
    }

    //验证valid的使用，只需要在参数前面加上@Valid即可启用
    @RequestMapping("test/testValid")
    public String testValid(@Valid CreateMallMerchantParam param, HttpServletResponse response){
        return userService.testValid(param,response);
    }

    @RequestMapping(value = "test/testOkHttp",method = RequestMethod.POST)
    public String testOkHttp(String msgContent,long userId){
        System.out.println(userId);
        System.out.println(msgContent);
        return "hello";
    }
}
