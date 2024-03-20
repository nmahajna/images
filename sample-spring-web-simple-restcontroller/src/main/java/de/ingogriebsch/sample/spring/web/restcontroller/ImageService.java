package de.ingogriebsch.sample.spring.web.restcontroller;

import java.util.HashSet;
import java.util.Set;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
class ImageService {

    private final Set<Image> images = new HashSet<>();

    Set<Image> findAll() {
        return images;
    }

    boolean insert(@NonNull Image image) {
        for (Image i : images) {
            if (i.getDisplay_name().equals(image.getDisplay_name())) {
                return false;
            }
        }
        return images.add(image);
    }

    boolean delete(@NonNull String id) {
        return images.removeIf(i -> i.getDisplay_name().equals(id));
    }
}
