Ext.define('TEST.model.User',
{
    extend : 'Ext.data.Model',

    fields : [ 'id', 'name', 'address' ],

    validations : [
    {
        type : 'length',
        field : 'name',
        min : 1
    },
    {
        type : 'length',
        field : 'address',
        min : 1
    }
    ]
});