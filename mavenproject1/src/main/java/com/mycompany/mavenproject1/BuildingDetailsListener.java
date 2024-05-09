package com.mycompany.mavenproject1;

/**
 * An interface to listen for changes in the displayed image.
 */
public interface BuildingDetailsListener {
    /**
     * Called when the displayed image changes.
     * 
     * @param imagePath The path or identifier of the new image.
     */
    void onImageDisplayedChanged(String imagePath);
}
