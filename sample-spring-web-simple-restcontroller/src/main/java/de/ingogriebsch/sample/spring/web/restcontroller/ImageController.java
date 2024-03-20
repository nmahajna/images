/*-
 * Copyright 2018-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.ingogriebsch.sample.spring.web.restcontroller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import java.util.Set;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RequestMapping(ImageController.BASE_PATH)
@RequiredArgsConstructor
@RestController
class ImageController {

    static final String ADD_PATH = "/addImage";
    static final String DELETE_PATH = "/deleteImage/{id}";
    static final String GET_ALL = "/images";

    @NonNull
    private final ImageService imageService;

    @GetMapping(GET_ALL)
    Set<Image> findAll() {
        return imageService.findAll();
    }

    @PostMapping(ADD_PATH)
    ResponseEntity<String> insert(@RequestBody Image image) {
        try {
            image.validate();
        } catch (IllegalArgumentException e) {
            return badRequest().body(e.getMessage());
        }
        try {
            image.validate();
        } catch (IllegalArgumentException e) {
            return badRequest().body(e.getMessage());
        }
        return imageService.insert(image) ? status(CREATED).build() : badRequest().build();
    }

    @DeleteMapping(DELETE_PATH)
    ResponseEntity<Void> delete(@PathVariable String id) {
        return imageService.delete(id) ? ok().build() : notFound().build();
    }
}
