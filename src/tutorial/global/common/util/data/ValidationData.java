/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.util.data;

/**
 * 共通バリ�??ション用�??タ
 * @author richard.go
 */
public class ValidationData {

    /** 対象フィールド名�?*/
    private String fieldName;

    /** フィールド�?�?*/
    private String fieldValue;

    /** �?��フィールド長さ�? */
    private int minLength;

    /** �?��フィールド長さ�? */
    private int maxLength;

    /** メ�?��ージキー�?*/
    private String messageKey;

    /** メ�?��ージ�?*/
    private String message;

    /** 行たバリ�??ション処�?? */
    private String validationType;

    /** 日付�?合�?対象日付フォーマット�? */
    private String dateFormat;

    /**
     * 現在保存したdateFormat値を取得する�?
     * @return dateFormat値
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * 新た�?をdateFormatに設定する�?
     * @param dateFormat値をdateFormat�?��に
     */
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String debugString() {
        return
            "[fieldName := " + this.fieldName + "] "
          + "[fieldValue := " + this.fieldValue + "] "
          + "[minLength := " + this.minLength + "] "
          + "[maxLength := " + this.maxLength + "] "
          + "[messageKey := " + this.messageKey + "] "
          + "[message := " + this.message + "] "
        ;
    }

    /**
     * 現在保存したfieldName値を取得する�?
     * @return fieldName値
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 新た�?をfieldNameに設定する�?
     * @param fieldName値をfieldName�?��に
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 現在保存したfieldValue値を取得する�?
     * @return fieldValue値
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * 新た�?をfieldValueに設定する�?
     * @param fieldValue値をfieldValue�?��に
     */
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    /**
     * 現在保存したminLength値を取得する�?
     * @return minLength値
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * 新た�?をminLengthに設定する�?
     * @param minLength値をminLength�?��に
     */
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    /**
     * 現在保存したmaxLength値を取得する�?
     * @return maxLength値
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 新た�?をmaxLengthに設定する�?
     * @param maxLength値をmaxLength�?��に
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * 現在保存したmessageKey値を取得する�?
     * @return messageKey値
     */
    public String getMessageKey() {
        return messageKey;
    }

    /**
     * 新た�?をmessageKeyに設定する�?
     * @param messageKey値をmessageKey�?��に
     */
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    /**
     * 現在保存したmessage値を取得する�?
     * @return message値
     */
    public String getMessage() {
        return message;
    }

    /**
     * 新た�?をmessageに設定する�?
     * @param message値をmessage�?��に
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 現在保存したvalidationType値を取得する�?
     * @return validationType値
     */
    public String getValidationType() {
        return validationType;
    }

    /**
     * 新た�?をvalidationTypeに設定する�?
     * @param validationType値をvalidationType�?��に
     */
    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }
}
