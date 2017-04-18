package com.polytech.config;

/**
 * Created by Laora on 13/03/2017.
 */

import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories("com.polytech.repository")
@PropertySource("classpath:/application.properties")
@ComponentScan(basePackages = {"com.polytech.business", "com.polytech.repository"})
@EntityScan("com.polytech.business")
public class ApplicationConfig {

    /*@Value("${datasource.driverName}")
    private String driverClassName ;

    @Value("${datasource.url}")
    private String url ;

    @Value("${datasource.username}")
    private String username ;

    @Value("${datasource.password}")
    private String password ;
*/
    @Autowired
    private Environment environment ;

    @Bean(name = "dataSource")
    @Profile("PROD")
    public DataSource prodDataSource(){
        BasicDataSource dataSource = new BasicDataSource() ;
        dataSource.setUsername(environment.getProperty("datasource.username")) ;
        dataSource.setPassword(environment.getProperty("datasource.password"));
        dataSource.setUrl(environment.getProperty("datasource.url"));
        dataSource.setDriverClassName(environment.getProperty("datasource.driverName"));
        return dataSource;
    }

    @Bean(name = "dataSource")
    @Profile("DEV")
    public DataSource devDataSource() {
         return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("create-schema.sql")
            .build();
    }
}
