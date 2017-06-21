# library-management-system
————图书馆管理系统  
所用的DBMS:sql server  
用java实现

### 关系模式
* book       （**bookid**,bookname,ISBN,booksort,author,publishname,publishdate,price,pagenum,keywords,registerdate,remarks）
* reader  
   (**readerId**,readerName,gender,typeid,signIndate,remark,password)
* readerType  
(**typeid**,typeName,limitTime,maximun,fine)
* borrow  
(**readerId,bookId,borrowDate**,returnDate,fine,remarks)

#### 读者注册
创建一个存储过程pro_regist  
根据界面获取的读者注册信息 在reader表中插入一条数据，插入时需要typeid，根据获取的读者类型名称
连接外表查询readerType表获取typeid，最后返回自增的readerId，用于告知用户。
#### 借阅触发器
每增加一条借阅信息，将book的status修改为借出，反之，当borrow更新还书日期时，将book的status修改为在库

#### 定时作业
利用sql server 代理实现每日定时执行特定的存储过程，该存储过程用于实现检查超期未还书的用户，并将其拉入至黑名单
