# Spices R Us Website
    
## Group Members

Callie Lewis (cl480), Commits Under: 'C Lewis'

Connor Johncock (cj202), Commits Under: 'C N Johncock' and 'Connor'

Jan K. Kaliszuk (jkk21), Commits Under: 'jano' and 'Jan Kaliszuk'

Haleem Hussain (hh277), Commits Under: 'Haleem', 'halee' and 'H Hussain' 

Jianan Lin (jl784), Commits Under: 'Amy Lin' and 'J Lin'

Abdiwahab Salah (as1270), Commits Under: 'A Salah' and 'Abdiwahab Salah'

## Installation Instructions

1.) Navigate to https://dev.mysql.com/doc/mysql-getting-started/en/ and follow the instructions to install a MySQL server.

2.) Using the same guide create a database and user account for this system to access.

3.) Clone this repository and execute `./gradlew bootRun` inside of the directory

4.) The application will then stop after generating a `spicesrus.properties` file inside your home directory

5.) Enter the details of the MySQL server into the required fields

```
spicesrus.properties

password=examplePassword
database=someDatabase
port=3306
host=localhost
username=root
```

5.) Inside of the `applications.properties` file, you also need to edit the following values to lead to a mail server of your choice
```
spring.mail.host=smtp.ethereal.email
spring.mail.port=587
spring.mail.username=hoyt.blanda12@ethereal.email
spring.mail.password=3C2fnYZBMujWVa2BVw
```
6.) Re-run `./gradlew bootRun` and locate the website using the url `http://localhost:8080`
