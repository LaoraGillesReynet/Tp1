package com.polytech.repository;

import com.polytech.business.Post;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laora on 13/03/2017.
 */
public class JdbcPostRepository implements PostRepository {
    private DataSource dataSource ;

    public List<Post> findAll() {
        return null ;
    }

    public void save(Post post){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST VALUES(?)") ;
            preparedStatement.setString(1, post.getContent());
            preparedStatement.execute() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
