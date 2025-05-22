package org.gtvapi.service;

import lombok.RequiredArgsConstructor;
import org.gtvapi.util.DirectoryUtil;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    public Resource getVideosByCategoryId(String imageName) {
        return DirectoryUtil.getChannelIconFromFile(imageName);
    }
}
