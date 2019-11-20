1.投递简历 -- HR (SpringBoot SpringCloud RBMQ,Redis) 

学校- 项目 （5-8s）



个人信息

技术栈

项目

各种奖项





校招 - 大四实习 9-11月

社招 - 有工作经验



苏州小公司 -- 苏州同程 --杭州阿里



应用开发  --- 系统开发（大厂）

codeReview



登录 用户名密码验证

```java
//夯实基础---- SpringBoot --- > SpringCloud

if(username == "zhangsan" && password == "abc123"){
    
    // == 引用数据类型 中 比较的是 堆内存地址
    // 业务中 需要比较的是 内容  equals()
    // 为什么要再重写 hashcode方法
    
    //理论
    
}
```



```
pojo: 实体类 Customer , Student,User
dao:(DAO : Data Access Object 数据访问对象) Java与数据库交互，进行数据增删改查（CRUD操作）== JDBC
service : 核心业务层，实现业务逻辑操作的模块 
controller: 控制层 ，直接与前端业务直接交互的，主要接收客户端的参数，数据类型转换，页面分发
util: 工具类 (String -- Date , java.util.Date-- java.sql.Date)

JDK API: 工具包
	java.util.List 
	java.util.Date



接口：组件与组件的通讯协议，实现业务的高安全性与模块之间的低耦合
	项目中 调用支付宝的接口
	       物流接口 : 淘宝调用 圆通的 物流接口
	       短信登录接口，QQ登录，微信登录
	       1. 为什么要使用QQ登录，微信登录？  ===>引流
	       2. 会不会直接访问到QQ登录业务实现？ ==> 接口 ， 核心业务不被暴露
	       
	   
dao: select,query 【偏向数据】
service,controller: get,find 【更偏向于业务】
```

### JDBC编程步骤

```java
1. 加载驱动类 driver
2. 连接数据库 Connection  [连接数据库的重要参数信息 url,username,password]
//1. 安全性    2.低耦合

3. 执行SQL语句 PreparedStatement 
4. 获得执行接口
5. 封装成POJO对象
6. 关闭数据库连接（Connection,PreparedStatement,ResultSet）

```



## 登录请求业务

### 1. 业务分析

```
login.jsp ： 登录请求
LoginServlet.java : 处理登录请求  -- 用户查询成功，跳转到首页 index.jsp
							   -- 用户没有查询到，说明用户名或密码错误的，跳转到登录页面 login.jsp
CustomerDao : 登录数据操作
```



### 2. 核心参考代码

#### login.jsp

```jsp
<form action="login" method="post"> 
    <!-- HTTP协议请求的方式，共有7种，常用的2种，get,post, 默认值get -->
    用户名：<input type="text" name="username"/>
    密码：<input type="password" name="userpwd"/>
    <input type="submit" value="登录"/>
</form>
```



#### 后端的业务处理 controller : LoginServlet

#### web.xml

```xml
<!--========================字符编码过滤器 CharacterEncodingFilter========================= -->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>com.chixing.filter.CharacterEncodingFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>


<servlet>
    <!-- 别名 -->
    <servlet-name>loginServlet</servlet-name>
    <!-- 类全名 : 包名.类名-->
    <servlet-class>com.chixing.controller.LoginServlet</servlet-class>
</servlet>

<servlet-mapping>
	<!-- 别名 -->
    <servlet-name>loginServlet</servlet-name>
    <!-- /虚拟路径（动态路径） -->
    <url-pattern>/login</url-pattern>
</servlet-mapping>
```

#### CharacterEncodingFilter 字符编码过滤器

```java
/**
 * 字符编码处理的过滤器
 */
public class CharacterEncodingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.setCharacterEncoding("urf-8");
        response.setCharacterEncoding("utf-8");
        //放行(放到filterChain 上，继续让其他过滤器继续过滤)
        filterChain.doFilter(request,response);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
```



#### LoginServlet 登录业务处理

```java
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1. 接收页面的参数：用户名，密码
    String username =  request.getParameter("username");
    String userpwd =  request.getParatemer("userpwd");
      //2. 访问dao，逻辑判断： 根据用户名与密码查询用户记录，若存在，则表示登录成功；
      												//若不存在，则表示登录失败
      
     CustomerDao customerDao = new CustomerDaoImpl(); 
     Customer customer =  customerDao.selectByCustNameAndPwd(username,userpwd);
      //3. 登录失败的消息返回到页面中 ,转发forword login.jsp
      if(customer ==null){ //登录失败
          request.setAttribute("loginMsg","用户名或密码错误");         
          request.getRequestDispatcher("/login.jsp").forward(request.response);   //相对路径       
      }else{//4.登录成功 ,用户信息绑定到session;重定向到index.jsp 
          HttpSession session = request.getSession();
          session.setAttribute("loginCustomer",customer);
          response.sendRedirect(request.getContextPath()+"/index.jsp") //绝对路径
      }     
      
  }
```

### 持久层 CustomerDao

#### 接口 CustomerDao

```java
/**
	根据用户名与密码查询用户
	@param username 用户名
	@param userpwd 用户密码
	@return 返回查询到的对应的用户对象
*/
public Customer selectByCustNameAndPwd(String username,String userpwd);
```



#### 实现子类 CustomerDaoImpl  -- JDBC

```java
public Customer selectByCustNameAndPwd(String username,String userpwd){
    Customer customer = null;
    //1. 连接数据库
    Connection connection = DBConnection.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //2. 执行SQL
    String sql ="select cust_id,cust_name,cust_pwd  from customer where cust_name = ? and cust_pwd = ?";
   pstmt = connection.prepareStatement(sql);
   pstmt.setString(1,username);
   pstmt.setString(2,userpwd);
    //3. 获得结果
   rs = pstmt.executeQuery();     
    //4. 封装结果
    while(rs.next()){
      int customerId = rs.getInt(1);
      String customerName = rs.getString(2);
      String customerPwd = rs.getString(3);
      customer = new Customer(customerId,customerName,customerPwd)  
    }
     
    //5. 关闭数据库的连接等
    finally{
         if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt !=null ) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection();
    }
}
```

