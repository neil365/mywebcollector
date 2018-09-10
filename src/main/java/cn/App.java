package cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages = {"cn.task"})
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("start===========");
    	SpringApplication.run(App.class, args);
    	
    	
    }
}
