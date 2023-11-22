package com.coderxm.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MqListener {

    @RabbitListener(queues = "hello-queue1")
    public void testListenMessage1(String msg) {
        System.out.println("监听者1收到的消息是：" + msg);
    }

    @RabbitListener(queues = "hello-queue1")
    public void testListenMessage2(String msg) throws InterruptedException {
        System.err.println("监听2收到的信息是：" + msg);
        Thread.sleep(20);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void testFanoutExchange1(String msg) {
        System.out.println("从fanout交换机过来这个fanout.queue1队列的信息，内容是：" + msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void testFanoutExchange2(String msg) {
        System.err.println("从fanout交换机过来这个fanout.queue2队列的信息，内容是：" + msg);
    }

    @RabbitListener(queues = "direct.queue1")
    public void testDirectExchange1(String msg) {
        System.err.println("这里是direct.queue1收到内容是：" + msg);
    }

    @RabbitListener(queues = "direct.queue2")
    public void testDirectExchange2(String msg) {
        System.err.println("这里是direct.queue2收到内容是：" + msg);
    }


    /**
     * 可以用此注释指定队列、交换机、routing key，无需去rabbitmq配置
     * 运行此监听后会自动创建，创建之后publisher才能推送信息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.testqueue1", durable = "true"),
            exchange = @Exchange(name = "direct.testexchange1", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void testListener(String msg) {
        System.err.println("direct.testqueue1------：" + msg);
    }

    // 使用了jackson消息转换器接收消息，请看启动类
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "object.queue", durable = "true"),
            exchange = @Exchange(name = "object.exchange", type = ExchangeTypes.TOPIC),
            key = "aaatest"
    ))
    public void objectMessage(Object msg) {
        System.out.println(msg);
    }
}
