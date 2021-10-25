package com.with98labs.demo.tika;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultMimeTypeServiceTest {

    DefaultMimeTypeService mimeTypeService = new DefaultMimeTypeService();
    DefaultBase64Service base64Service = new DefaultBase64Service();
    String path = "src/test/resources";

    @Test
    void detectMimeTypeOfBase64String() {
        File input = new File(path, "base64.txt");

        String mimeType = null;
        try {
            String base64 = new String(
                    Files.readAllBytes(Paths.get(input.getAbsolutePath())));

            mimeType = mimeTypeService.detectMimeType(base64);
            System.out.println("base64-encoded string has mimeType of " + mimeType);

            assertEquals("image/gif", mimeType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void detectMimeTypeOfGifFile() {
        File file = new File(path, "sample_640×426.gif");
        String mimeType = null;
        try {
            mimeType = mimeTypeService.detectMimeType(file);
            System.out.println(
                    file.getName() + " has mimeType of " + mimeType);

            assertEquals("image/gif", mimeType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void detectMimeTypeOfJpegFile() {
        File file = new File(path, "sample_640×426.jpeg");
        String mimeType = null;
        try {
            mimeType = mimeTypeService.detectMimeType(file);
            System.out.println(
                    file.getName() + " has mimeType of " + mimeType);

            assertEquals("image/jpeg", mimeType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void detectMimeTypeOfPngFile() {
        File file = new File(path, "sample_640×426.png");
        String mimeType = null;
        try {
            mimeType = mimeTypeService.detectMimeType(file);
            System.out.println(
                    file.getName() + " has mimeType of " + mimeType);

            assertEquals("image/png", mimeType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void detectMimeTypeOfTiffFile() {
        File file = new File(path, "sample_640×426.tiff");
        String mimeType = null;
        try {
            mimeType = mimeTypeService.detectMimeType(file);
            System.out.println(
                    file.getName() + " has mimeType of " + mimeType);

            assertEquals("image/tiff", mimeType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
