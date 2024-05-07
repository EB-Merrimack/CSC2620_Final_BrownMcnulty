package com.mycompany.mavenproject1;

import javafx.scene.image.Image;

/**
 * Represents an image with an associated caption.
 */
public class ImageWithCaptions {
    private Image image; // The image
    private String caption; // The cpation associated with the image
    private String imageUrl; // The URL of the image

    /**
     * Constructs an ImageWithCaptions object with the specified image URL and caption.
     * 
     * @param imageUrl The URL of the image.
     * @param caption The caption associated with the image.
     */
    public ImageWithCaptions(String imageUrl, String caption) {
        this.image = new Image(imageUrl);
        this.caption = caption;
        this.imageUrl = imageUrl;
    }

    /**
     * Gets the image.
     * 
     * @return The image.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Gets the caption associated with the image.
     * 
     * @return The caption.
     */
    public String getCaption() {
        return caption;
    }

     /**
     * Gets the URL of the image.
     * 
     * @return The URL of the image.
     */
    public String getUrl() {
        return imageUrl;
    }
}
