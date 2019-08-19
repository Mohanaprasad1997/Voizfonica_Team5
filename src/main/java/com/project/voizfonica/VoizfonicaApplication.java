package com.project.voizfonica;

import com.project.voizfonica.data.PlanRepository;
import com.project.voizfonica.model.Plan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class VoizfonicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoizfonicaApplication.class, args);
    }

    @Bean
    public CommandLineRunner planLoader(PlanRepository repo) {
        repo.deleteAll();
        return args -> {
            repo.save(new Plan("ECONOMIC","10 Days","99 INR", "PREPAID"));
            repo.save(new Plan("BUDGET","30 Days","199 INR", "PREPAID"));
            repo.save(new Plan("COMBO","45 Days","249 INR" , "PREPAID"));
            repo.save(new Plan("UNLIMITED","90 Days","399 INR" , "PREPAID"));
            repo.save(new Plan("ECONOMIC","10 Days","49 INR", "POSTPAID"));
            repo.save(new Plan("BUDGET","30 Days","149 INR", "POSTPAID"));
            repo.save(new Plan("COMBO","45 Days","199 INR", "POSTPAID"));
            repo.save(new Plan("UNLIMITED","90 Days","349 INR" , "POSTPAID"));
            repo.save(new Plan("ECONOMIC","30 Days","199 INR", "DONGLE"));
            repo.save(new Plan("BUDGET","45 Days","249 INR", "DONGLE"));
            repo.save(new Plan("COMBO","60 Days","299 INR", "DONGLE"));
            repo.save(new Plan("UNLIMITED","90 Days","399 INR" , "DONGLE"));
        };
    }
}
