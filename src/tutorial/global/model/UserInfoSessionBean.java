package tutorial.global.model;

import java.io.Serializable;

import org.slim3.datastore.Model;

import tutorial.global.cool.model.BaseFormObject;

/**
 * Slim3 model
 * @author hp.pc
 *
 */
@Model(schemaVersion = 1)
public class UserInfoSessionBean extends BaseFormObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** Current user's user type. */
    private String userType;
  
    /**
     * 現在保存したuserType値を取得する�?
     * @return userType値
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 新た�?をuserTypeに設定する�?
     * @param userType値をuserType�?��に
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

}
