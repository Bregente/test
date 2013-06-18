/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.cool.model;


import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

import tutorial.global.common.base.BaseDAO;

/**
 * Basic model for an AdminUser.
 * @author richard.go
 */
@Model(kind="AdminUser")
public class AdminUserDAO extends BaseDAO {

    /** Default Serial ID�?*/
    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /** ユーザID�?*/
    private String userID;

    /** Eメール�?*/
    private String email;

    /** 有効性�?*/
    private boolean validity;

    /**
     * 現在保存したkey値を取得する�?
     * @return key値
     */
    public Key getKey() {
        return key;
    }

    /**
     * 新た�?をkeyに設定する�?
     * @param key値をkey�?��に
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * 現在保存したversion値を取得する�?
     * @return version値
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 新た�?をversionに設定する�?
     * @param version値をversion�?��に
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 現在保存したuserID値を取得する�?
     * @return userID値
     */
    public String getUserID() {
        return userID;
    }

    /**
     * 新た�?をuserIDに設定する�?
     * @param userID値をuserID�?��に
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * 現在保存したemail値を取得する�?
     * @return email値
     */
    public String getEmail() {
        return email;
    }

    /**
     * 新た�?をemailに設定する�?
     * @param email値をemail�?��に
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 現在保存したvalidity値を取得する�?
     * @return validity値
     */
    public boolean isValidity() {
        return validity;
    }

    /**
     * 新た�?をvalidityに設定する�?
     * @param validity値をvalidity�?��に
     */
    public void setValidity(boolean validity) {
        this.validity = validity;
    }

}
