package com.company;
import java.lang.String;

public class Pixel{
    int r;
    int g;
    int b;
    String str_r;
    String str_g;
    String str_b;
    Pixel(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.str_r = this.toBinary(r);
        this.str_g = this.toBinary(g);
        this.str_b = this.toBinary(b);
    }
    public int change_pixel_with_letter(char letter) {
        String lett = this.toBinary((int) letter);
        this.str_r = this.str_r.substring(0, this.str_r.length() - 2) + lett.substring(0, 2);
        this.str_g = this.str_g.substring(0, this.str_g.length() - 2) + lett.substring(2, 4);
        this.str_b = this.str_b.substring(0, this.str_b.length() - 3) + lett.substring(4, 7);
        this.r = Integer.parseInt(this.str_r, 2);
        this.g = Integer.parseInt(this.str_g, 2);
        this.b = Integer.parseInt(this.str_b, 2);
        return 0;
    }

    public String toBinary(int lett){
        String binary_lett = Integer.toBinaryString(lett);
        while (binary_lett.length() < 7)
            binary_lett = '0' + binary_lett;
        return binary_lett;
    }

    public char encoded_char(){
        String result  = "";
        result = result + this.str_r.substring(this.str_r.length() - 2, this.str_r.length() );
        result = result + this.str_g.substring(this.str_g.length() - 2, this.str_g.length() );
        result = result + this.str_b.substring(this.str_b.length() - 3, this.str_b.length() );
        int c = Integer.parseInt(result, 2);
        return (char) c;
    }
}



