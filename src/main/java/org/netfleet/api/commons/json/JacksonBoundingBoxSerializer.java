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
package org.netfleet.api.commons.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.geobyteframework.geojson.GeojsonCoordinate;
import org.geobyteframework.geojson.GeojsonFeature;
import org.geobyteframework.geojson.GeojsonMultiPoint;
import org.netfleet.api.ApiException;
import org.netfleet.api.commons.BoundingBox;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public class JacksonBoundingBoxSerializer extends StdSerializer<BoundingBox> {
  public JacksonBoundingBoxSerializer() {
    super(BoundingBox.class);
  }

  @Override
  public void serialize(BoundingBox bbox, JsonGenerator gen, SerializerProvider provider) throws IOException {
    GeojsonFeature feature = new GeojsonFeature();
    feature.setProperties(new HashMap<String, Object>());

    Field[] fields = BoundingBox.class.getDeclaredFields();
    for (Field field : fields) {
      String name = field.getName();
      Object value;
      try {
        field.setAccessible(true);
        value = field.get(bbox);
      } catch (IllegalAccessException e) {
        throw new ApiException();
      }

      feature.setProperty(name, value);
    }

    if (bbox.getId() != null) {
      feature.setId(bbox.getId().toString());
    }

    feature.setBbox(new double[]{bbox.getSouthWestLatitude(), bbox.getSouthWestLongitude(),
      bbox.getNorthEastLatitude(), bbox.getNorthEastLongitude()});

    GeojsonCoordinate sw = new GeojsonCoordinate();
    sw.setLatitude(bbox.getSouthWestLatitude());
    sw.setLongitude(bbox.getSouthWestLongitude());

    GeojsonCoordinate ne = new GeojsonCoordinate();
    ne.setLatitude(bbox.getNorthEastLatitude());
    ne.setLongitude(bbox.getNorthEastLongitude());

    GeojsonMultiPoint multiPoint = new GeojsonMultiPoint();
    multiPoint.addCoordinate(sw);
    multiPoint.addCoordinate(ne);

    feature.setGeometry(multiPoint);
    gen.writeObject(feature);
  }
}
