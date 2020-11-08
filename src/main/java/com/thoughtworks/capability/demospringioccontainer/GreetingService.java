package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Service
@Scope(
        value = SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class GreetingService {

    String sayHi() {
        return "hello world";
    }
}
