/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.base;

/**
 * ログベ�?スクラス�?
 * @author richard.go
 */
public abstract class Logger {

    /**
     * �?���?��出力ログ�?
     * @param className 対象ソースクラス
     * @param message 対象出力メ�?��ージ
     */
    public abstract void debug(String className, String message);

    /**
     * INFO出力ログ�?
     * @param className 対象ソースクラス
     * @param message 対象出力メ�?��ージ
     */
    public abstract void info(String className, String message);

    /**
     * ERROR出力ログ�?
     * @param className 対象ソースクラス
     * @param message 対象出力メ�?��ージ
     */
    public abstract void error(String className, String message);

    /**
     * 例外�?力ログ�?
     * @param className 対象ソースクラス
     * @param message 対象出力メ�?��ージ
     */
    public abstract void exception(String className, String message);
}
