package com.linxx.recommend.config.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 类名:kafkaProperties
 * 描述:kafka服务端配置
 * 姓名:南风
 * 日期:2021-11-10 17:20
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.kafka.producer" )
public class kafkaProducerProperties {

    private String servers;

    private String retries;

    private String batchSize;

    private String lingerMs;

    private String bufferMemory;

    private String acks;
}
