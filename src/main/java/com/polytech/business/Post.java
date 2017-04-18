package com.polytech.business;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Laora on 13/03/2017.
 */
@Entity
@Table(name = "post")
public class Post implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "CONTENT")
    private String content;

    public Post() {
    }

    public Post(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
