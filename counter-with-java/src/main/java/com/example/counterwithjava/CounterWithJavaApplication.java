package com.example.counterwithjava;

import com.example.counterwithjava.util.SerializedObjectCodec;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.support.AsyncConnectionPoolSupport;
import io.lettuce.core.support.AsyncPool;
import io.lettuce.core.support.BoundedPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CounterWithJavaApplication {

  @Bean
  public RedisURI redisURI(){
    return RedisURI.create("localhost", 6379);
  }

  @Bean
  public RedisClient redisClient(RedisURI uri){
    return RedisClient.create(uri);
  }

  @Bean
  public AsyncPool<StatefulRedisConnection<String, String>> reidsConnectionPool(RedisClient client, RedisURI uri) {
    return AsyncConnectionPoolSupport.createBoundedObjectPool(
        () -> client.connectAsync(StringCodec.ASCII, uri),
        BoundedPoolConfig.create(),
        true
    );
  }

  @Bean
  public AsyncPool<StatefulRedisPubSubConnection<String, Object>> reidsPubSubConnectionPool(RedisClient client, RedisURI uri) {
    return AsyncConnectionPoolSupport.createBoundedObjectPool(
        () -> client.connectPubSubAsync(new SerializedObjectCodec(), uri),
        BoundedPoolConfig.create(),
        true
    );
  }

  public static void main(String[] args) {
    SpringApplication.run(CounterWithJavaApplication.class, args);
  }
}
