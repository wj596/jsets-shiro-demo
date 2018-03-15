# jsets-shiro-spring-boot-starter 应用示例

您可以直接下载编译好的包[jsets-shiro-demo.zip](https://github.com/wj596/packages/blob/master/jsets-shiro-demo.zip?_blank)，解压之后参照里面的"说明.txt"运行示例。

您也可以下载使用源码运行示例。

源码编译运行说明：
1、在mysql中新建一个数据库shiro-demo编码UTF-8，执行src/main/resources/jsets-shiro-demo.sql进行建表、导入初始数据。

2、maven中央仓库有可能下载不了jcaptcha-1.0-all.jar，推荐您使用阿里的maven仓库，比maven中央仓库快多了。
```	
<mirror>      
  <id>nexus-aliyun</id>    
  <name>nexus-aliyun</name>  
  <url>http://maven.aliyun.com/nexus/content/groups/public</url>    
  <mirrorOf>*</mirrorOf>      
</mirror> 
  ```	
 2、项目中使用的[jsets-jdbc-spring-boot-starter-1.0.0.jar](https://github.com/wj596/packages/blob/master/jsets-jdbc-spring-boot-starter-1.0.0.jar?_blank)、[jsets-shiro-spring-boot-starter-1.0.2.jar](https://github.com/wj596/packages/blob/master/jsets-shiro-spring-boot-starter-1.0.2.jar?_blank)您可以下载后传到本地仓库。
 
 3、运行Application.java，浏览器中打开http://localhost:8080/shiro-demo 进入系统。
 
 4、使用用户名"admin"，密码"123"登陆，在"用户管理"界面中可以看到4个测试账号密码都是123，您可以用这些账号进行测试。

  
