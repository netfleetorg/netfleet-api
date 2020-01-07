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
package org.netfleet.api.commons;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.netfleet.api.commons.json.JacksonLocationListDeserializer;
import org.netfleet.api.commons.json.JacksonLocationListSerializer;

import java.io.Serializable;
import java.util.*;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
@JsonSerialize(using = JacksonLocationListSerializer.class)
@JsonDeserialize(using = JacksonLocationListDeserializer.class)
public class LocationList implements Serializable {

  private List<Location> locations;

  public LocationList() {
    this(null);
  }

  public LocationList(List<Location> locations) {
    this.locations = locations;
  }

  public static LocationList of(Collection<Location> locations) {
    if (locations == null)
      return new LocationList();
    else
      return new LocationList(new ArrayList<>(locations));
  }

  public boolean addLocation(Location location) {
    if (locations == null)
      locations = new ArrayList<>();

    return locations.add(location);
  }

  public boolean removeLocation(Location location) {
    if (locations == null)
      return false;

    return locations.remove(location);
  }

  public boolean containsLocation(Location location) {
    if (locations == null)
      return false;

    return locations.contains(location);
  }

  public Iterator<Location> iterator() {
    if (locations == null)
      return Collections.emptyIterator();

    return locations.iterator();
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }

  public List<Location> getLocations() {
    return locations;
  }
}
