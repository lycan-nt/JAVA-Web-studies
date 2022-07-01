package config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.jnosql.diana.api.key.BucketManager;
import org.jnosql.diana.redis.key.Counter;
import org.jnosql.diana.redis.key.RedisBucketManagerFactory;
import org.jnosql.diana.redis.key.RedisConfiguration;
import java.util.*;

@ApplicationScoped
public class RedisProducer {


    private static final String BUCKET = "gods";

    private RedisConfiguration configuration;

    private RedisBucketManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        configuration = new RedisConfiguration();
        managerFactory = configuration.get();
    }

    @Produces
    public BucketManager getManager() {
        return managerFactory.getBucketManager(BUCKET);
    }

    @Produces
    public List<String> getList() {
        return managerFactory.getList("list", String.class);
    }

    @Produces
    public Set<String> getSet() {
        return managerFactory.getSet("set", String.class);
    }

    @Produces
    public Queue<String> getQueue() {
        return managerFactory.getQueue("queue", String.class);
    }

    @Produces
    public Map<String, String> getMap() {
        return managerFactory.getMap("map", String.class, String.class);
    }

    @Produces
    public Counter getCounter() {
        return managerFactory.getCounter("counter");
    }

    @Produces
    public org.jnosql.diana.redis.key.SortedSet getSortedSet() {
        return  managerFactory.getSortedSet("good_score");
    }

}
