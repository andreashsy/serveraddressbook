package LocalAddressBook.FirstVersion.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;

import LocalAddressBook.FirstVersion.model.Contact;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Contact> createRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Contact> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        //template.setKeySerializer(new StringRedisSerializer());
        //template.setValueSerializer(new StringRedisSerializer());
        return template;
    }
    
}
