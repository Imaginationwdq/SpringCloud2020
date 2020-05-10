package com.wdq.springcloud.config;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.context.annotation.Configuration;

/**
 * @Auther: wdq
 * @Date: 2020/5/9 16:09
 * @Description:
 */
@Configuration
@MapperScan({"com.wdq.springcloud.dao"})
public class MyBatisConfig {
}
