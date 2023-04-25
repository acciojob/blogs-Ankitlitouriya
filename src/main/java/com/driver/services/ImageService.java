package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();

        Image image = new Image(blog,description,dimensions);

        blogRepository2.save(blog);

        blog.getImageList().add(image);

        return image;

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
       String [] scrarray = screenDimensions.split("X");

       Image image = imageRepository2.findById(id).get();

       String imageDimension = image.getDimensions();

       String [] imgarray = imageDimension.split("X");

       int scl = Integer.parseInt(scrarray[0]);
       int scb = Integer.parseInt(scrarray[1]);

       int imgl = Integer.parseInt(imgarray[0]);
       int imgb = Integer.parseInt(imgarray[1]);

       return no_image(scl,scb,imgl,imgb);

    }

    private int no_image(int scl,int scb, int imgl,int imgb){
        int lenC = scl/imgl;
        int lenB = scb/imgb;

        return lenC*lenB;
    }
}
