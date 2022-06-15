package com.example.myService.aoptime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTrafficAOP {
    @Around("execution(* com.example.myService..*(..))")

    public Object timeTest(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        //System.out.println("Start : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            float timeMs = finish - start;

            if (timeMs/1000>0.1) {
                System.out.println("END : " + joinPoint.toString() + " " + timeMs / 1000 + "초___병목상태 의심!!!");
            }
        }
    }
}
