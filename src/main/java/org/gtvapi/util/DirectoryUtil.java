package org.gtvapi.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryUtil {
    
    public static Resource getChannelIconFromFile(String imageName) {
        try {
            String IMAGE_DIR = System.getProperty("channelIconName.dir");

            Path imagePath = Paths.get(IMAGE_DIR + imageName + ".jpg");
            if (!Files.exists(imagePath)) {
                return null;
            }

            Resource fileResource = new UrlResource(imagePath.toUri());

            return fileResource;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
