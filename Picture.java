package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Picture {
    public String encode(String path) {
        File f;
        BufferedImage img;
        try {
            f = new File(path);
            img = ImageIO.read(f);
        } catch (IOException e) {
            return null;
        }
        String result = "";
        int counter = 0;
        int size = 0;
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                int p = img.getRGB(j, i);
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                Pixel pixel = new Pixel(r, g, b);
                if (i == 0 && j == 0) {
                    size = (int) pixel.encoded_char();
                } else if (counter < size) {
                    result = result + pixel.encoded_char();
                    counter += 1;
                } else
                    break;
            }
        }
        return result;
    }
    public String code(String path) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input string that you want to code in picture:");
        String my_str = in.nextLine();
        int size = my_str.length();
        char str_size = (char) size;
        my_str = str_size + my_str;
        BufferedImage img;
        File f;
        try {
            f = new File(path);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }

        int counter = 0;
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                int p = img.getRGB(j, i);
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                Pixel pixel = new Pixel(r, g, b);
                if (counter <= size) {
                    pixel.change_pixel_with_letter(my_str.charAt(counter));
                    int new_p = (pixel.r << 16) | (pixel.g << 8) | pixel.b;
                    img.setRGB(j, i, new_p);
                    counter += 1;
                }
            }
        }
        try {
            f = new File("/Users/olya/IdeaProjects/strgraph/src/com/company/output_picture.bmp");
            ImageIO.write(img, "bmp", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "/Users/olya/IdeaProjects/strgraph/src/com/company/output_picture.bmp";
    }
}
