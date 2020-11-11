package com.davidhorstman.eeme.utils;

public class Encoder {
    public static long decode(String encoded, char[] glyphs) {
        // Replace each glyph in the encoded string with the number it represents
        for (int i = 0; i < glyphs.length; i++) {
            encoded = encoded.replace(glyphs[i], Character.forDigit(i, 10));
        }
        // Parse the decoded number stored in the string
        // radix will always be the number of glyphs
        return Long.parseLong(encoded, glyphs.length);
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
