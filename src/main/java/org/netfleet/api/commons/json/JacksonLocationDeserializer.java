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
import org.netfleet.api.commons.CrsId;
import org.netfleet.api.commons.Location;

import java.io.IOException;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public class JacksonLocationDeserializer extends StdDeserializer<Location> {
  protected JacksonLocationDeserializer() {
    super(Location.class);
  }

  @Override
  public Location deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    Location location = new Location();

    ObjectCodec codec = parser.getCodec();
    JsonNode node = codec.readTree(parser);
    JsonNode pnode = node.get("properties");

    JsonNode idNode = pnode.path("id");
    location.setId(getOrNull(idNode.longValue(), idNode));

    JsonNode indexNode = pnode.path("index");
    location.setIndex(getOrNull(indexNode.longValue(), indexNode));

    JsonNode vehicleTrackingIdNode = pnode.path("vehicleTrackingId");
    location.setVehicleTrackingId(getOrNull(vehicleTrackingIdNode.longValue(), vehicleTrackingIdNode));

    JsonNode vehiclePlateNode = pnode.path("vehiclePlate");
    location.setVehiclePlate(getOrNull(vehiclePlateNode.textValue(), vehiclePlateNode));

    JsonNode vehicleIdNode = pnode.path("vehicleId");
    location.setVehicleId(getOrNull(vehicleIdNode.longValue(), vehicleIdNode));

    JsonNode driverIdNode = pnode.path("driverId");
    location.setDriverId(getOrNull(driverIdNode.longValue(), driverIdNode));

    JsonNode driverNameNode = pnode.path("driverName");
    location.setDriverName(getOrNull(driverNameNode.textValue(), driverNameNode));

    JsonNode coordinateNode = pnode.path("coordinate");
    location.setCoordinate(getOrNull(coordinateNode.textValue(), coordinateNode));

    JsonNode crsId = pnode.path("crsId");
    if (!crsId.isNull()) {
      String textCrsId = crsId.textValue();
      CrsId crs = CrsId.findCrsId(textCrsId);

      location.setCrsId(crs);
    }

    JsonNode distanceNode = pnode.path("distance");
    location.setDistance(getOrNull(distanceNode.doubleValue(), distanceNode));

    JsonNode durationNode = pnode.path("duration");
    location.setDuration(getOrNull(durationNode.doubleValue(), durationNode));

    JsonNode velocityNode = pnode.path("velocity");
    location.setVelocity(getOrNull(velocityNode.doubleValue(), velocityNode));

    JsonNode velocityViolationNode = pnode.path("velocityViolation");
    location.setVelocityViolation(getOrNull(velocityViolationNode.booleanValue(), velocityViolationNode));

    JsonNode timeNode = pnode.path("time");
    location.setTime(getOrNull(timeNode.longValue(), timeNode));

    // ~~~ device properties ~~~ //
    JsonNode localDateTimeNode = pnode.path("localDateTime");
    location.setLocalDateTime(getOrNull(localDateTimeNode.textValue(), localDateTimeNode));

    JsonNode deviceIdNode = pnode.path("deviceId");
    location.setDeviceId(getOrNull(deviceIdNode.textValue(), deviceIdNode));

    JsonNode localeNode = pnode.path("locale");
    location.setLocale(getOrNull(localeNode.textValue(), localeNode));

    JsonNode speedNode = pnode.path("speed");
    location.setSpeed(getOrNull(speedNode.floatValue(), speedNode));

    JsonNode courseNode = pnode.path("course");
    location.setSpeed(getOrNull(courseNode.floatValue(), courseNode));

    return location;
  }

  private <T> T getOrNull(T object, JsonNode node) {
    return node.isNull() ? null : object;
  }
}
