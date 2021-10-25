package com.with98labs.demo.tika;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class DefaultBase64Service implements Base64Service {
    @Override
    public String encodeToBase64(File file) throws IOException {
        return Base64.getEncoder().encodeToString(
                Files.readAllBytes(file.toPath()));
    }

    public InputStream toInputStream(String base64) {
        InputStream is = null;
        try {
            // Step 1: convert first to a temporary file
            // See https://dzone.com/articles/working-with-temporary-filesfolders-in-java
            Path tempFilePath = Files.createTempFile(null, null);
            File tempFile = tempFilePath.toFile();
            byte[] data = Base64.getDecoder().decode(base64.getBytes());
            try (OutputStream stream = new FileOutputStream(tempFile)) {
                stream.write(data);
            }
            // Step 2: convert temporary file to input stream
            is = new BufferedInputStream(new FileInputStream(tempFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }
}
