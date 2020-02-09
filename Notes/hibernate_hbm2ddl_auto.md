1. hibernate.hbm2ddl.auto
    - create: 每次加载都会删除上一次的数据库，然后根据model重新生成表，数据会丢失
    - create-drop: 和上面一样，但是sessionFactory关闭后会就会删除表
    - validate: 验证数据库，但不会创建新表
    - update: 第一次时会创建表，之后的启动会自动按照model的更新修改表结构，
    - 这个参数主要是用于自动创建更新验证表结构，如果不是这个需求可以设置为none


