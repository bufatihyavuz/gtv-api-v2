package org.gtvapi.service;

import lombok.RequiredArgsConstructor;
import org.gtvapi.util.DirectoryUtil;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final DirectoryUtil directoryUtil;

    public Resource getVideosByCategoryId(String imageName) {
        return directoryUtil.getChannelIconFromFile(imageName);
    }
}
