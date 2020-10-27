package cn.skyjilygao.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.skyjilygao.shardingsphere.dao")
@SpringBootApplication
public class ShardingTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingTestApplication.class, args);
	}

}
