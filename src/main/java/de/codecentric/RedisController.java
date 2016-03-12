package de.codecentric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	public RedisController(StringRedisTemplate redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
	}

	@RequestMapping
	public Integer getRedisCount(){
		Integer counter = 0;
		String counterString = redisTemplate.opsForValue().get("counter");
		if (counterString != null){
			counter = Integer.valueOf(counterString)+1;
		}
		redisTemplate.opsForValue().set("counter", counter.toString());
		return counter;
	}

}
