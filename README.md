# jsets-shiro-spring-boot-starter 应用示例

您可以直接下载编译好的包jsets-shiro-demo.zip，解压之后参照里面的"说明.txt"运行示例。

或者下载源码运行，几点说明：
1、数据库使用mysql建库脚本:src/main/resources/shiro-demo.sql

2、maven中央仓库可能下载不了jcaptcha-1.0-all.jar，推荐您使用阿里的maven仓库，比中央仓库快多了
```	
<mirror>      
  <id>nexus-aliyun</id>    
  <name>nexus-aliyun</name>  
  <url>http://maven.aliyun.com/nexus/content/groups/public</url>    
  <mirrorOf>*</mirrorOf>      
</mirror> 
  ```	
 2、项目中使用了jsets-jdbc-spring-boot-starter.jar,jar包在这里[jsets-jdbc-spring-boot-starter-1.0.0.jar](https://github.com/wj596/packages/blob/master/jsets-jdbc-spring-boot-starter-1.0.0.jar?_blank)，您可以下载后传到本地仓库。
 
 3、运行Application.java，打开localhost:8080/shiro-demo查看实例

  
