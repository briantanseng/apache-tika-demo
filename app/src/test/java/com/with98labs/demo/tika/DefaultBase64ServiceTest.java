package com.with98labs.demo.tika;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultBase64ServiceTest {

    DefaultBase64Service service = new DefaultBase64Service();
    String path = "src/test/resources";

    @Test
    void readFile() {
        File file = new File(path, "sample_640×426.gif");
        assertNotNull(file, "app should read file");
        if(file.exists()) {
            System.out.println("File info:");
            System.out.println("Length: "+file.length());
            System.out.println("Last Modified: "+(new Date(file.lastModified())));
        }
        else {
            System.out.println("File does not exist");
        }
    }

    @Test
    void getBase64String() {
        File file = new File(path, "sample_640×426.gif");
        assertNotNull(file, "app should read file");
        String base64 = null;
        try {
            base64 = service.encodeToBase64(file);
            System.out.println("base64: "
                    + base64.substring(0, 32) + " ... (full string not shown)");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(base64, "base64 string should not be null");
    }

}
