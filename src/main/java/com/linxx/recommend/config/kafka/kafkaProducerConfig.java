package com.linxx.recommend.config.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * 类名:kafkaProducerConfig
 * 描述:kafka发送端配置类
 * 姓名:南风
 * 日期:2021-11-10 17:22
 **/
@EnableKafka
@Configuration
@ConditionalOnProperty(prefix = "spring.kafka", value = "enable")
public class kafkaProducerConfig {

    @Resource
    private kafkaProducerProperties kafkaProducerProperties;

    public Map<String, Object> producerConfigs() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                kafkaProducerProperties.getServers());
        configs.put(ProducerConfig.RETRIES_CONFIG,
                Integer.valueOf(kafkaProducerProperties.getRetries()));
        configs.put(ProducerConfig.BATCH_SIZE_CONFIG,
                Integer.valueOf(kafkaProducerProperties.getBatchSize()));
        configs.put(ProducerConfig.LINGER_MS_CONFIG,
                Integer.valueOf(kafkaProducerProperties.getLingerMs()));
        // Producer异步队列内存的最大值
        configs.put(ProducerConfig.BUFFER_MEMORY_CONFIG,
                Integer.valueOf(kafkaProducerProperties.getBufferMemory()));
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configs.put(ProducerConfig.ACKS_CONFIG,
                kafkaProducerProperties.getAcks());
        return configs;
    }

    @Bean(name = "producerFactory")
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean(name = "kafkaTemplate")
    public KafkaTemplate<String, String> kafkaTemplate(
            @Qualifier("producerFactory") ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
