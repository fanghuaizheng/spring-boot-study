package com.example.fhz.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApp
{
    public static void main( String[] args )
    {
    	SpringApplication.run(GatewayApp.class, args);
    }
}
