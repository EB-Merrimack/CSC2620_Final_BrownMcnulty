package com.mycompany.mavenproject1;

import javafx.scene.image.Image;

public class ImageWithCaptions {
    private String imageUrl;
        private String caption;

        public ImageWithCaptions(String imageUrl, String caption) {
            this.imageUrl = imageUrl;
            this.caption = caption;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String getCaption() {
            return caption;
        }
}
