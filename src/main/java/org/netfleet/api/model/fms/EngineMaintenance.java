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
package org.netfleet.api.model.fms;

import org.netfleet.api.model.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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
  fieldVisibility = Visibility.ANY,
  getterVisibility = Visibility.NONE,
  setterVisibility = Visibility.NONE
)
public class EngineMaintenance implements Model {

  private Long id;
  private Long vehicleId;
  private String title;
  private String description;
  private Calendar date;
  private Float mileage;
  private Float nextMaintenanceMileage;
  private Calendar nextMaintenanceDate;
  private String authorizedServiceGsm;
  private String authorizedServiceAddress;
  private Float amount;
  private Boolean pollenFilter;
  private Boolean oilFilter;
  private Boolean airFilter;
  private Boolean fuelFilter;
  private Boolean bujisparkPlug;
  private Boolean engineOil;
  private Boolean gearBox;
  private Boolean differential;
  private Boolean timingBelt;
  private Boolean alignment;
  private Boolean rotBalancing;
  private String filePath;
  private List<String> fileNames;

  public EngineMaintenance() {
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public Long getId() {
    return id;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
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

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public Float getMileage() {
    return mileage;
  }

  public void setMileage(Float mileage) {
    this.mileage = mileage;
  }

  public Float getNextMaintenanceMileage() {
    return nextMaintenanceMileage;
  }

  public void setNextMaintenanceMileage(Float nextMaintenanceMileage) {
    this.nextMaintenanceMileage = nextMaintenanceMileage;
  }

  public Calendar getNextMaintenanceDate() {
    return nextMaintenanceDate;
  }

  public void setNextMaintenanceDate(Calendar nextMaintenanceDate) {
    this.nextMaintenanceDate = nextMaintenanceDate;
  }

  public String getAuthorizedServiceGsm() {
    return authorizedServiceGsm;
  }

  public void setAuthorizedServiceGsm(String authorizedServiceGsm) {
    this.authorizedServiceGsm = authorizedServiceGsm;
  }

  public String getAuthorizedServiceAddress() {
    return authorizedServiceAddress;
  }

  public void setAuthorizedServiceAddress(String authorizedServiceAddress) {
    this.authorizedServiceAddress = authorizedServiceAddress;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public Boolean getPollenFilter() {
    return pollenFilter;
  }

  public void setPollenFilter(Boolean pollenFilter) {
    this.pollenFilter = pollenFilter;
  }

  public Boolean getOilFilter() {
    return oilFilter;
  }

  public void setOilFilter(Boolean oilFilter) {
    this.oilFilter = oilFilter;
  }

  public Boolean getAirFilter() {
    return airFilter;
  }

  public void setAirFilter(Boolean airFilter) {
    this.airFilter = airFilter;
  }

  public Boolean getFuelFilter() {
    return fuelFilter;
  }

  public void setFuelFilter(Boolean fuelFilter) {
    this.fuelFilter = fuelFilter;
  }

  public Boolean getBujisparkPlug() {
    return bujisparkPlug;
  }

  public void setBujisparkPlug(Boolean bujisparkPlug) {
    this.bujisparkPlug = bujisparkPlug;
  }

  public Boolean getEngineOil() {
    return engineOil;
  }

  public void setEngineOil(Boolean engineOil) {
    this.engineOil = engineOil;
  }

  public Boolean getGearBox() {
    return gearBox;
  }

  public void setGearBox(Boolean gearBox) {
    this.gearBox = gearBox;
  }

  public Boolean getDifferential() {
    return differential;
  }

  public void setDifferential(Boolean differential) {
    this.differential = differential;
  }

  public Boolean getTimingBelt() {
    return timingBelt;
  }

  public void setTimingBelt(Boolean timingBelt) {
    this.timingBelt = timingBelt;
  }

  public Boolean getAlignment() {
    return alignment;
  }

  public void setAlignment(Boolean alignment) {
    this.alignment = alignment;
  }

  public Boolean getRotBalancing() {
    return rotBalancing;
  }

  public void setRotBalancing(Boolean rotBalancing) {
    this.rotBalancing = rotBalancing;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public List<String> getFileNames() {
    return fileNames;
  }

  public void setFileNames(List<String> fileNames) {
    this.fileNames = fileNames;
  }
}
