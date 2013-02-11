Ext.define('TEST.store.StoreUsers',
{
    extend : 'Ext.data.Store',
    model : 'TEST.model.User',
    
    autoLoad : true,
    autoSync : true,

    proxy :
    {
        type : 'rest',
        url : '/template-jersey-spring-jpa/rest/current/users',

        reader :
        {
            type : 'json',
            successProperty : 'success',
            root : 'data'
        },

        writer :
        {
            type : 'json'
        }
    }
});