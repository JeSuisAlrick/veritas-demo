/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertis.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import java.util.TimeZone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 *
 * @author telfealr
 */
@Configuration
public class AppConfig {
    
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder(ApplicationContext context) {
        return new Jackson2ObjectMapperBuilder()
                .applicationContext(context)
                .annotationIntrospector(new JacksonAnnotationIntrospector())
                .featuresToEnable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .featuresToDisable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
                .timeZone(TimeZone.getTimeZone("America/Jamaica"));
    }
}
