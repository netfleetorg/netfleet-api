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
package org.netfleet.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.netfleet.api.commons.WaypointList;
import org.netfleet.api.model.Model;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
  fieldVisibility = JsonAutoDetect.Visibility.ANY,
  getterVisibility = JsonAutoDetect.Visibility.NONE,
  setterVisibility = JsonAutoDetect.Visibility.NONE
)
public class Route implements Model {

  private Long id;
  private Long groupId;
  private String code;
  private String groupTitle;
  private String title;
  private String description;
  private Long startPlaceId;
  private String startPlaceTitle;
  private Long endPlaceId;
  private String endPlaceTitle;
  private WaypointList waypoints;

  public Route() {
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupTitle(String groupTitle) {
    this.groupTitle = groupTitle;
  }

  public String getGroupTitle() {
    return groupTitle;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStartPlaceId(Long startPlaceId) {
    this.startPlaceId = startPlaceId;
  }

  public Long getStartPlaceId() {
    return startPlaceId;
  }

  public void setStartPlaceTitle(String startPlaceTitle) {
    this.startPlaceTitle = startPlaceTitle;
  }

  public String getStartPlaceTitle() {
    return startPlaceTitle;
  }

  public void setEndPlaceId(Long endPlaceId) {
    this.endPlaceId = endPlaceId;
  }

  public Long getEndPlaceId() {
    return endPlaceId;
  }

  public void setEndPlaceTitle(String endPlaceTitle) {
    this.endPlaceTitle = endPlaceTitle;
  }

  public String getEndPlaceTitle() {
    return endPlaceTitle;
  }

  public WaypointList getWaypoints() {
    return waypoints;
  }

  public void setWaypoints(WaypointList waypoints) {
    this.waypoints = waypoints;
  }
}
