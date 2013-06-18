/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.cool.model;

@SuppressWarnings("serial")
public class SearchUserDAO extends UserDAO {

    /** Sort Trigger. */
    private String sortIdx;

    /** Sort Item. */
    private String sortItem;

    /** End Register Date. */
    private String registerDateTo;

    /** End Update Date. */
    private String updateDateTo;

    /** End Last Log Date. */
    private String lastLogDateTo;

    /** Validity. */
    private String validity;

    /**
     * 現在保存したregisterDateTo値を取得する�?
     * @return registerDateTo値
     */
    public String getRegisterDateTo() {
        return registerDateTo;
    }

    /**
     * 新た�?をregisterDateToに設定する�?
     * @param registerDateTo値をregisterDateTo�?��に
     */
    public void setRegisterDateTo(String registerDateTo) {
        this.registerDateTo = registerDateTo;
    }

    /**
     * 現在保存したupdateDateTo値を取得する�?
     * @return updateDateTo値
     */
    public String getUpdateDateTo() {
        return updateDateTo;
    }

    /**
     * 新た�?をupdateDateToに設定する�?
     * @param updateDateTo値をupdateDateTo�?��に
     */
    public void setUpdateDateTo(String updateDateTo) {
        this.updateDateTo = updateDateTo;
    }

    /**
     * 現在保存したlastLogDateTo値を取得する�?
     * @return lastLogDateTo値
     */
    public String getLastLogDateTo() {
        return lastLogDateTo;
    }

    /**
     * 新た�?をlastLogDateToに設定する�?
     * @param lastLogDateTo値をlastLogDateTo�?��に
     */
    public void setLastLogDateTo(String lastLogDateTo) {
        this.lastLogDateTo = lastLogDateTo;
    }

    /**
     * 現在保存したvalidity値を取得する�?
     * @return validity値
     */
    public String getValidity() {
        return validity;
    }

    /**
     * 新た�?をvalidityに設定する�?
     * @param validity値をvalidity�?��に
     */
    public void setValidity(String validity) {
        this.validity = validity;
    }

    /**
     * 現在保存したregisterDateTo値を取得する�?
     * @return sortIdx値
     */
    public String getSortIdx() {
        return sortIdx;
    }

    /**
     * 新た�?をregisterDateToに設定する�?
     * @param 新値をsortIdxに
     */
    public void setSortIdx(String sortIdx) {
        this.sortIdx = sortIdx;
    }

    /**
     * 現在保存したregisterDateTo値を取得する�?
     * @return sortItem値
     */
    public String getSortItem() {
        return sortItem;
    }

    /**
     * 新た�?をregisterDateToに設定する�?
     * @param 新値をsortItemに
     */
    public void setSortItem(String sortItem) {
        this.sortItem = sortItem;
    }

}
