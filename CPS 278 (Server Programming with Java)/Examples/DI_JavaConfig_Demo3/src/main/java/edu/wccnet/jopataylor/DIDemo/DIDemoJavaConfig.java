package edu.wccnet.jopataylor.DIDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("edu.wccnet.jopataylor.DIDemo")
@PropertySource("classpath:college.properties")
public class DIDemoJavaConfig {

}
