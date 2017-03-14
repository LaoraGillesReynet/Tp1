package com.polytech.business;


import com.polytech.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Laora on 13/03/2017.
 */

@Component
public class PublicationServiceImpl implements PublicationService {
    private PostRepository postRepository;

    @Autowired
    public PublicationServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void post(Post post) {
        try {
            postRepository.save(post) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Post> fetchAll(){
        return postRepository.findAll() ;
    }
}
