# SpicesRUS Website

### Installation Instructions

1.) Navigate to https://dev.mysql.com/doc/mysql-getting-started/en/ and follow the instructions to install a MySQL server.

2.) Using the same guide createa a database and user account for this system to access.

3.) Clone this repository and execute `gradlew bootrun` inside of the directory

4.) The application will then stop after generating a `spicesrus.properties` file inside of your home directory

5.) Enter the details of the MySQL server into the required fields

```
spicesrus.properties

password=examplePassword
database=someDatabase
port=3306
host=localhost
username=root
```

5.) Inside of the `applications.properties` file you also need to edit the following values to lead to a mail server of your choice
```
spring.mail.host=smtp.ethereal.email
spring.mail.port=587
spring.mail.username=hoyt.blanda12@ethereal.email
spring.mail.password=3C2fnYZBMujWVa2BVw
```
6.) You can then re-run `gradlew bootrun` and locate the website at url `http://localhost:8080`


##
