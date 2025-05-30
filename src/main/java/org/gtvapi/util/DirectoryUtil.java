package org.gtvapi.util;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gtvapi.conf.AppConfigLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class DirectoryUtil {

    private static final Logger logger = LogManager.getLogger(DirectoryUtil.class);

    private final AppConfigLoader appConfigLoader;

    public Resource getChannelIconFromFile(String imageName) {
        try {
            logger.info("appConfigLoader.getChannelIcon() => {}" , appConfigLoader.getChannelIcon());
            Path imagePath = Paths.get(appConfigLoader.getChannelIcon() + imageName + ".jpg");
            logger.info("imagePath => " + appConfigLoader.getChannelIcon() + imageName + ".jpg");

            if (!Files.exists(imagePath)) {
                logger.error("file does not exist");
                return null;
            }
            logger.info("imagePath.toUri() => " + imagePath.toUri());
            Resource fileResource = new UrlResource(imagePath.toUri());
            logger.info("fileResource.getFilename() => " + fileResource.getFilename());

            return fileResource;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
