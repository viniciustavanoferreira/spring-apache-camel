package com.vtf.microservices.apachecamelmicroservice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://foo?fixedRate=true&period=5000") // Queue
                .transform().constant("Hello from timer - Systems Analyst")
                .bean("getMessageBean")
                .to("log:foo?showAll=true"); // Target microservice
    }
}

@Component
class GetMessageBean {
    public String getMessage() {
        return "{BEAN} Hello from timer - Systems Analyst";
    }
}
