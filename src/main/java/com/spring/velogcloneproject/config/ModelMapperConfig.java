package com.spring.velogcloneproject.config;

import com.spring.velogcloneproject.post.domain.Post;
import com.spring.velogcloneproject.post.domain.dto.PostConverter;
import com.spring.velogcloneproject.post.domain.dto.PostCreateRequest;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.velogcloneproject")
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(PostConverter postConverter) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        modelMapper.addConverter(postConverter);
        return modelMapper;
    }
}
