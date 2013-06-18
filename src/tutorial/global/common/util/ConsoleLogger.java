/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.util;

import java.util.Date;

import tutorial.global.common.base.Logger;


/**
 * 遶??�譛ｫ縺??�繝ｭ繧??�繧貞�蜉帙け繝ｩ繧??�縲??�
 * @author richard.go
 */
public class ConsoleLogger extends Logger {

    @Override
    public void debug(String className, String message) {
        System.out.println(
            "[DEBUG][" + new Date().toString() + "] " + className + ": " + message);
    }

    @Override
    public void exception(String className, String message) {
        System.out.println(
            "[EXCEPTION][" + new Date().toString() + "] " + className + ": " + message);
    }

    @Override
    public void info(String className, String message) {
        System.out.println(
            "[INFO][" + new Date().toString() + "] " + className + ": " + message);
    }

    @Override
    public void error(String className, String message) {
        System.out.println(
            "[ERROR][" + new Date().toString() + "] " + className + ": " + message);
    }
}
