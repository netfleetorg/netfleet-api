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
package org.netfleet.api.model.vts;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.netfleet.api.model.Model;

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
public class VelocityViolation implements Model {

  private Long id;
  private Long vehicleTrackingId;
  private Long driverId;
  private String driverUsername;
  private Long vehicleId;
  private String vehiclePlate;
  private String coordinate;
  private Integer velocity;

  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private Calendar time;

  public VelocityViolation() {
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public Long getVehicleTrackingId() {
    return vehicleTrackingId;
  }

  public void setVehicleTrackingId(Long vehicleTrackingId) {
    this.vehicleTrackingId = vehicleTrackingId;
  }

  public void setDriverId(Long driverId) {
    this.driverId = driverId;
  }

  public Long getDriverId() {
    return driverId;
  }

  public void setDriverUsername(String driverUsername) {
    this.driverUsername = driverUsername;
  }

  public String getDriverUsername() {
    return driverUsername;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehiclePlate(String vehiclePlate) {
    this.vehiclePlate = vehiclePlate;
  }

  public String getVehiclePlate() {
    return vehiclePlate;
  }

  public String getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(String coordinate) {
    this.coordinate = coordinate;
  }

  public Integer getVelocity() {
    return velocity;
  }

  public void setVelocity(Integer velocity) {
    this.velocity = velocity;
  }

  public Calendar getTime() {
    return time;
  }

  public void setTime(Calendar time) {
    this.time = time;
  }
}
