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

import lombok.Data;

@Data
class Image {

    private final String url;
    private final String display_name;
    private final Integer duration;
    public void validate() {
        // validate the image duration is more that 1000 and shorter that 15000
        if (duration < 1000 || duration > 15000) {
            throw new IllegalArgumentException("The duration of the image must be between 1000 and 15000");
        }
        //validate the image url is not empty and is a valid url syntax
        if (url.isEmpty() || !url.matches("^(http|https)://.*$")) {
            throw new IllegalArgumentException("The url of the image must be a valid url");
        }

        //validate the image display name is not empty
        if (display_name.isEmpty()) {
            throw new IllegalArgumentException("The display name of the image must not be empty");
        }
    }
}
