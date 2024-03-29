package com.project.travel.config;

import com.project.travel.converter.RoomEntityToReservableRoomResponseConverter;
import com.project.travel.converter.RoomReservationEntityToRoomReservationResponseConverter;
import com.project.travel.converter.RoomReservationRequestToRoomReservationEntityConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

    private Set<Converter> getConverters(){
        Set<Converter> converters = new HashSet<Converter>();
        converters.add(new RoomEntityToReservableRoomResponseConverter());
        converters.add(new RoomReservationRequestToRoomReservationEntityConverter());
        converters.add(new RoomReservationEntityToRoomReservationResponseConverter());
        return converters;
    }

    @Bean
    public ConversionService conversionService(){
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();

        return bean.getObject();
    }
}
