package com.devsuperior.userrequestsb.step;

import com.devsuperior.userrequestsb.dto.UserDTO;
import com.devsuperior.userrequestsb.entities.User;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class FetchUserDataAndStoredDBStepConfig {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Value("${chunkSize}")
    private int chunkSize;

    @Bean
    public Step fetchUserDataAndStoredDBStep(ItemReader<UserDTO> fetchUserDataReader,
                                             ItemProcessor<UserDTO, User> selectFieldUserDataProcessor,
                                             ItemWriter<User> insertUserDataDBWriter,
                                             JobRepository jobRepository) {
        return new StepBuilder("fetchUserDataAndStoredDBStep", jobRepository)
                .<UserDTO, User>chunk(chunkSize, transactionManager)
                .reader(fetchUserDataReader)
                .processor(selectFieldUserDataProcessor)
                .writer(insertUserDataDBWriter)
                .build();
    }

}
