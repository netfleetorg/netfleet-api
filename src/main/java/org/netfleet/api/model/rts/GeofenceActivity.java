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
package org.netfleet.api.model.rts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.netfleet.api.model.Model;

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
public class GeofenceActivity implements Model {

  private Long id;
  private String type;
  private Long zoneId;
  private String zoneTitle;
  private Long alarmId;
  private String alarmTitle;
  private Long vehicleId;
  private String vehiclePlate;
  private Long jobId;
  private Long driverId;
  private String driverUsername;
  private Calendar date;
  private String coordinate;
  private Float speed;

  public GeofenceActivity() {
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public Long getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setZoneId(Long zoneId) {
    this.zoneId = zoneId;
  }

  public Long getZoneId() {
    return zoneId;
  }

  public void setZoneTitle(String zoneTitle) {
    this.zoneTitle = zoneTitle;
  }

  public String getZoneTitle() {
    return zoneTitle;
  }

  public Long getAlarmId() {
    return alarmId;
  }

  public void setAlarmId(Long alarmId) {
    this.alarmId = alarmId;
  }

  public String getAlarmTitle() {
    return alarmTitle;
  }

  public void setAlarmTitle(String alarmTitle) {
    this.alarmTitle = alarmTitle;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getVehiclePlate() {
    return vehiclePlate;
  }

  public void setVehiclePlate(String vehiclePlate) {
    this.vehiclePlate = vehiclePlate;
  }

  public Long getJobId() {
    return jobId;
  }

  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  public Long getDriverId() {
    return driverId;
  }

  public void setDriverId(Long driverId) {
    this.driverId = driverId;
  }

  public String getDriverUsername() {
    return driverUsername;
  }

  public void setDriverUsername(String driverUsername) {
    this.driverUsername = driverUsername;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public String getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(String coordinate) {
    this.coordinate = coordinate;
  }

  public Float getSpeed() {
    return speed;
  }

  public void setSpeed(Float speed) {
    this.speed = speed;
  }
}
