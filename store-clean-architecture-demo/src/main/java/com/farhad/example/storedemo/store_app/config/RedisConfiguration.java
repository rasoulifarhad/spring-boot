package com.farhad.example.storedemo.store_app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfiguration {
	
	@Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

	@Value("${spring.redis.username}")
	private String redisUserName;

	@Value("${spring.redis.password}")
	private String redisPassword;
	
	// @Value("${spring.redis.withouttls}")
	// private Boolean redisWithoutTls;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
		if (redisUserName != null && !redisUserName.isEmpty()) {
			configuration.setUsername(redisUserName);
		}
		if (redisPassword != null && !redisPassword.isEmpty()) {
			configuration.setPassword(redisPassword);
		}
		JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().build();
		JedisConnectionFactory factory = new JedisConnectionFactory(configuration, jedisClientConfiguration);
		factory.afterPropertiesSet();
		return factory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		redisTemplate.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		// redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		return redisTemplate;
	}

	// @Bean
    // public RedisTemplate<String, String> redisTemplate() {
    //     RedisTemplate<String, String> redisTemplate  = new RedisTemplate<>();
    //     redisTemplate.setConnectionFactory(jedisConnectionFactory());
    //     return redisTemplate;
    // }

	// @Bean
	// public RedisConnectionFactory redisConnectionFactory() {
	// 	LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
	// 	return connectionFactory;
	// }

	// @Bean
	// public RedisTemplate<String, PrincipalUser> redisTemplate2() {
	// 	RedisTemplate<String, PrincipalUser> template = new RedisTemplate<>();
	// 	template.setConnectionFactory(redisConnectionFactory());
	// 	return template;
	// }

	@Bean
	public Jedis getJedisClient(JedisConnectionFactory jedisConnectionFactory) {
		return (Jedis)jedisConnectionFactory.getConnection().getNativeConnection();
	}
}
