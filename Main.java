package com.company;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/olya/IdeaProjects/strgraph/src/com/company/download.bmp";
        Picture picture = new Picture();
        String path_output = picture.code(path);
        String encoded_m = picture.encode(path_output);
        System.out.print("Encoded message:"+ encoded_m);
    }
}