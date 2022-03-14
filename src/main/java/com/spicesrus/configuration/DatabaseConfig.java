package com.spicesrus.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.*;
import java.util.Properties;

@Configuration
public class DatabaseConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        File file = new File(new File(System.getProperties().getProperty("user.home")), "spicesrus.properties");

        try {
            boolean exists = true;
            if (!file.exists()) {
                file.createNewFile();
                exists = false;
            }

            Properties properties = new Properties();
            properties.load(new FileReader(file));
            if (!exists) {
                properties.setProperty("host", "localhost");
                properties.setProperty("port", "3306");
                properties.setProperty("username", "root");
                properties.setProperty("password", "examplePassword");
                properties.setProperty("database", "someDatabase");
                properties.store(new FileWriter(file), null);
                throw new RuntimeException("No database configuration found at " + file.toPath());
          }else{
                DriverManagerDataSource ds = new DriverManagerDataSource();
                ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
                ds.setUrl("jdbc:mysql://" + properties.getProperty("host") + "/" + properties.getProperty("database"));
                ds.setUsername(properties.getProperty("username"));
                ds.setPassword(properties.getProperty("password"));
                return ds;
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Exception occurred
    }
}
