# GitLab repository for CO2201 Group Projects

## Installation Instructions

1. Press the clone button on this page and copy the project url 
2. Open the command-line interface on an empty folder
3. Type `git clone ` followed by the url copied earlier
4. Enter the produced repository by typing `cd group-02`
5. Type `./gradlew bootrun`
6. The application will start running, before crashing
7. Inside your home directory there will now be a file named **spicesrus.properties** 
8. Inside this file, you must edit the database configuration to point to a MySQL server
```
spicesrus.properties

password=examplePassword
database=someDatabase
port=3306
host=localhost
username=root

```
9. Rerun the application by typing `./gradlew bootrun`
10. Open your browser and enter `localhost:8080` as the url