package com.jjo.template.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ControllerLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    /**
     * 処理時間出力
     * @param proceedingJoinPoint proceeding joint point
     * @return 戻り値
     * @throws Throwable 例外
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object logProcessingTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch;
        stopWatch = new StopWatch();
        stopWatch.start();

        Object result;

        try {
            result = proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();
            Signature signature = proceedingJoinPoint.getSignature();
            logger.info("{}.{} Completed in {} ms",
                    signature.getDeclaringTypeName(),
                    signature.getName(),
                    stopWatch.getTotalTimeMillis());
        }

        return result;
    }
}
