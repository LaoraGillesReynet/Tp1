package com.polytech.repository;

import com.polytech.business.Post;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Laora on 13/03/2017.
 */
public interface PostRepository {
    List<Post> findAll();

    void save(Post post);
}
