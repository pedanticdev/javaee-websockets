package com.pedantic.misc;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class Factory {
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
