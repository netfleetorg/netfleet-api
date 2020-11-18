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
package org.netfleet.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RequestTemplateTest {

  @Ignore
  public void simpleTest() throws JsonProcessingException {
    Projection projection = new Projection(User.class, "defaultUserProjection");
    String path = "user";

    Map<Class<?>, String> paths = new HashMap<>();
    paths.put(User.class, path);

    Map<Class<?>, Projection> projections = new HashMap<>();
    projections.put(User.class, projection);

    RequestContext context = new RequestContext();
    context.setPaths(paths);
    context.setProjections(projections);

    String url = "/api";
    RequestTemplate template = new RequestTemplate(url, context);
    ResponseEntity<User> user = template.findById(User.class, 2L);
    if (user.hasBody()) {
      System.out.println(new ObjectMapper().writeValueAsString(user.getBody()));
    } else {
      System.out.println(user.getStatus().getCode());
    }
  }

}