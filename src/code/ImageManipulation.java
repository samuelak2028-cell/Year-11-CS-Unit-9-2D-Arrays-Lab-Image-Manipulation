package code;

import image.APImage;
import image.Pixel;

public class ImageManipulation {

    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */
    public static void main(String[] args) {
        APImage myImage = new APImage("cyberpunk2077.jpg");
        myImage.draw();
        grayScale("cyberpunk2077.jpg");
        blackAndWhite("cyberpunk2077.jpg");
        edgeDetection("cyberpunk2077.jpg", 20);
    }

    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        APImage myImage = new APImage(pathOfFile);
        for (int i = 0; i<myImage.getWidth(); i++){
            for (int j = 0; j<myImage.getHeight(); j++){
                Pixel myPixel = myImage.getPixel(i,j);
                int avg = getAverageColour(myPixel);
                myPixel.setRed(avg);
                myPixel.setBlue(avg);
                myPixel.setGreen(avg);
            }
        }
        myImage.draw();
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        int avg = (pixel.getRed()+pixel.getBlue()+pixel.getGreen())/3;
        return avg;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        APImage myImage = new APImage(pathOfFile);
        for (int i = 0; i<myImage.getWidth(); i++){
            for (int j = 0; j<myImage.getHeight(); j++){
                Pixel myPixel = myImage.getPixel(i,j);
                int avg = getAverageColour(myPixel);
                if (avg<128) {
                    myPixel.setRed(0);
                    myPixel.setBlue(0);
                    myPixel.setGreen(0);
                } else {
                    myPixel.setRed(255);
                    myPixel.setBlue(255);
                    myPixel.setGreen(255);
                }
            }
        }
        myImage.draw();
    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage myImage = new APImage(pathToFile);
        for (int i = 0; i<myImage.getWidth(); i++){
            if (i == 0) {
                for (int j = 1; j<myImage.getHeight(); j++){
                    Pixel pixel1 = myImage.getPixel(i,j);
                    Pixel pixel3 = myImage.getPixel(i,j-1);
                    int avg1 = getAverageColour(pixel1);
                    int avg3 = getAverageColour(pixel3);
                    if (avg1-avg3>threshold || avg3-avg1>threshold){
                        pixel1.setRed(0);
                        pixel1.setBlue(0);
                        pixel1.setGreen(0);
                    } else {
                        pixel1.setRed(255);
                        pixel1.setBlue(255);
                        pixel1.setGreen(255);
                    }
                }
            } else {
                for (int j = 1; j<myImage.getHeight(); j++){
                    Pixel pixel1 = myImage.getPixel(i,j);
                    Pixel pixel2 = myImage.getPixel(i-1,j);
                    Pixel pixel3 = myImage.getPixel(i,j-1);
                    int avg1 = getAverageColour(pixel1);
                    int avg2 = getAverageColour(pixel2);
                    int avg3 = getAverageColour(pixel3);
                    if (avg1-avg2>threshold || avg2-avg1>threshold || avg1-avg3>threshold || avg3-avg1>threshold){
                        pixel1.setRed(0);
                        pixel1.setBlue(0);
                        pixel1.setGreen(0);
                    } else {
                        pixel1.setRed(255);
                        pixel1.setBlue(255);
                        pixel1.setGreen(255);
                    }
                }
            }
        }
        myImage.draw();
    }

    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {

    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {

    }

}
