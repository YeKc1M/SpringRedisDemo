package com.example.redisdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class Controller {

    @Autowired
    private RedisTemplate<String, String> template;

    @GetMapping("/testset")
    public void testset(String key, String value){
        try{
            ValueOperations<String, String> operations = template.opsForValue();
//            template.ops
            operations.set(key, value);
//            template.expire(key, 1, TimeUnit.DAYS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/testget")
    public String testget(String key){
        return template.opsForValue().get(key);
    }

    @GetMapping("testdelete")
    public boolean testremovekey(String key){
        return template.delete(key);
    }
}
