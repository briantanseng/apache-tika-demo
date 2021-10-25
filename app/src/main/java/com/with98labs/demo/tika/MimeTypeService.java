package com.with98labs.demo.tika;

import java.io.File;
import java.io.IOException;

public interface MimeTypeService {

    public String detectMimeType(String base64) throws IOException;

    public String detectMimeType(File file) throws IOException;

}
