package com.estore.beancreation;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.modelmapper.ModelMapper;

@Factory
public class ModalMapperconfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
