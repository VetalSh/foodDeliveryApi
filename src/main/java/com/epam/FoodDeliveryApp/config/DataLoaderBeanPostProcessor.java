package com.epam.FoodDeliveryApp.config;

import com.epam.FoodDeliveryApp.service.DataLoader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataLoader) {
            ((DataLoader) bean).loadData();
        }
        return bean;
    }
}
