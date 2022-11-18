package com.stockian.stockian.service;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@PropertySource("classpath:stockian.properties")
public class PropertyLoader {

    @Value("${stockian.dns:#{null}}")
    private String DNS;


    public String getDNS()
    {
        return this.DNS;
    }

}
