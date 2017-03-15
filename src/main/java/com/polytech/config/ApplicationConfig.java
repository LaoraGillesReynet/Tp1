package com.polytech.config;

/**
 * Created by Laora on 13/03/2017.
 */


import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:/application.properties")
@ComponentScan(basePackages = {"com.polytech.business", "com.polytech.repository"})

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
    public javax.sql.DataSource devDataSource(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder() ;
        return embeddedDatabaseBuilder
                   .setType(EmbeddedDatabaseType.H2)
                    .addScript("create-schema.sql")
                    .build() ;
    }

/*
    @Bean
    public PostRepository postRepository(){
        return new JdbcPostRepository(dataSource()) ;
    }

    @Bean
    public PublicationService publicationService(PostRepository postRepository){
        return new PublicationServiceImpl(postRepository) ;
    }
*/

}
