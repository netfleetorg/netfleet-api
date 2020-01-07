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

import org.netfleet.api.commons.LocationList;
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
public class VehicleTracking implements Model {

  private Long id;
  private Long reporterId;
  private String reporterUsername;
  private Long assigneeId;
  private String assigneeUsername;
  private Long driverId;
  private String driverUsername;
  private Long vehicleId;
  private String vehiclePlate;

  private String type;
  private String title;
  private String content;
  private String status;

  private Calendar date;
  private Calendar beginDate;
  private Calendar endDate;

  private String startPoint;
  private String endPoint;

  @Deprecated
  private Boolean completed;

  private Long routeId;

  private Float approximateDistance;
  private Float approximateDuration;
  private Float totalDistance;
  private Float totalDuration;
  private Integer progress;
  private Integer velocityLimit;
  private Integer averageVelocity;
  private Integer maxVelocity;
  private Integer velocityViolationCount;

  private LocationList locations;

  public VehicleTracking() {
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public Long getReporterId() {
    return reporterId;
  }

  public void setReporterId(Long reporterId) {
    this.reporterId = reporterId;
  }

  public void setReporterUsername(String reporterUsername) {
    this.reporterUsername = reporterUsername;
  }

  public String getReporterUsername() {
    return reporterUsername;
  }

  public Long getAssigneeId() {
    return assigneeId;
  }

  public void setAssigneeId(Long assigneeId) {
    this.assigneeId = assigneeId;
  }

  public void setAssigneeUsername(String assigneeUsername) {
    this.assigneeUsername = assigneeUsername;
  }

  public String getAssigneeUsername() {
    return assigneeUsername;
  }

  public Long getDriverId() {
    return driverId;
  }

  public void setDriverId(Long driverId) {
    this.driverId = driverId;
  }

  public void setDriverUsername(String driverUsername) {
    this.driverUsername = driverUsername;
  }

  public String getDriverUsername() {
    return driverUsername;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public void setVehiclePlate(String vehiclePlate) {
    this.vehiclePlate = vehiclePlate;
  }

  public String getVehiclePlate() {
    return vehiclePlate;
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

  @Deprecated
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  @Deprecated
  public Boolean getCompleted() {
    return completed;
  }

  public Long getRouteId() {
    return routeId;
  }

  public void setRouteId(Long routeId) {
    this.routeId = routeId;
  }

  public Float getApproximateDistance() {
    return approximateDistance;
  }

  public void setApproximateDistance(Float approximateDistance) {
    this.approximateDistance = approximateDistance;
  }

  public Float getApproximateDuration() {
    return approximateDuration;
  }

  public void setApproximateDuration(Float approximateDuration) {
    this.approximateDuration = approximateDuration;
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

  public LocationList getLocations() {
    return locations;
  }

  public void setLocations(LocationList locations) {
    this.locations = locations;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  public Integer getProgress() {
    return progress;
  }

  public void setAverageVelocity(Integer averageVelocity) {
    this.averageVelocity = averageVelocity;
  }

  public Integer getAverageVelocity() {
    return averageVelocity;
  }

  public void setVelocityLimit(Integer velocityLimit) {
    this.velocityLimit = velocityLimit;
  }

  public Integer getVelocityLimit() {
    return velocityLimit;
  }

  public void setMaxVelocity(Integer maxVelocity) {
    this.maxVelocity = maxVelocity;
  }

  public Integer getMaxVelocity() {
    return maxVelocity;
  }

  public void setVelocityViolationCount(Integer velocityViolationCount) {
    this.velocityViolationCount = velocityViolationCount;
  }

  public Integer getVelocityViolationCount() {
    return velocityViolationCount;
  }
}
