package com.polytech.business;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Laora on 13/03/2017.
 */
public interface PublicationService {
    List<Post> fetchAll();

    void post(Post post) ;
}
