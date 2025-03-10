package br.com.alura.clientelo.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Config {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws java.sql.SQLException {
        return Server.createWebServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}