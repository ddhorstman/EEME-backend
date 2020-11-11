package com.davidhorstman.eeme.utils;

import com.davidhorstman.eeme.exceptions.ResourceNotFoundException;

public class Encoder {
    public static long decode(String encoded, char[] glyphs) {
        // Replace each glyph in the encoded string with the number it represents
        for (int i = 0; i < glyphs.length; i++) {
            encoded = encoded.replace(glyphs[i], Character.forDigit(i, 10));
        }
        // Parse the decoded number stored in the string
        // radix will always be the number of glyphs
        try {
            return Long.parseLong(encoded, glyphs.length);
        }
        catch (Exception e){
            // If any invalid characters were present in the string, return a 404
            if(e instanceof NumberFormatException){
                throw new ResourceNotFoundException("Could not decode link with path '"+encoded+"'.");
            }
            else throw e;
        }
    }

    public static String encode(long id, char[] glyphs) {
        // Encode the number in a string with radix defined by the number of glyphs
        String encoded = Long.toString(id, glyphs.length);

        // Replace each digit with the glyph that will represent it
        for (int i = 0; i < glyphs.length; i++) {
            encoded = encoded.replace(Character.forDigit(i, 10), glyphs[i]);
        }
        return encoded;
    }
}
