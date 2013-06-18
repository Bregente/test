/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.base;

import java.io.Serializable;
import java.util.List;

import tutorial.global.common.util.data.ValidationData;

/**
 * 繝吶???�繧???�繝輔か繝ｼ繝�が繝悶ず繧???�繧???�繝医け繝ｩ繧???�縲???�
 * @author richard.go
 */
public class BaseFormObject implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 繝�?Μ繝�???�繧???�繝ｧ繝ｳ逕ｨ繝�???�繧???�荳???�???�???�縲???�
     */
    private List<ValidationData> validationErrors;

    /**
     * 迴???�蝨???�繝ｦ繝ｼ繧???�ID縲???�
     */
    private String userId;

    /**
     * 迴???�蝨???�繝ｦ繝ｼ繧???�繝｡繝ｼ繝ｫ繧???�繝峨Ξ繧???�縲???�
     */
    private String email;
    
    /**
     * 逋ｻ骭???�譌･縲???�
     */
    private String insertDate;
    
    /**
     * 譖ｴ??�???�??�譌･縲???�
     */
    private String updateDate;

    /**
     * 迴???�蝨???�菫晏ｭ倥????�??�殷serId蛟､繧貞叙蠕励??�???�??�九�
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ??�???�??�縺溷???�繧置serId縺???�險???�螳壹??�???�??�九�
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 迴???�蝨???�菫晏ｭ倥????�??�歹mail蛟､繧貞叙蠕励??�???�??�九�
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * ??�???�??�縺溷???�繧弾mail縺???�險???�螳壹??�???�??�九�
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 迴???�蝨???�菫晏ｭ倥????�??�殃nsertDate蛟､繧貞叙蠕励??�???�??�九�
     * @return insertDate
     */
    public String getInsertDate() {
        return insertDate;
    }

    /**
     * ??�???�??�縺溷???�繧段nsertDate縺???�險???�螳壹??�???�??�九�
     * @param insertDate the insertDate to set
     */
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * 迴???�蝨???�菫晏ｭ倥????�??�殷pdateDate蛟､繧貞叙蠕励??�???�??�九�
     * @return updateDate
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * ??�???�??�縺溷???�繧置pdateDate縺???�險???�螳壹??�???�??�九�
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 迴???�蝨???�菫晏ｭ倥????�??�殼alidationErrors蛟､繧貞叙蠕励??�???�??�九�
     * @return validationErrors蛟､
     */
    public List<ValidationData> getValidationErrors() {
        return validationErrors;
    }

    /**
     * ??�???�??�縺溷???�繧致alidationErrors縺???�險???�螳壹??�???�??�九�
     * @param validationErrors蛟､繧致alidationErrors??�???�??�岼縺???�
     */
    public void setValidationErrors(List<ValidationData> validationErrors) {
        this.validationErrors = validationErrors;
    }

}
