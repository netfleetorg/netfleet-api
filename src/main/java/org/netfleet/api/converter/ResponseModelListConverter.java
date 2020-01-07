/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (C) 2019 Terra Yazılım Ltd Şti - All Rights Reserved
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License 3 only, as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details (a copy is included in the
 * LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 * Please contact Terra Yazılım, Konya Teknoloji Geliştirme Bölgesi
 * Büyük Kayacık Mah. 101. Cad. No:2 42250 - Selçuklu Konya or visit
 * www.terrayazilim.com.tr if you need additional information or have
 * any questions.
 */
package org.netfleet.api.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.netfleet.api.ApiException;
import org.netfleet.api.RequestTemplate;
import org.netfleet.api.ResponseConverter;
import org.netfleet.api.ResponseEntity;
import org.netfleet.api.commons.json.JsonUtils;
import org.netfleet.api.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public class ResponseModelListConverter<T extends Model> implements ResponseConverter<T, List<T>> {
  private static final Logger log = LoggerFactory.getLogger(ResponseModelListConverter.class);

  @Override
  public ResponseEntity<List<T>> convert(Class<T> classType, ResponseEntity<String> entity) {
    List<T> stack = null;
    if (entity.hasBody()) {
      String body = entity.getBody();

      if (JsonUtils.isJson(body)) {
        stack = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;

        try {
          jsonNode = mapper.readTree(body);
        } catch (IOException e) {
          log.error("", e);
        }

        if (jsonNode == null)
          throw new ApiException();

        JsonNode embedded = jsonNode.get("_embedded");
        String path = RequestTemplate.PATHS.get(classType);

        JsonNode elements = embedded.get(path);
        for (JsonNode element : elements) {
          try {
            T next = mapper.treeToValue(element, classType);
            stack.add(next);
          } catch (JsonProcessingException e) {
            log.error("", e);
          }
        }
      }
    }

    return ResponseEntity.of(entity.getHeaders(), entity.getStatus(), stack);
  }
}
