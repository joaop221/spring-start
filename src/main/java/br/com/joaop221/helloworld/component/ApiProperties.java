package br.com.joaop221.helloworld.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiProperties {

    @Value("${info.app.external.url}")
    private String externalUrl;

}