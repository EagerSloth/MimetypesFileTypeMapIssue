package com.example.mimetypesfiletypemapissue;

import jakarta.activation.MimetypesFileTypeMap;
import org.springframework.core.io.ClassPathResource;

public final class MimeTypeResolver {
    private MimeTypeResolver() {
    }

    private static final MimetypesFileTypeMap mimetypesFileTypeMap = mime();

    private static MimetypesFileTypeMap mime() {
        try {
            return new MimetypesFileTypeMap(new ClassPathResource("mime-types/mime-types").getInputStream());
        } catch (Exception e) {
            throw new MissingMimeTypesException(e);
        }
    }

    public static String getMimeType(String extension) {
        return mimetypesFileTypeMap.getContentType('.' + extension);
    }

    static class MissingMimeTypesException extends RuntimeException {

        public MissingMimeTypesException(Throwable cause) {
            super(cause);
        }
    }
}
