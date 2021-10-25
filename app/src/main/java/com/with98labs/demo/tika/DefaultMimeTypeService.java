package com.with98labs.demo.tika;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

import java.io.*;

public class DefaultMimeTypeService implements MimeTypeService {

    Base64Service base64Service = new DefaultBase64Service();

    @Override
    public String detectMimeType(String base64) throws IOException {
        TikaConfig tika = null;
        try {
            tika = new TikaConfig();
        } catch (TikaException e) {
            throw new IOException(e);
        }
        Metadata metadata = new Metadata();
        MediaType mediaType =
                tika.getDetector().detect(getInputStream(base64), metadata);
        return mediaType.toString();
    }

    public String detectMimeType(File file) throws IOException {
        TikaConfig tika = null;
        try {
            tika = new TikaConfig();
        } catch (TikaException e) {
            throw new IOException(e);
        }
        Metadata metadata = new Metadata();
        MediaType mediaType =
                tika.getDetector().detect(getInputStream(file), metadata);
        return mediaType.toString();
    }

    private InputStream getInputStream(String base64) {
        return base64Service.toInputStream(base64);
    }

    private InputStream getInputStream(File file) throws FileNotFoundException {
        return new BufferedInputStream(new FileInputStream(file));
    }

}
