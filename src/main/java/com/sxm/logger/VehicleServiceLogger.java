package com.sxm.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class VehicleServiceLogger {

    private final static Logger LOGGER = Logger.getLogger(VehicleServiceLogger.class.getName());

    @Before("execution(* com.sxm.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        LOGGER.info("Entered method : " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.sxm.*.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        LOGGER.info("Exiting method : " + joinPoint.getSignature().getName());
    }

}
