package com.coderxm;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	void testSendMessage() {
		rabbitTemplate.convertAndSend("hello-queue1", "你好，mq！！！！！");
	}

}
