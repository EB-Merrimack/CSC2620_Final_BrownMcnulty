package com.mycompany.mavenproject1;

import javafx.scene.image.Image;

public class ImageWithCaptions {
    private Image image;
        private String caption;
        private String imageUrl;

        public ImageWithCaptions(String imageUrl, String caption) {
            this.image = new Image(imageUrl);
            this.caption = caption;
            this.imageUrl = imageUrl;
        }

        public Image getImage() {
            return image;
        }

        public String getCaption() {
            return caption;
        }

        public String getUrl() {
            return imageUrl;
        }
}
