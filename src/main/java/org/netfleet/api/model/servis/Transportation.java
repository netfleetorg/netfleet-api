/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (C) 2019 NetFleet
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
package org.netfleet.api.model.servis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.netfleet.api.commons.LocationList;
import org.netfleet.api.commons.servis.AttendanceList;
import org.netfleet.api.model.Model;

import java.util.Calendar;
import java.util.List;

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
public class Transportation implements Model {

  private Long id;
  private Long driverId;
  private String driverUsername;
  private Long vehicleId;
  private String vehiclePlate;

  private Integer index;
  private String type;
  private String title;
  private String content;
  private String status;

  private Calendar date;
  private Calendar beginDate;
  private Calendar endDate;

  private String startPoint;
  private String endPoint;

  private Long schemaId;
  private String schemaTitle;

  private Float totalDistance;
  private Float totalDuration;

  private List<Integer> nextStudentIds;

  @Deprecated
  private Long nextStudentId;

  private AttendanceList attendance;
  private LocationList locations;

  public Transportation() {
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
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

  public void setIndex(Integer index) {
    this.index = index;
  }

  public Integer getIndex() {
    return index;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
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

  public String getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(String startPoint) {
    this.startPoint = startPoint;
  }

  public String getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(String endPoint) {
    this.endPoint = endPoint;
  }

  public Long getSchemaId() {
    return schemaId;
  }

  public void setSchemaId(Long schemaId) {
    this.schemaId = schemaId;
  }

  public void setSchemaTitle(String schemaTitle) {
    this.schemaTitle = schemaTitle;
  }

  public String getSchemaTitle() {
    return schemaTitle;
  }

  public Float getTotalDistance() {
    return totalDistance;
  }

  public void setTotalDistance(Float totalDistance) {
    this.totalDistance = totalDistance;
  }

  public Float getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
  }

  @Deprecated
  public void setNextStudentId(Long nextStudentId) {
    this.nextStudentId = nextStudentId;
  }

  @Deprecated
  public Long getNextStudentId() {
    return nextStudentId;
  }

  public void setNextStudentIds(List<Integer> nextStudentIds) {
    this.nextStudentIds = nextStudentIds;
  }

  public List<Integer> getNextStudentIds() {
    return nextStudentIds;
  }

  public AttendanceList getAttendance() {
    return attendance;
  }

  public void setAttendance(AttendanceList attendances) {
    this.attendance = attendances;
  }

  public LocationList getLocations() {
    return locations;
  }

  public void setLocations(LocationList locations) {
    this.locations = locations;
  }
}
