package tutorial.global.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-05-20 10:18:10")
/** */
public final class UserFormMeta extends org.slim3.datastore.ModelMeta<tutorial.global.cool.model.UserForm> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> accountName = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "accountName", "accountName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> affiliation = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "affiliation", "affiliation");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> firstName = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "firstName", "firstName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> fullName = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "fullName", "fullName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> kanaFirstName = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "kanaFirstName", "kanaFirstName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> kanaLastName = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "kanaLastName", "kanaLastName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> kanaName = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "kanaName", "kanaName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> lastLog = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "lastLog", "lastLog");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> lastName = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "lastName", "lastName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> password = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "password", "password");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> retypeAccountName = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "retypeAccountName", "retypeAccountName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> retypeEmail = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "retypeEmail", "retypeEmail");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> retypePassword = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "retypePassword", "retypePassword");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.UserForm, java.lang.Integer> type = new org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.UserForm, java.lang.Integer>(this, "type", "type", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> updatedby = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "updatedby", "updatedby");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> email = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> insertDate = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "insertDate", "insertDate");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.UserForm, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.UserForm, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> updateDate = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "updateDate", "updateDate");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm> userId = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.UserForm>(this, "userId", "userId");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.UserForm, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.UserForm, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final UserFormMeta slim3_singleton = new UserFormMeta();

    /**
     * @return the singleton
     */
    public static UserFormMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserFormMeta() {
        super("BaseFormObject", tutorial.global.cool.model.UserForm.class, java.util.Arrays.asList("tutorial.global.model.UserForm"));
    }

    @Override
    public tutorial.global.cool.model.UserForm entityToModel(com.google.appengine.api.datastore.Entity entity) {
        tutorial.global.cool.model.UserForm model = new tutorial.global.cool.model.UserForm();
        model.setAccountName((java.lang.String) entity.getProperty("accountName"));
        model.setAffiliation((java.lang.String) entity.getProperty("affiliation"));
        model.setFirstName((java.lang.String) entity.getProperty("firstName"));
        model.setFullName((java.lang.String) entity.getProperty("fullName"));
        model.setKanaFirstName((java.lang.String) entity.getProperty("kanaFirstName"));
        model.setKanaLastName((java.lang.String) entity.getProperty("kanaLastName"));
        model.setKanaName((java.lang.String) entity.getProperty("kanaName"));
        model.setLastLog((java.lang.String) entity.getProperty("lastLog"));
        model.setLastName((java.lang.String) entity.getProperty("lastName"));
        model.setPassword((java.lang.String) entity.getProperty("password"));
        model.setRetypeAccountName((java.lang.String) entity.getProperty("retypeAccountName"));
        model.setRetypeEmail((java.lang.String) entity.getProperty("retypeEmail"));
        model.setRetypePassword((java.lang.String) entity.getProperty("retypePassword"));
        model.setType(longToPrimitiveInt((java.lang.Long) entity.getProperty("type")));
        model.setUpdatedby((java.lang.String) entity.getProperty("updatedby"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setInsertDate((java.lang.String) entity.getProperty("insertDate"));
        model.setKey(entity.getKey());
        model.setUpdateDate((java.lang.String) entity.getProperty("updateDate"));
        model.setUserId((java.lang.String) entity.getProperty("userId"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        tutorial.global.cool.model.UserForm m = (tutorial.global.cool.model.UserForm) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("accountName", m.getAccountName());
        entity.setProperty("affiliation", m.getAffiliation());
        entity.setProperty("firstName", m.getFirstName());
        entity.setProperty("fullName", m.getFullName());
        entity.setProperty("kanaFirstName", m.getKanaFirstName());
        entity.setProperty("kanaLastName", m.getKanaLastName());
        entity.setProperty("kanaName", m.getKanaName());
        entity.setProperty("lastLog", m.getLastLog());
        entity.setProperty("lastName", m.getLastName());
        entity.setProperty("password", m.getPassword());
        entity.setProperty("retypeAccountName", m.getRetypeAccountName());
        entity.setProperty("retypeEmail", m.getRetypeEmail());
        entity.setProperty("retypePassword", m.getRetypePassword());
        entity.setProperty("type", m.getType());
        entity.setProperty("updatedby", m.getUpdatedby());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("insertDate", m.getInsertDate());
        entity.setProperty("updateDate", m.getUpdateDate());
        entity.setProperty("userId", m.getUserId());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        entity.setProperty("slim3.classHierarchyList", classHierarchyList);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        tutorial.global.cool.model.UserForm m = (tutorial.global.cool.model.UserForm) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        tutorial.global.cool.model.UserForm m = (tutorial.global.cool.model.UserForm) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        tutorial.global.cool.model.UserForm m = (tutorial.global.cool.model.UserForm) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        tutorial.global.cool.model.UserForm m = (tutorial.global.cool.model.UserForm) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        tutorial.global.cool.model.UserForm m = (tutorial.global.cool.model.UserForm) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAccountName() != null){
            writer.setNextPropertyName("accountName");
            encoder0.encode(writer, m.getAccountName());
        }
        if(m.getAffiliation() != null){
            writer.setNextPropertyName("affiliation");
            encoder0.encode(writer, m.getAffiliation());
        }
        if(m.getFirstName() != null){
            writer.setNextPropertyName("firstName");
            encoder0.encode(writer, m.getFirstName());
        }
        if(m.getFullName() != null){
            writer.setNextPropertyName("fullName");
            encoder0.encode(writer, m.getFullName());
        }
        if(m.getKanaFirstName() != null){
            writer.setNextPropertyName("kanaFirstName");
            encoder0.encode(writer, m.getKanaFirstName());
        }
        if(m.getKanaLastName() != null){
            writer.setNextPropertyName("kanaLastName");
            encoder0.encode(writer, m.getKanaLastName());
        }
        if(m.getKanaName() != null){
            writer.setNextPropertyName("kanaName");
            encoder0.encode(writer, m.getKanaName());
        }
        if(m.getLastLog() != null){
            writer.setNextPropertyName("lastLog");
            encoder0.encode(writer, m.getLastLog());
        }
        if(m.getLastName() != null){
            writer.setNextPropertyName("lastName");
            encoder0.encode(writer, m.getLastName());
        }
        if(m.getPassword() != null){
            writer.setNextPropertyName("password");
            encoder0.encode(writer, m.getPassword());
        }
        if(m.getRetypeAccountName() != null){
            writer.setNextPropertyName("retypeAccountName");
            encoder0.encode(writer, m.getRetypeAccountName());
        }
        if(m.getRetypeEmail() != null){
            writer.setNextPropertyName("retypeEmail");
            encoder0.encode(writer, m.getRetypeEmail());
        }
        if(m.getRetypePassword() != null){
            writer.setNextPropertyName("retypePassword");
            encoder0.encode(writer, m.getRetypePassword());
        }
        writer.setNextPropertyName("type");
        encoder0.encode(writer, m.getType());
        if(m.getUpdatedby() != null){
            writer.setNextPropertyName("updatedby");
            encoder0.encode(writer, m.getUpdatedby());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getInsertDate() != null){
            writer.setNextPropertyName("insertDate");
            encoder0.encode(writer, m.getInsertDate());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getUpdateDate() != null){
            writer.setNextPropertyName("updateDate");
            encoder0.encode(writer, m.getUpdateDate());
        }
        if(m.getUserId() != null){
            writer.setNextPropertyName("userId");
            encoder0.encode(writer, m.getUserId());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected tutorial.global.cool.model.UserForm jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        tutorial.global.cool.model.UserForm m = new tutorial.global.cool.model.UserForm();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("accountName");
        m.setAccountName(decoder0.decode(reader, m.getAccountName()));
        reader = rootReader.newObjectReader("affiliation");
        m.setAffiliation(decoder0.decode(reader, m.getAffiliation()));
        reader = rootReader.newObjectReader("firstName");
        m.setFirstName(decoder0.decode(reader, m.getFirstName()));
        reader = rootReader.newObjectReader("fullName");
        m.setFullName(decoder0.decode(reader, m.getFullName()));
        reader = rootReader.newObjectReader("kanaFirstName");
        m.setKanaFirstName(decoder0.decode(reader, m.getKanaFirstName()));
        reader = rootReader.newObjectReader("kanaLastName");
        m.setKanaLastName(decoder0.decode(reader, m.getKanaLastName()));
        reader = rootReader.newObjectReader("kanaName");
        m.setKanaName(decoder0.decode(reader, m.getKanaName()));
        reader = rootReader.newObjectReader("lastLog");
        m.setLastLog(decoder0.decode(reader, m.getLastLog()));
        reader = rootReader.newObjectReader("lastName");
        m.setLastName(decoder0.decode(reader, m.getLastName()));
        reader = rootReader.newObjectReader("password");
        m.setPassword(decoder0.decode(reader, m.getPassword()));
        reader = rootReader.newObjectReader("retypeAccountName");
        m.setRetypeAccountName(decoder0.decode(reader, m.getRetypeAccountName()));
        reader = rootReader.newObjectReader("retypeEmail");
        m.setRetypeEmail(decoder0.decode(reader, m.getRetypeEmail()));
        reader = rootReader.newObjectReader("retypePassword");
        m.setRetypePassword(decoder0.decode(reader, m.getRetypePassword()));
        reader = rootReader.newObjectReader("type");
        m.setType(decoder0.decode(reader, m.getType()));
        reader = rootReader.newObjectReader("updatedby");
        m.setUpdatedby(decoder0.decode(reader, m.getUpdatedby()));
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("insertDate");
        m.setInsertDate(decoder0.decode(reader, m.getInsertDate()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("updateDate");
        m.setUpdateDate(decoder0.decode(reader, m.getUpdateDate()));
        reader = rootReader.newObjectReader("userId");
        m.setUserId(decoder0.decode(reader, m.getUserId()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}