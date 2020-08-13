package com.example.fhz.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceAApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ServiceAApp.class, args);
    }
}
