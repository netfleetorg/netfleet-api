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

import java.util.Calendar;

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
public class MonitoringPermission implements Model {

  private Long id;
  private Calendar beginDate;
  private Calendar endDate;
  private Long userId;
  private String username;
  private String type;
  private String token;
  private Long vehicleId;
  private String vehiclePlate;

  public MonitoringPermission() {
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public Calendar getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(Calendar beginDate) {
    this.beginDate = beginDate;
  }

  public Calendar getEndDate() {
    return endDate;
  }

  public void setEndDate(Calendar endDate) {
    this.endDate = endDate;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public String getVehiclePlate() {
    return vehiclePlate;
  }

  public void setVehiclePlate(String vehiclePlate) {
    this.vehiclePlate = vehiclePlate;
  }
}