package com.driver.models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Image {

    public int id;

    public String description;

    public String dimension;

    @ManyToOne
    @JoinColumn
    Blog blog ;

    public Image(Blog blog, String description, String dimensions) {
    }

    public Image(int id, String description, String dimension, Blog blog) {
        this.id = id;
        this.description = description;
        this.dimension = dimension;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}