package com.devsuperior.userrequestsb.processor;

import com.devsuperior.userrequestsb.dto.UserDTO;
import com.devsuperior.userrequestsb.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SelectFieldUserDataProcessorConfig {

    private static Logger logger = LoggerFactory.getLogger(SelectFieldUserDataProcessorConfig.class);
    private int counter = 1;

    @Bean
    public ItemProcessor<UserDTO, User> SelectFieldUserDataProcessor() {
        return new ItemProcessor<UserDTO, User>() {
            @Override
            public User process(UserDTO item) throws Exception {
                User user = new User();
                user.setLogin(item.getLogin());
                user.setName(item.getName());
                user.setAvatarUrl(item.getAvatarUrl());
                logger.info("[PROCESSOR STEP] select user fields " + counter + " - " +  user);
                counter++;
                return user;
            }
        };
    }
}
