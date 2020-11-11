package com.davidhorstman.eeme.views;

import com.davidhorstman.eeme.models.Link;
import com.davidhorstman.eeme.utils.Encoder;

public class EncodedLink extends Link {
    private String encodedPath;

    private static char[] glyphs = {'e', 'm'/*, 'E', 'M'*/};

    public static long decode(String encoded) {
        return Encoder.decode(encoded, glyphs);
    }

    public static String encode(long id) {
        return Encoder.encode(id, glyphs);
    }

    public EncodedLink() {
    }

    public String getEncodedPath() {
        return encodedPath;
    }

    public void setEncodedPath(String encodedPath) {
        this.encodedPath = encodedPath;
    }

}
