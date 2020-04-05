package com.tryingpfq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author tryingpfq
 * @Date 2020/4/5
 */
public class JmsReceiver {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.146.128:61616");
        Connection connection  = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建队列
            Destination destination = session.createQueue("first-queue");
            //创建消费发送这
            MessageConsumer consumer = session.createConsumer(destination);

            TextMessage receive = (TextMessage) consumer.receive();
            System.out.println(receive.getText());
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
