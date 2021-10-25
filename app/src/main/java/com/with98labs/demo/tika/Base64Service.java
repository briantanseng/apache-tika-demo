package com.with98labs.demo.tika;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface Base64Service {

    public String encodeToBase64(File file) throws IOException;

    public InputStream toInputStream(String base64);

}
