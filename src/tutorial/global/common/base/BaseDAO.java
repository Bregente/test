/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.base;

import java.io.Serializable;

/**
 * Base Database object.
 * @author richard.go
 */
public class BaseDAO implements Serializable {

    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;
    
    /**
     * 現在保存したregisterDate値を取得する�?
     * @return registerDate値
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * 新た�?をregisterDateに設定する�?
     * @param registerDate値をregisterDate�?��に
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
    
    /**
     * 現在保存したupdateDate値を取得する�?
     * @return updateDate値
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 新た�?をupdateDateに設定する�?
     * @param updateDate値をupdateDate�?��に
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 現在保存したstatus値を取得する�?
     * @return status値
     */
    public int getStatus() {
        return status;
    }

    /**
     * 新た�?をstatusに設定する�?
     * @param status値をstatus�?��に
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    /**
     * 現在保存したerrorId値を取得する�?
     * @return errorId値
     */
    public String getErrorId() {
        return errorId;
    }

    /**
     * 新た�?をerrorIdに設定する�?
     * @param errorId値をerrorId�?��に
     */
    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    /** Date of register�?*/
    private String registerDate;
    
    /** �??更新日付�? */
    private String updateDate;

    /** レコードス�??タス�?*/
    private int status;
    
    /** Error ID�?*/
    private String errorId;
}
