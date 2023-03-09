package com.neko.seed;

import com.alibaba.druid.filter.config.ConfigTools;
import com.neko.seed.base.util.DesUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		String s="123456";
		String a="123456";
		System.out.println(DesUtil.getEncryptString(s));
		System.out.println(DesUtil.getEncryptString(a));

	}

}
