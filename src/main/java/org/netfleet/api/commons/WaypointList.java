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
import org.netfleet.api.commons.json.JacksonWaypointListDeserializer;
import org.netfleet.api.commons.json.JacksonWaypointListSerializer;

import java.io.Serializable;
import java.util.*;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
@JsonSerialize(using = JacksonWaypointListSerializer.class)
@JsonDeserialize(using = JacksonWaypointListDeserializer.class)
public class WaypointList implements Serializable {

  private List<Waypoint> waypoints;

  public WaypointList() {
    this(null);
  }

  public WaypointList(List<Waypoint> waypoints) {
    this.waypoints = waypoints;
  }

  public static WaypointList of(Collection<Waypoint> waypoints) {
    if (waypoints == null)
      return new WaypointList();
    else
      return new WaypointList(new ArrayList<>(waypoints));
  }

  public boolean addWaypoint(Waypoint waypoint) {
    if (waypoints == null)
      waypoints = new ArrayList<>();

    return waypoints.add(waypoint);
  }

  public boolean removeWaypoint(Waypoint waypoint) {
    if (waypoints == null)
      return false;

    return waypoints.remove(waypoint);
  }

  public boolean containsWaypoint(Waypoint waypoint) {
    if (waypoints == null)
      return false;

    return waypoints.contains(waypoint);
  }

  public Iterator<Waypoint> iterator() {
    if (waypoints == null)
      return Collections.emptyIterator();

    return waypoints.iterator();
  }

  public void setWaypoints(List<Waypoint> waypoints) {
    this.waypoints = waypoints;
  }

  public List<Waypoint> getWaypoints() {
    return waypoints;
  }
}
