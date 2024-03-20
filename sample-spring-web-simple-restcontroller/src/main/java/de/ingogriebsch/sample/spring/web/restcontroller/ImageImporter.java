package de.ingogriebsch.sample.spring.web.restcontroller;

import static java.lang.String.format;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
class ImageImporter implements CommandLineRunner {

    @NonNull
    private final ImageService imageService;

    @Override
    public void run(String... args) throws Exception {
        Set<Image> images = newHashSet(
            image("https://assets.toptal.io/images?url=https%3A%2F%2Fbs-uploads.toptal.io%2Fblackfish-uploads%2Fcomponents%2Fblog_post_page%2Fcontent%2Fcover_image_file%2Fcover_image%2F1275957%2Fretina_500x200_cover-top-18-most-common-angularjs-developer-mistakes-41f9ad303a51db70e4a5204e101e7414.png", "angular", 1000),
         image("https://www.jrebel.com/sites/default/files/image/2022-03/blog-image-jrebel-spring-boot-3.jpg", "springboot", 3000),
            image("https://www.ade-technologies.com/blog/wp-content/uploads/2021/12/image-blog-revel-top-java-tools.jpg", "java", 2000));
        images.forEach(p -> insert(p));
        log.info(format("%d images successfully imported and ready to be accessed!", images.size()));
    }

    private void insert(Image imageInsert) {
        if (imageService.insert(imageInsert)) {
            log.info("Import image '{}'...", imageInsert);
        }
    }

    private Image image(String url, String display_name, Integer duration) {
        return new Image(url, display_name, duration);
    }
}
