/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.constant;

/**
 * ã‚°ãƒ­ãƒ¼ãƒ�ãƒ«å®šæ•°åˆ�æœŸã‚¯ãƒ©ã‚¹ã€?
 * @author richard.go
 */
public interface GlobalConstants {

    /** struts2çµ�æžœ?šãƒ�ãƒªãƒ??ã‚·ãƒ§ãƒ³ã‚’å¤±æ•—æ™‚ã€�strutsã�§è‡ªå‹•çš„ã�«çµ�æžœã�¯ã€Œinputã€�ã�«æˆ»ã�™ã? */
    static String RESULT_INPUT = "input";

    /** struts2çµ�æžœ?šãƒ�ãƒªãƒ??ã‚·ãƒ§ãƒ³ã�Œæ?åŠŸã�™ã‚‹æ™‚ ã€?/
    static String RESULT_VALIDATED = "validated";
    
    /** This is for system admin logged in user. */
    static String RESULT_SYS_AD = "sysAd";
    
    /** This is for member admin logged in user. */
    static String RESULT_MEM_AD = "memAd";
    
    /** This is for general member logged in user */
    static String RESULT_MEM = "member";
    
    /** This is for the restricted user */
    static String USER_RESTRICTED = "userRestricted";
    
    /** This is for failure in login */
    static String LOGIN_FAILURE = "loginFailure";

    static int STATUS_ACTIVE = 1;

    static int STATUS_INACTIVE = 0;

    /** ã‚»ãƒ?‚·ãƒ§ãƒ³ã‚­ãƒ¼?šç�¾åœ¨ãƒ­ã‚°ã‚¤ãƒ³ã�—ã�Ÿãƒ¦ãƒ¼ã‚¶æƒ??ã€?*/
    static String SESSION_KEY_LOGIN_USER = "userSession";

    /** çµ�æžœã‚³ãƒ¼ãƒ‰ï¼šãƒ�ãƒªãƒ??ã‚·ãƒ§ãƒ³ã‚’å¤±æ•—æ™‚ã�®çµ�æžœã‚³ãƒ¼ãƒ‰ã? */
    static String RESULT_CODE_INPUT = "input";

    /** çµ�æžœã‚³ãƒ¼ãƒ‰ï¼šãƒ¦ãƒ¼ã‚¶ã�Œãƒ­ã‚°ã‚¤ãƒ³æ™‚ã?çµ�æžœã‚³ãƒ¼ãƒ‰ã? */
    static String RESULT_CODE_LOGIN_REQUIRED = "loginRequired";

    /** çµ�æžœã‚³ãƒ¼ãƒ‰ï¼šã‚¢ã‚¯ã‚»ã‚¹æ¨©é™�ã�ªã�—ã?çµ�æžœã‚³ãƒ¼ãƒ‰ã? */
    static String RESULT_CODE_NOT_AUTHORIZED = "notAuthorized";

    /** Intercepterã‚¿ã‚¤ãƒ—ï¼?é–‹ç™ºæ™‚ã?æ¨©é™�ã‚’ã‚¹ã‚­ãƒ??ã�™ã‚‹ã€?*/
    static String INTERCEPTOR_PARAM_DEBUG_MODE = "debugMode";

    /** Intercepterã‚¿ã‚¤ãƒ—ï¼?ã‚¢ã‚¯ã‚·ãƒ§ãƒ³ã‚’ã‚¢ã‚¯ã‚»ã‚¹ã�™ã‚‹æ™‚ã?å¿??ã�ªãƒ¦ãƒ¼ã‚¶ã‚¿ã‚¤ãƒ—ã? */
    static String INTERCEPTOR_PARAM_REQ_USER_TYPE = "userTypeReq";

    static String PARAM_DEBUG_ON = "true";
    static String PARAM_DEBUG_OFF = "false";

    /** UserType: System Administrator. */
    static String PARAM_REQ_USER_TYPE_SYS_AD = "sysAd";
    
    /** UserType: Member Admin. */
    static String PARAM_REQ_USER_TYPE_ADMIN = "admin";
    
    /** UserType: Member. */
    static String PARAM_REQ_USER_TYPE_MEMBER = "member";
    
    /** UserType: Member. */
    static String PARAM_REQ_USER_TYPE_MEMBER_B = "memberB";
    
    /** UserType: Restricted User. */
    static String PARAM_REQ_USER_TYPE_NO_RESTRICT = "noRestriction";
    
    /** Validation Error */
    static String VALIDATION_ERROR = "validationError";
    
    /** General maximum length */
    static int GENERAL_MAX_LENGTH = 30;
    
    /** General minimum length */
    static int GENERAL_MIN_LENGTH = 6;
    
    /** Account Name length */
    static int ACCOUNT_NAME_LENGTH = 30;
    
    /** Account Name minimum length */
    static int ACCOUNT_NAME_MIN_LENGTH = 6;
    
    /** Password max length */
    static int PASSWORD_MAX_LENGTH = 100;
    
    /** Password min length */
    static int PASSWORD_MIN_LENGTH = 8;
    
    /** Kana Surname length */
    static int KANA_SURNAME_LENGTH = 50;
    
    /** Kana First name length */
    static int KANA_FIRST_NAME_LENGTH = 50;
    
    /** Surname length */
    static int SURNAME_LENGTH = 100;
    
    /** First name length */
    static int FIRST_NAME_LENGTH = 100;
    
    /** Email length */
    static int EMAIL_LENGTH = 255;
    
    /** Message ID length */
    static int MESSAGE_ID_MAX_LENGTH = 10;
    
    /** Message length */
    static int MESSAGE_MAX_LENGTH = 10000;
    
    /** Affiliation length */
    static int AFFILIATION_LENGTH = 50;

    /** UserType: System Administrator. */
    static int USER_TYPE_SYS_AD = 0;

    /** UserType: Administrator. */
    static int USER_TYPE_ADMIN = 1;

    /** UserType: Member. */
    static int USER_TYPE_MEMBER = 2;
    
    /** UserType: Member B. */
    static int USER_TYPE_MEMBER_B = 3;

    /** UserType: No Restriction pass */
    static int USER_TYPE_NO_RESTRICT = -1;
    
    /** Message List Mode: View All */
    static int MESSAGE_LIST_MODE_ALL = 2;
    
    /** Message List Mode: View Sent */
    static int MESSAGE_LIST_MODE_SENT = 1;
    
    /** Message List Mode: View Received */
    static int MESSAGE_LIST_MODE_RECEIVED = 0;

    /** Default display row count if no row count is set. */
    static int DEFAULT_ROW_COUNT = 15;
    
    //paths for slim3
    public static String LOGIN ="login.jsp";
    public static String USER_LIST="userlist.jsp";
    public static String USER_LIST_CONTROLLER="/login/userlist";
    public static String MESSAGE_MANAGEMENT="messagemanagement.jsp";
    public static String ROOT="/login/";
    public static String lOGIN_REDIRECT ="loginRedirect.jsp";
    
    public static String ACCOUNT_NAME_EXISTS_ERROR_ID = "AccountNameExistsErrorID";
    public static String DATABASE_ERROR_ID = "DatabaseExceptionErrorID";

    public static int PASSWORD_LENGTH = 20;
   
    
}
