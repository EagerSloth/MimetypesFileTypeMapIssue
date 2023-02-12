package com.example.mimetypesfiletypemapissue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MimetypesFileTypeMapIssueApplicationTests {

    @Test
    void contextLoads() {
        String mimeType = MimeTypeResolver.getMimeType("jpg");
        assertEquals(mimeType, "image/jpeg");
    }

}
