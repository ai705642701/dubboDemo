package com.ailibaba.dubbo.consumer;

import com.ailibaba.dubbo.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Consumer {

    public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        DemoService demoService = context.getBean(DemoService.class);

        while (true) {
            try {
                Thread.sleep(1000);
                List<String> permissions = demoService.getPermissions(1L); // call remote method
                System.out.println(permissions); // get result

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
