package com.polytech.business;


import com.polytech.repository.PostRepository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Laora on 13/03/2017.
 */
public class PublicationServiceImpl implements PublicationService {
    private PostRepository postRepository;

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
