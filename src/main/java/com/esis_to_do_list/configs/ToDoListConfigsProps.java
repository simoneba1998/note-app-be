package com.esis_to_do_list.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "esis.management.to-do-list")
@Getter
@Setter
public class ToDoListConfigsProps {
    private Integer defaultPageNum = 0;
    private Integer defaultPageSize = 20;
}
