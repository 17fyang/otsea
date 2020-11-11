package com.stu.otsea.redis;

import com.stu.otsea.properties.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * redis集群的实现
 * 1、当前实现是每个服务维护自己的redis client连接
 * 2、还有另一种实现方式是把redis集群连接作为一个服务，并暴露接口供别的服务调用
 * 本质上两种方式的区别是使用代理还是直连的区别，由于redis的快速响应特性，不适合代理访问的方式，所以这里用了直连
 * 但是使用了直连会变得繁琐许多，像需要手动写properties，每个服务如果需要用到redis要手动把redis实例添加到bean中去
 * 如果服务数量过多的话可能会让redis连接数过多
 */
public class JedisClusterClient implements JedisClient {
    private static final Logger logger = LoggerFactory.getLogger(JedisClusterClient.class);
    private JedisCluster jedisCluster;

    public JedisClusterClient() {
        String clusterNodesConfig = RedisProperties.getInstance().getRedisCluster();
        int timeout = RedisProperties.getInstance().getTimeout();
        int maxAttempts = RedisProperties.getInstance().getMaxAttempts();
        int soTimeout = RedisProperties.getInstance().getSoTimeout();
        JedisPoolConfig config = RedisProperties.getInstance().getPoolConfig();
        String password = RedisProperties.getInstance().getPassword();

        Set<HostAndPort> instanceSet = new HashSet<>();
        for (String node : clusterNodesConfig.split(";")) {
            String[] hostAndPort = node.split(":");
            instanceSet.add(new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
        }
        this.jedisCluster = new JedisCluster(instanceSet, timeout, soTimeout, maxAttempts, password, config);

        logger.info("redis cluster init finish !!!");
    }

    private JedisClusterClient(Set<HostAndPort> clusterSet) {
        this.jedisCluster = new JedisCluster(clusterSet);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public long expire(String key, Integer second) {
        return jedisCluster.expire(key, second);
    }

    @Override
    public long del(String key) {
        return jedisCluster.del(key);
    }

}
