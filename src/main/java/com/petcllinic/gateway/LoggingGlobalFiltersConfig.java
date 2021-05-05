package com.petcllinic.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class LoggingGlobalFiltersConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public GlobalFilter postGlobalFilter(){
        return ((exchange, chain) -> chain.filter(exchange)
                    .then(Mono.fromRunnable(() ->
                            logger.info("Global Post Filter executed: "+exchange.getRequest().getURI()))));
    }
}
