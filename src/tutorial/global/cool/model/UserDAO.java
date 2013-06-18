package tutorial.global.cool.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import tutorial.global.common.base.BaseDAO;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class UserDAO extends BaseDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String email;

    private String password;

    private String userId;

    private int type;

    private String accountName;

    private String lastLog;

    private String updatedby;

    private String firstName;

    private String lastName;

    private String firstKanaName;
    
    private String lastKanaName;

    private String affiliation;

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
     * 現在保存したpassword値を取得する�?
     * @return password値
     */
    public String getPassword() {
        return password;
    }

    /**
     * 新た�?をpasswordに設定する�?
     * @param password値をpassword�?��に
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * 現在保存したuserId値を取得する�?
     * @return userId値
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 新た�?をuserIdに設定する�?
     * @param userId値をuserId�?��に
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * 現在保存したtype値を取得する�?
     * @return type値
     */
    public int getType() {
        return type;
    }

    /**
     * 新た�?をtypeに設定する�?
     * @param type値をtype�?��に
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * 現在保存したaccountName値を取得する�?
     * @return accountName値
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 新た�?をaccountNameに設定する�?
     * @param accountName値をaccountName�?��に
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    /**
     * 現在保存したlastLog値を取得する�?
     * @return lastLog値
     */
    public String getLastLog() {
        return lastLog;
    }

    /**
     * 新た�?をlastLogに設定する�?
     * @param lastLog値をlastLog�?��に
     */
    public void setLastLog(String lastLog) {
        this.lastLog = lastLog;
    }
    
    /**
     * 現在保存したupdatedby値を取得する�?
     * @return updatedby値
     */
    public String getUpdatedby() {
        return updatedby;
    }

    /**
     * 新た�?をupdatedbyに設定する�?
     * @param updatedby値をupdatedby�?��に
     */
    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }
    
    /**
     * 現在保存したlastName値を取得する�?
     * @return lastName値
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 新た�?をlastNameに設定する�?
     * @param lastName値をlastName�?��に
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 現在保存したfirstName値を取得する�?
     * @return firstName値
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 新た�?をfirstNameに設定する�?
     * @param firstName値をfirstName�?��に
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 現在保存したfirstKanaName値を取得する�?
     * @return firstKanaName値
     */
    public String getFirstKanaName() {
        return firstKanaName;
    }

    /**
     * 新た�?をfirstKanaNameに設定する�?
     * @param firstKanaName値をfirstKanaName�?��に
     */
    public void setFirstKanaName(String firstKanaName) {
        this.firstKanaName = firstKanaName;
    }
    
    /**
     * 現在保存したaffiliation値を取得する�?
     * @return affiliation値
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * 新た�?をaffiliationに設定する�?
     * @param affiliation値をaffiliation�?��に
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
    
    /**
     * 現在保存したlastKanaName値を取得する�?
     * @return lastKanaName値
     */
    public String getLastKanaName() {
        return lastKanaName;
    }

    /**
     * 新た�?をlastKanaNameに設定する�?
     * @param lastKanaName値をlastKanaName�?��に
     */
    public void setLastKanaName(String lastKanaName) {
        this.lastKanaName = lastKanaName;
    }

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserDAO other = (UserDAO) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
