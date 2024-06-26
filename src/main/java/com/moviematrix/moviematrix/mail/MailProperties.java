package com.moviematrix.moviematrix.mail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailProperties {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String protocol;
    private String auth;
    private String starttlsEnable;
    private String debug;
}
