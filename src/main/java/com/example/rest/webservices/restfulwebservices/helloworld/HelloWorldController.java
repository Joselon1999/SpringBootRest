package com.example.rest.webservices.restfulwebservices.helloworld;


import com.example.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.apache.tomcat.util.http.parser.AcceptLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
public class HelloWorldController {

    @Autowired
    public MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world %s",name));
    }

    @GetMapping(path = "/hello-world-international")
    public String helloWorldinternational(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null,locale);
    }

}
