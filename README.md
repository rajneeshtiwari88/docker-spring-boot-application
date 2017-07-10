### Docker Spring Boot Application

This application uses `GET` api to save a name and display the name after saving. This application is inte
grated with docker. If you want to deply it on `Docker` then use following commands.

1. Create/Build a docker image with the application  
```$ mvn clean install docker:build```
2. List all docker images available  
```$ docker images```
3. Run application on docker by mapping 8080 port of system to 8080 port of docker  
```$ docker run -d -p 8080:8080 <image-id>```
4. Run `CURL` to perform operation  
```$ curl -X GET localhost:8080/api/<name-to-be-saved>```
Alternatively, you can open following url in any browser  
```localhost:8080/api/<name-to-be-saved>```  


**NOTE:**
1. Port 8080 can be replaced by any available port on the system
2. User same port in `Step 4` as mapped in `Step 3` 
3. Replace `<name-to-be-saved>` with a name  

Use following command to enable input to port 3306 on system from docker application  
```$ sudo iptables -A INPUT -p tcp --dport 3306 -j ACCEPT```

Use following command to provide access to `the_user_name` on `the_database_name`  
```
GRANT ALL PRIVILEGES ON
the_database_name.* 
TO 
'the_user_name'@'%' 
IDENTIFIED BY 
'password_of_the_user';
```

Edit `/etc/mysql/mysql.conf.d/mysqld.cnf` to enable access of `mysql` from other system in this case docker image  
```bind-address            = 0.0.0.0```
