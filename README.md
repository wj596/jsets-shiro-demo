# jsets-shiro-spring-boot-starter 应用示例

这是一个简单的例子，用来演示jsets-shiro-spring-boot-starter的功能和使用方式

示例运行说明：

 1、clone下来jsets-shiro-spring-boot-starter项目

 2、maven中央仓库有可能下载不了jcaptcha-1.0-all.jar，推荐您使用阿里的maven仓库。
```	
<mirror>      
  <id>nexus-aliyun</id>    
  <name>nexus-aliyun</name>  
  <url>http://maven.aliyun.com/nexus/content/groups/public</url>    
  <mirrorOf>*</mirrorOf>      
</mirror> 
  ```	

 3、在mysql中新建一个数据库shiro-demo编码UTF-8，执行src/main/resources/jsets-shiro-demo.sql进行建表、导入初始数据。

 4、运行Application.java，浏览器中打开http://localhost:8080/shiro-demo 进入系统。
 
 5、使用用户名"admin"，密码"123"登陆，在"用户管理"界面中可以看到4个测试账号密码都是123，您可以用这些账号进行鉴权测试。
 
 6、本示例使用springboot\freemarker\mybatis-plus\layui构建



  
