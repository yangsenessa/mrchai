package com.essa.mrchaiemc.common.util;

import org.apache.log4j.Logger;

public class LoggerUtil {

    static String THREAD_LEFT_TAG = "[";

    static String THREAD_RIGHT_TAG = "]";

    static String COMMA = ",";

    public static void info(Logger logger, Object... obj ){

        logger.info(getLogString(obj));

    }


    public static String getLogString(Object... obj){
       StringBuilder log = new StringBuilder();
       log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId()).append(THREAD_RIGHT_TAG);
       for (Object o:obj){
           log.append(o);
           log.append(COMMA);
       }
       return log.toString();

    }
}
