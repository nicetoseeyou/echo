package lab.nice.echo.service.impl;

import lab.nice.echo.service.IDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

@Service
public class PostIDService implements IDService<Long> {
    private RedisAtomicLong redisAtomicLong;

    @Autowired
    public PostIDService(RedisConnectionFactory connectionFactory) {
        super();
        this.redisAtomicLong = new RedisAtomicLong("POST_ID_SEQ", connectionFactory);
    }

    @Override
    public Long nextID() {
        return redisAtomicLong.incrementAndGet();
    }
}
