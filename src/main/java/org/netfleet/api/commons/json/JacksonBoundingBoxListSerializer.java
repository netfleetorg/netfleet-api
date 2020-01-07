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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.geobyteframework.geojson.GeojsonFeature;
import org.geobyteframework.geojson.GeojsonFeatureCollection;
import org.netfleet.api.commons.BoundingBox;
import org.netfleet.api.commons.BoundingBoxList;

import java.io.IOException;
import java.util.ArrayList;

public class JacksonBoundingBoxListSerializer extends StdSerializer<BoundingBoxList> {

  public JacksonBoundingBoxListSerializer() {
    super(BoundingBoxList.class);
  }

  @Override
  public void serialize(BoundingBoxList bboxList, JsonGenerator gen, SerializerProvider provider) throws IOException {
    GeojsonFeatureCollection gfc = new GeojsonFeatureCollection();
    gfc.setFeatures(new ArrayList<GeojsonFeature>());

    ObjectMapper mapper = new ObjectMapper();
    if (bboxList.getBoundingBoxes() != null) {
      for (BoundingBox bbox: bboxList.getBoundingBoxes()) {
        String featureJson = mapper.writeValueAsString(bbox);
        GeojsonFeature feature = mapper.readValue(featureJson, GeojsonFeature.class);
        gfc.addFeature(feature);
      }
    }

    gen.writeObject(gfc);
  }
}
