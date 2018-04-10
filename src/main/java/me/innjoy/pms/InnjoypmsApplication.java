package me.innjoy.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InnjoypmsApplication {

    public static void main(String[] args) {
        /*RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
		int id = Integer.parseInt(runtimeMXBean.getName().split("@")[0]);
		System.out.println(id);*/
        SpringApplication.run(InnjoypmsApplication.class, args);
    }
}
