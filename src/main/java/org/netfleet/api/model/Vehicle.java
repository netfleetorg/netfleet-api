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
public class Vehicle implements Model {

  private Long id;
  private String plate;
  private String brand;
  private String model;
  private Integer modelYear;
  private String type;
  private String vehicleLicenceClass;
  private Integer load;
  private String chasis;
  private Calendar registrationDate;
  private String documentRegistrationCode;
  private Long mileage;
  private Long lastMileage;
  private Calendar mileageLastUpdateDate;

  public Vehicle() {
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setModelYear(Integer modelYear) {
    this.modelYear = modelYear;
  }

  public Integer getModelYear() {
    return modelYear;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setLoad(Integer load) {
    this.load = load;
  }

  public Integer getLoad() {
    return load;
  }

  public void setVehicleLicenceClass(String vehicleLicenceClass) {
    this.vehicleLicenceClass = vehicleLicenceClass;
  }

  public String getVehicleLicenceClass() {
    return vehicleLicenceClass;
  }

  public String getChasis() {
    return chasis;
  }

  public void setChasis(String chasis) {
    this.chasis = chasis;
  }

  public Calendar getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Calendar registrationDate) {
    this.registrationDate = registrationDate;
  }

  public void setDocumentRegistrationCode(String documentRegistrationCode) {
    this.documentRegistrationCode = documentRegistrationCode;
  }

  public String getDocumentRegistrationCode() {
    return documentRegistrationCode;
  }

  public Long getMileage() {
    return mileage;
  }

  public void setMileage(Long mileage) {
    this.mileage = mileage;
  }

  public Long getLastMileage() {
    return lastMileage;
  }

  public void setLastMileage(Long lastMileage) {
    this.lastMileage = lastMileage;
  }

  public Calendar getMileageLastUpdateDate() {
    return mileageLastUpdateDate;
  }

  public void setMileageLastUpdateDate(Calendar mileageLastUpdateDate) {
    this.mileageLastUpdateDate = mileageLastUpdateDate;
  }

}
