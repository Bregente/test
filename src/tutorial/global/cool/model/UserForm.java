package tutorial.global.cool.model;

import java.io.Serializable;

import org.slim3.datastore.Model;

import tutorial.global.cool.model.BaseFormObject;


@Model(schemaVersion = 1)
public class UserForm extends BaseFormObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
private String password;
    
    private int type;
    
    private String accountName;
    
    private String lastLog;
    
    private String updatedby;
    
    private String fullName;
    
    private String firstName;
    
    private String lastName;
    
    private String kanaName;
    
    private String affiliation;
    
    private String kanaFirstName;
    
    private String kanaLastName;
    
    private String retypePassword;
    
    private String retypeEmail;
    
    private String retypeAccountName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getLastLog() {
        return lastLog;
    }

    public void setLastLog(String lastLog) {
        this.lastLog = lastLog;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getKanaName() {
        return kanaName;
    }

    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getKanaFirstName() {
        return kanaFirstName;
    }

    public void setKanaFirstName(String kanaFirstName) {
        this.kanaFirstName = kanaFirstName;
    }

    public String getKanaLastName() {
        return kanaLastName;
    }

    public void setKanaLastName(String kanaLastName) {
        this.kanaLastName = kanaLastName;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public String getRetypeEmail() {
        return retypeEmail;
    }

    public void setRetypeEmail(String retypeEmail) {
        this.retypeEmail = retypeEmail;
    }

    public String getRetypeAccountName() {
        return retypeAccountName;
    }

    public void setRetypeAccountName(String retypeAccountName) {
        this.retypeAccountName = retypeAccountName;
    }
    
    

}
