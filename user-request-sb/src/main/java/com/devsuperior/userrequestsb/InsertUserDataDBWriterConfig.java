package com.devsuperior.userrequestsb;

import com.devsuperior.userrequestsb.entities.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertUserDataDBWriterConfig {

    @Bean
    public ItemWriter<User> InsertUserDataDBWriter() {
        return users -> users.forEach(System.out::println);
    }
}
