/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.cool.model;

import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

import tutorial.global.common.base.BaseDAO;

/**
 * Basic model for an Message.
 * @author robert.lao
 */
@Model(kind="Message")
public class MessageDAO extends BaseDAO {

    /** Default Serial ID�?*/
    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private int messageID;

    private String senderID;
    
    private String senderEmail;

    private String receiverID;
    
    private String receiverEmail;

    private String subject;

    private String message;

    private Date sendDate;
    
    private String sendDateFrom;
    
    private String sendDateTo;

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

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSendDateFrom() {
        return sendDateFrom;
    }

    public void setSendDateFrom(String sendDateFrom) {
        this.sendDateFrom = sendDateFrom;
    }

    public String getSendDateTo() {
        return sendDateTo;
    }

    public void setSendDateTo(String sendDateTo) {
        this.sendDateTo = sendDateTo;
    }
}
