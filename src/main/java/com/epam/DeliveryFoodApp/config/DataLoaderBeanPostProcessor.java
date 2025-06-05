package com.epam.DeliveryFoodApp.config;

import com.epam.DeliveryFoodApp.service.DataLoader;
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
