1、如果我自己来做，我可能会用自己消息队列中的思想，用多接口+注解的方式来实现
2、修改点，1、线程池，2、springbean获得方法，3,数据同步到redis中，4、提供统一的parent，默认实现redis，如果
有其他数据源需要继承父类重写对应的方法
3、需要同步的数据库表，要创建主键，以map的形式存放到redis，key值为大写的：库名_表名,map的key值为主键的值，map的value为
key=value形式（map）的row数据
4、分页通过key值获得数据的接口已经实现，直接返回给客户端（json格式）和实体的形式一样，如果没有特别的业务处理可以直接返回。
如果有需要将map转化成实体的需求，可以使用common-->beanutil来实现