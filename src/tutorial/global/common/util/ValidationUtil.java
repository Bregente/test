/* -------------------------------------------------------------------------------- 
s * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.util;


import org.apache.commons.lang.StringUtils;

import tutorial.global.common.util.data.ValidationData;


/**
 * 繝輔ぅ繝ｼ繝ｫ繝峨ヰ繝ｪ繝�??�繧??�繝ｧ繝ｳ蜈ｱ騾壹け繝ｩ繧??�縲??�
 * @author richard.go
 */
public class ValidationUtil {

    public static final String FLD_ERR_REQUIRED = "validator.required";

    public static final String FLD_ERR_MAXLENGTH = "validator.maxlength";
    
    public static final String FLD_ERR_MINLENGTH = "validator.minlength";

    public static final String FLD_ERR_REGEX = "validator.regexp";

    public static final String FLD_ERR_EXISTS = "validator.exists";
    
    public static final String FLD_ERR_NOT_MATCH = "validator.notMatch";
    
    public static final String FLD_PASSWORD_NOT_MATCH = "validator.password.notMatch";
    
    public static final String FLD_ACCOUNTNAME_NOT_MATCH = "validator.accountName.notMatch";
    
    public static final String FLD_EMAIL_NOT_MATCH = "validator.email.notMatch";
    
    public static final String FLD_ERR_NOT_EXISTS = "validator.notexists";
    
    public static final String FLD_ERR_ACCOUNTPASS_NOT_MATCH = "validator.accountPass.notMatch";

    /**
     * ?�??�?�??�励°遨??�逋ｽ繝�?ぉ繝�け縲??�
     * @param obj ?�??�?�雎｡繧??�繝悶ず繧??�繧??�繝�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateStrNull(String obj) {
        return !StringUtils.isEmpty(obj);
    }
    
    /**
     * ?�??�?�??�励??�髟ｷ縺輔メ繧??�繝�け縲??�
     * @param obj ?�??�?�雎｡繧??�繝悶ず繧??�繧??�繝�
     * @param length 髟ｷ縺??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateStrMinLen(String obj, int length) {
        if (obj.length() >= length) {   
            return true;
        } else {
            return false;
        }
        
    }

    /**
     * ?�??�?�??�励??�髟ｷ縺輔メ繧??�繝�け縲??�
     * @param obj ?�??�?�雎｡繧??�繝悶ず繧??�繧??�繝�
     * @param length 髟ｷ縺??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateStrLen(String obj, int length) {
        if (obj.length() <= length) {   
            return true;
        } else {
            return false;
        }
        
    }

    /**
     * Regex繧医??�縲∵枚蟄励??�豈碑ｼ??�?�??�?�九�
     * @param obj ?�??�?�雎｡繧??�繝悶ず繧??�繧??�繝�
     * @param pattern REGEX繝代ち繝ｼ繝ｳ
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateStrRegex(String obj, String pattern) {
        return obj.matches(pattern);
    }

    /**
     * HTML縺??�TAG縺??�繝�?ぉ繝�け縲??�
     * @param obj
     * @return
     */
    public static boolean validateHTML(String obj) {
        // TODO: ADD IMPLEMENTATION
        return true;
    }

    /**
     * 遖∵??�??�?�??�?�??�励??�繝�?ぉ繝�け縲??�
     * @param obj
     * @return
     */
    public static boolean validateInvalidChars(String obj) {
        // TODO: ADD IMPLEMENTATION
        return true;
    }

    /**
     * EMAIL蛟､繧堤??�??�隱阪?�??�?�九�
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateEmail(ValidationData data) {
        boolean result = false;
        if (!validateStrNull(data.getFieldValue())) {
            data.setMessageKey(FLD_ERR_REQUIRED);
        }
        else if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
        }
        else if (!validateStrRegex(data.getFieldValue(),
                    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            data.setMessageKey(FLD_ERR_REGEX);
        }
        else if (!validateHTML(data.getFieldValue())) {
            // TODO: ADD IMPLEMENTATION
        }
        else if (!validateInvalidChars(data.getFieldName())) {
            // TODO: ADD IMPLEMENTATION
        }
        else {
            result = true;
        }
        return result;
    }
    
    /**
     * EMAIL蛟､繧堤??�??�隱阪?�??�?�九�
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateEmailNotRequired(ValidationData data) {
        boolean result = false;
        if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
        }
        else if (!validateStrRegex(data.getFieldValue(),
                    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            data.setMessageKey(FLD_ERR_REGEX);
        }
        else if (!validateHTML(data.getFieldValue())) {
            // TODO: ADD IMPLEMENTATION
        }
        else if (!validateInvalidChars(data.getFieldName())) {
            // TODO: ADD IMPLEMENTATION
        }
        else {
            result = true;
        }
        return result;
    }

    /**
     * Required validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateNull(ValidationData data) {
        boolean result = false;
        if (!validateStrNull(data.getFieldValue())) {
            data.setMessageKey(FLD_ERR_REQUIRED);
        }
        else if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
        }
        else if (!validateStrMinLen(data.getFieldValue(), data.getMinLength())) {
            data.setMessageKey(FLD_ERR_MINLENGTH);
        }
        else{
            result = true;
        }
        return result;
    }
    
    /**
     * Length validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateLength(ValidationData data) {
        boolean result = false;
        if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
        }
        else if (!validateStrMinLen(data.getFieldValue(), data.getMinLength())) {
            data.setMessageKey(FLD_ERR_MINLENGTH);
        }
        else{
            result = true;
        }
        return result;
    }
    
    /**
     * String validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateString(ValidationData data) {
        boolean result = true;
        if (!validateStrNull(data.getFieldValue())) {
            data.setMessageKey(FLD_ERR_REQUIRED);
            result = false;
        } else if (!data.getFieldValue().matches("^[a-zA-Z0-9??�??�??�??�縲??�+$")) {
            data.setMessageKey(FLD_ERR_REGEX);
            result = false;
        }
        return result;
    }

    /**
     * Fixed Length String validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateFixedLengthString(ValidationData data) {
        // TODO: ADD IMPLEMENTATION
        return true;
    }

    /**
     * Number validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateNumber(ValidationData data) {
        boolean result = true;
        if (!validateStrNull(data.getFieldValue())) {
            data.setMessageKey(FLD_ERR_REQUIRED);
            result = false;
        }
        else if (!validateStrRegex(data.getFieldValue(), "^[0-9]{1,15}$")) {
            data.setMessageKey(FLD_ERR_REGEX);
            result = false;
        }
        return result;
    }

    /**
     * Fixed Length Number validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateFixedLengthNumber(ValidationData data) {
        return true;
    }

    /**
     * Date validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateDate(ValidationData data) {
        boolean result = true;
        if (!validateStrNull(data.getFieldValue())) {
            data.setMessageKey(FLD_ERR_REQUIRED);
            result = false;
        } else if (!data.getFieldValue().matches("(((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]))")) {
            data.setMessageKey(FLD_ERR_REGEX);
            result = false;
        }
        return result;
    }
    
    /**
     * Account name validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateAccountName(ValidationData data) {
        boolean result = true;
        if (!validateStrNull(data.getFieldValue())) {
            data.setMessageKey(FLD_ERR_REQUIRED);
            result = false;
        } else if (!validateStrMinLen(data.getFieldValue(), data.getMinLength())) {
            data.setMessageKey(FLD_ERR_MINLENGTH);
            result = false;
        } else if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
            result = false;
        }
        return result;
    }

    /**
     * Account name validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateAccountNameRequired(ValidationData data) {
        boolean result = true;
        if (!validateStrNull(data.getFieldValue())) {
            data.setMessageKey(FLD_ERR_REQUIRED);
            result = false;
        } else if (!validateStrMinLen(data.getFieldValue(), data.getMinLength())) {
            data.setMessageKey(FLD_ERR_MINLENGTH);
            result = false;
        } else if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
            result = false;
        }
        return result;
    }
    
    /**
     * Account name validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateAccountNameNotRequired(ValidationData data) {
        boolean result = true;
        if(validateStrNull(data.getFieldValue())){
            if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
                data.setMessageKey(FLD_ERR_MAXLENGTH);
                result = false;
            }else if (!validateStrMinLen(data.getFieldValue(), data.getMinLength())) {
                data.setMessageKey(FLD_ERR_MINLENGTH);
                result = false;
            }
        }
        return result;
    }

    /**
     * Password validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validatePassword(ValidationData data) {
        boolean result = true;
        if (!validateStrNull(data.getFieldValue())) {
            data.setMessageKey(FLD_ERR_REQUIRED);
            result = false;
        } else if (!validateStrMinLen(data.getFieldValue(), data.getMinLength())) {
            data.setMessageKey(FLD_ERR_MINLENGTH);
            result = false;
        } else if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
            result = false;
        }
        return result;
    }
    
    /**
     * Password validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validatePasswordNotRequired(ValidationData data) {
        boolean result = true;
        if(validateStrNull(data.getFieldValue())){
            if (!validateStrMinLen(data.getFieldValue(), data.getMinLength())) {
                data.setMessageKey(FLD_ERR_MINLENGTH);
                result = false;
            }
            else if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
                data.setMessageKey(FLD_ERR_MAXLENGTH);
                result = false;
            }
        }
        return result;
    }
    
    /**
     * Furigana validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateFurigana(ValidationData data) {
        boolean result = true;
        if (!validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
            result = false;
        }
        else if (data.getFieldValue() != null
                && data.getFieldValue().length()>0
                && !data.getFieldValue().matches(
                    "^[\\u30A0}-\\u30FF}]*+$")) {
            data.setMessageKey(FLD_ERR_REGEX);
            result = false;
        }
        return result;
    }
    
    /**
     * Name validation sequence.
     * @param data ?�??�?�雎｡繝�??�繧??�
     * @return true:謌仙粥縲’alse:螟ｱ謨??�
     */
    public static boolean validateName(ValidationData data) {
        boolean result = true;
        if (data.getFieldValue() != null
                && !data.getFieldValue().isEmpty()
                && !validateStrLen(data.getFieldValue(), data.getMaxLength())) {
            data.setMessageKey(FLD_ERR_MAXLENGTH);
            result = false;
        }
        return result;
    }

}
