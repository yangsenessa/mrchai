package com.essa.mrchaiemc.common.util;

import org.apache.log4j.Logger;

public class LoggerUtil {

    static String THREAD_LEFT_TAG = "[";

    static String THREAD_RIGHT_TAG = "]";

    static String COMMA = ",";

    //todo
    static String ERRLOG = "";

    public static void info(Logger logger, Object... obj) {
        logger.info(getLogString(obj));
    }

    public static void errlog(Exception e, String errInfo) {
        Logger errLog = Logger.getLogger(ERRLOG);
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId())
                .append(THREAD_RIGHT_TAG).append(errInfo);
        errLog.error(errInfo, e);
    }

    public static void errlog(String errInfo){
        Logger errLog = Logger.getLogger(ERRLOG);
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId())
                .append(THREAD_RIGHT_TAG).append(errInfo);
        errLog.error(errInfo);
    }


    public static String getLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId()).append(THREAD_RIGHT_TAG);
        for (Object o : obj) {
            log.append(o);
            log.append(COMMA);
        }
        return log.toString();

    }
}
