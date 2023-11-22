package com.coderxm;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PublisherApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	void testSendMessage() {
		for (int i = 1; i <= 50; i++) {
			// 直接向队列发送信息，不经过交换机
			rabbitTemplate.convertAndSend("hello-queue1", "你好，mq！！！！！这是消息" + i);
		}
	}

	@Test
	void testFanoutExchange() {
		for (int i = 1; i < 10; i++) {
			// 向交换机发送信息，交换机会把信息转发给绑定的队列
			rabbitTemplate.convertAndSend("test.fanout.exchange", null, "exchange里的消息" + i);
		}
	}

	@Test
	void testDirectExchange1() {
		// 向交换机发送信息，并指定routing key，交换机会把信息转发给绑定并指定了routing key的队列
		rabbitTemplate.convertAndSend("test.direct.exchange", "blue", "这个消息只有routing key 是blue也就是direct.queue1会收到");
	}


	@Test
	void testDirectExchange2() {
		rabbitTemplate.convertAndSend("test.direct.exchange", "red", "这个消息只有routing key 是red也就是direct.queue1和2会收到");
	}

	@Test
	void testDirectTestqueue1() {
		rabbitTemplate.convertAndSend("direct.testexchange1", "red", "测试测试");
	}

	// 使用了jackson消息转换器给队列发送消息，请看启动类
	@Test
	void testObjectMessage() {
		Map<String, Object> msg = new HashMap<>();
		msg.put("name", "jack");
		msg.put("age", 100);
		rabbitTemplate.convertAndSend("object.exchange", "aaatest", msg);
	}
}
