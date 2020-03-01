package com.java.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStarterClass implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(SpringBootStarterClass.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //System.out.println("Inside Run method");
    }
}

/*public class SpringBootStarterClass extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootStarterClass.class);
    }

}*/
