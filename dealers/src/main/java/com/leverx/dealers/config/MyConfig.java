package com.leverx.dealers.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.leverx.dealers.controller")
@EnableAspectJAutoProxy
public class MyConfig {


}
