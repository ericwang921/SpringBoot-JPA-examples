
### 启动之前

在项目根目录创建一个`.env`文件，为compose.yaml文件内的变量提供源。内容为：
```properties
MYSQL_DBNAME=[dbname]
MYSQL_USERNAME=[user]
MYSQL_PASSWORD=[userpwd]
MYSQL_ROOT_PASSWORD=[rootpwd]
MYSQL_PUBLIC_PORT=[port]
```

在`src.main.resources`目录下创建一个`env`目录，创建一个`config-dev.properties`，为application.yaml文件内的变量提供源。内容为：
```properties
DB_CLASSNAME=com.mysql.cj.jdbc.Driver
DB_URL=jdbc:mysql://localhost:[port]/[dbname]?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
DB_USERNAME=[user]
DB_PASSWORD=[userpwd]
DB_TYPE=[mysql]
```
**中括号"[]"里的内容，需要自行替换**