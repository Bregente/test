package tutorial.global.meta;


//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-05-20 13:28:59")
/** */
public final class BaseFormObjectMeta extends org.slim3.datastore.ModelMeta<tutorial.global.cool.model.BaseFormObject> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.BaseFormObject> email = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.BaseFormObject>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.BaseFormObject> insertDate = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.BaseFormObject>(this, "insertDate", "insertDate");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.BaseFormObject, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.BaseFormObject, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.BaseFormObject> updateDate = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.BaseFormObject>(this, "updateDate", "updateDate");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.BaseFormObject> userId = new org.slim3.datastore.StringAttributeMeta<tutorial.global.cool.model.BaseFormObject>(this, "userId", "userId");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.BaseFormObject, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<tutorial.global.cool.model.BaseFormObject, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final BaseFormObjectMeta slim3_singleton = new BaseFormObjectMeta();

    /**
     * @return the singleton
     */
    public static BaseFormObjectMeta get() {
       return slim3_singleton;
    }

    /** */
    public BaseFormObjectMeta() {
        super("BaseFormObject", tutorial.global.cool.model.BaseFormObject.class);
    }

    @Override
    public tutorial.global.cool.model.BaseFormObject entityToModel(com.google.appengine.api.datastore.Entity entity) {
        tutorial.global.cool.model.BaseFormObject model = new tutorial.global.cool.model.BaseFormObject();
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
        tutorial.global.cool.model.BaseFormObject m = (tutorial.global.cool.model.BaseFormObject) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("email", m.getEmail());
        entity.setProperty("insertDate", m.getInsertDate());
        entity.setProperty("updateDate", m.getUpdateDate());
        entity.setProperty("userId", m.getUserId());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        tutorial.global.cool.model.BaseFormObject m = (tutorial.global.cool.model.BaseFormObject) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        tutorial.global.cool.model.BaseFormObject m = (tutorial.global.cool.model.BaseFormObject) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        tutorial.global.cool.model.BaseFormObject m = (tutorial.global.cool.model.BaseFormObject) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        tutorial.global.cool.model.BaseFormObject m = (tutorial.global.cool.model.BaseFormObject) model;
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
        tutorial.global.cool.model.BaseFormObject m = (tutorial.global.cool.model.BaseFormObject) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
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
    protected tutorial.global.cool.model.BaseFormObject jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        tutorial.global.cool.model.BaseFormObject m = new tutorial.global.cool.model.BaseFormObject();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
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