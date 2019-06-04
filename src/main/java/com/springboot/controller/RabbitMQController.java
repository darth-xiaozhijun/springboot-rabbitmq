package com.springboot.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/rabbitmq")
public class RabbitMQController {
	
	@Resource
	private AmqpTemplate amqpTemplate;

	@RequestMapping(value = "/send.do",method = RequestMethod.GET)
	public String send(){
		
		String content = "Date��" + new Date();
		amqpTemplate.convertAndSend("queue1",content);
		return content;
	}
	
	@RequestMapping(value = "/multiSend.do",method = RequestMethod.GET)
    public String multiSend(){
        StringBuilder times=new StringBuilder();
        for(int i=0;i<10;i++){
            long time=System.nanoTime();
            amqpTemplate.convertAndSend("queue1","��"+i+"�η��͵�ʱ�䣺"+time);
            times.append(time+"<br>");
        }
        return times.toString();
    }
	
	@RequestMapping(value = "/multi2Send.do",method = RequestMethod.GET)
    public String multi2Send(){
        StringBuilder times=new StringBuilder();
        for(int i=0;i<10;i++){
            long time=System.nanoTime();
            amqpTemplate.convertAndSend("queue1","��"+i+"�η��͵�ʱ�䣺"+time);
            amqpTemplate.convertAndSend("queue2","��"+i+"�η��͵�ʱ�䣺"+time);
            times.append(time+"<br>");
        }
        return times.toString();
    }
}
