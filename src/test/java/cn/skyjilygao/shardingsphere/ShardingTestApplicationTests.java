package cn.skyjilygao.shardingsphere;

import cn.skyjilygao.shardingsphere.entity.NewestAdAccount;
import cn.skyjilygao.shardingsphere.service.NewestAdAccountService;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ShardingTestApplicationTests {

	@Autowired
	private NewestAdAccountService newestAdAccountService;

	@Test
	void contextLoads() {
		NewestAdAccount newestAdAccount = newestAdAccountService.get(1L);
		System.out.println(JSON.toJSON(newestAdAccount).toString());
	}

	@Test
	void  insert(){
		String str = "{\"disableReason\":0,\"day7SpendYday\":0,\"day1SpendYday\":0,\"spendCap\":10000,\"accountStatus\":1,\"allSpendYday\":0,\"accountId\":\"act_68660d632802186182\",\"timezoneOffsetHoursUtc\":8,\"balance\":0,\"name\":\"111111111\",\"createdTime\":1591250939000,\"timezoneId\":42,\"timezoneName\":\"Asia/Shanghai\",\"currency\":\"USD\",\"age\":0,\"amountSpent\":0,\"nowQuarterSpendYday\":0}";
		NewestAdAccount newestAdAccount = JSON.toJavaObject(JSON.parseObject(str), NewestAdAccount.class);
		newestAdAccount.setGmtCreate(new Date());
		newestAdAccount.setGmtModified(new Date());
		newestAdAccountService.addOrUpdate(newestAdAccount);
	}


}
