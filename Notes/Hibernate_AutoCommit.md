1. JDBC的autoCommit属性
    - 每个JDBC Connection都有autoCommit属性，只有执行commit，该Connection中的操作才会在数据库真正执行
    - 如果JDBC的AutoCommit属性是false，且SQL没有显式commit，则SQL语句即使发送到数据库，也没有commit
    - 如果是true，sql语句到数据库会自动commit，也就是commit才会真正执行sql语句
    - 数据库默认是自动提交的，即数据库中autoCommit是false
2. Hibernate的hibernate.connection.autoCommit
    - 用来设置获取到的JDBC Connection的autoCommit属性，hibernate中默认是false
    - session.connection().getAutoCommit() 
3. Hibernate的session.beginTransaction()
    - 这个方法会把session对应的Connection的autoCommit属性设置为false，
    - autoCommit=false相当于Connection开启事务
    - 所以在事务结束的时候要执行transaction.commit()不然到数据库的sql语句都没有commit
4. Hibernate的session.flush()
    - 清理session缓存，先对持久化实例的操作生成sql语句，再将sql语句发送到数据库执行。
    - transaction.commit()和session.close()操作都已经有flush操作，所以commit或close就不用flush
    
