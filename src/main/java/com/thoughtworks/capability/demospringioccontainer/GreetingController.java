package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.spi.ObjectFactory;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@RestController
@Scope(SCOPE_SINGLETON)
public class GreetingController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/greet")
    public String greet() {
        GreetingService greetingService = getFromApplicationContext();
        return greetingService.sayHi();
    }

    GreetingService getFromApplicationContext() {
        return this.context.getBean("prototypeBean", GreetingService.class);
    }

}
