/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.cool.model;


/**
 * Basic model for an Message.
 * @author robert.lao
 */
public class MessageItemDAO extends MessageDAO {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String searchMessageID;
    
    private String sord;
    
    private String sidx;

    public String getSearchMessageID() {
        return searchMessageID;
    }

    public void setSearchMessageID(String searchMessageID) {
        this.searchMessageID = searchMessageID;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }
}
