package com.skc.labs;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouterBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("kafka:hello-topic?brokers=localhost:9092")
                .log("Message Received from kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}")
                .to("kafka:hello-topic2?brokers=localhost:9092")
                .autoStartup(true);

        from("kafka:hello-topic2?brokers=localhost:9092")
                .log("Message Received from kafka - topic 2: ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]} - topic 2")
                .log("    on the partition ${headers[kafka.PARTITION]} - topic 2")
                .log("    with the offset ${headers[kafka.OFFSET]} - topic 2")
                .log("    with the key ${headers[kafka.KEY]} - topic 2" +
                        "")
                .autoStartup(true);


        rest("/greetings")
                .get()
                .to("bean:myService?method=sayHello(${header.name})");

    }
}
