package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laora on 13/03/2017.
 */

@Repository
@Transactional
public class JpaPostRepository implements PostRepository {

    @PersistenceContext
    private EntityManager entityManager ;

    public JpaPostRepository() {

    }

    public void save(Post post){
        entityManager.persist(post);
    }

    public List<Post> findAll() {
        Query query = entityManager.createQuery("select p from Post p") ;
        return query.getResultList() ;
    }

}
