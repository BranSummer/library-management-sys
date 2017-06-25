##数据库课设 
——— 课题 图书馆管理系统

###关系模式
* book       （**bookid**,bookname,ISBN,booksort,author,publishname,publishdate,price,pagenum,keywords,registerdate,remarks）
* reader  
   (**readerId**,readerName,gender,typeid,signIndate,remark,password)
* readerType  
(**typeid**,typeName,limitTime,maximun,fine)
* borrow  
(**readerId,bookId,borrowDate**,returnDate,fine,remarks)  
####读者注册
创建一个存储过程pro_regist  
根据界面获取的读者注册信息 在reader表中插入一条数据，插入时需要typeid，根据获取的读者类型名称 连接外表查询readerType表获取typeid，最后返回自增的readerId，该ID作为登录账号使用，用于告知用户。  
###遇到的的异常
>Exception in thread "AWT-EventQueue-0" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to java.lang.Boolean
	at javax.swing.JTable$BooleanRenderer.getTableCellRendererComponent(Unknown Source)
	at javax.swing.JTable.prepareRenderer(Unknown Source)

---
* 异常原因
[Ljava.lang.Object; is the name for Object[].class, the java.lang.Class representing the class of array of Object.
  
* 解决方法：
I should use a Object[] to add a row but not one Object[][]

类型对应编码 

* ElementType        Encoding
1. boolean          ————   Z
2.  byte              ————  B
3.  char                ————C
4. double              ————D
5.  float               ————F
6.  int                 ————I
7. long                ————J
8. short               ————S 
9.  class or interface —— Lclassname;
###关于使用JDBC的一些问题
使用了preparestatement  然后用+号拼接了sql语句，又或者其他一些情况,就会一定概率导致出现报出列名无效的异常，尽量不要使用+号连接 和保持sql语句标准性;  
多表连接查询时，两个表有同样的列名，在查询语句中已确实指明属于哪个表中,在ssms中可正确查询，使用jdbc会报列名不明确异常，解决方式：未select子句所查的列名指定别名
###借阅触发器
每增加一条借阅信息，将book的status修改为借出，反之，当borrow更新还书日期时，将book的status修改为在库

###定时作业
利用sql server 代理实现每日定时执行特定的存储过程，该存储过程用于实现检查超期未还书的用户，并将其拉入至黑名单