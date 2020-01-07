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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.netfleet.api.commons.TimeUnit;
import org.netfleet.api.commons.Waypoint;

import java.io.IOException;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public class JacksonWaypointDeserializer extends StdDeserializer<Waypoint> {

  public JacksonWaypointDeserializer() {
    super(Waypoint.class);
  }

  @Override
  public Waypoint deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    Waypoint waypoint = new Waypoint();

    ObjectCodec codec = parser.getCodec();
    JsonNode node = codec.readTree(parser);
    JsonNode pnode = node.get("properties");

    JsonNode idNode = pnode.path("id");
    waypoint.setId(getOrNull(idNode.longValue(), idNode));

    JsonNode indexNode = pnode.path("index");
    waypoint.setIndex(getOrNull(indexNode.intValue(), indexNode));

    JsonNode titleNode = pnode.path("title");
    waypoint.setTitle(getOrNull(titleNode.textValue(), titleNode));

    JsonNode descriptionNode = pnode.path("description");
    waypoint.setDescription(getOrNull(descriptionNode.textValue(), descriptionNode));

    JsonNode coordinateNode = pnode.path("coordinate");
    waypoint.setCoordinate(getOrNull(coordinateNode.textValue(), coordinateNode));

    JsonNode unitNode = pnode.path("unit");
    waypoint.setTimeUnit(TimeUnit.getInstance(getOrNull(unitNode.textValue(), unitNode)));

    JsonNode durationNode = pnode.path("duration");
    waypoint.setDuration(getOrNull(durationNode.intValue(), durationNode));

    JsonNode frequencyNode = pnode.path("frequency");
    waypoint.setFrequency(getOrNull(frequencyNode.intValue(), frequencyNode));

    return waypoint;
  }

  private <T> T getOrNull(T object, JsonNode node) {
    return node.isNull() ? null : object;
  }
}
