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
public class Accident implements Model {

  private Long id;
  private Long vehicleId;
  private Long driverId;
  private String city;
  private Calendar date;
  private Integer defectRate;
  private String reason;
  private String status;
  private String serviceGsm;
  private String expertName;
  private String expertGsm;
  private String description;
  private String company;
  private String agency;
  private String policyNumber;
  private Calendar insuranceDate;
  private Float amount;
  private String filePath;
  private List<String> fileNames;

  public Accident() {
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
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

  public Long getDriverId() {
    return driverId;
  }

  public void setDriverId(Long driverId) {
    this.driverId = driverId;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public Integer getDefectRate() {
    return defectRate;
  }

  public void setDefectRate(Integer defectRate) {
    this.defectRate = defectRate;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getServiceGsm() {
    return serviceGsm;
  }

  public void setServiceGsm(String serviceGsm) {
    this.serviceGsm = serviceGsm;
  }

  public String getExpertName() {
    return expertName;
  }

  public void setExpertName(String expertName) {
    this.expertName = expertName;
  }

  public String getExpertGsm() {
    return expertGsm;
  }

  public void setExpertGsm(String expertGsm) {
    this.expertGsm = expertGsm;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getAgency() {
    return agency;
  }

  public void setAgency(String agency) {
    this.agency = agency;
  }

  public String getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  public Calendar getInsuranceDate() {
    return insuranceDate;
  }

  public void setInsuranceDate(Calendar insuranceDate) {
    this.insuranceDate = insuranceDate;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFileNames(List<String> fileNames) {
    this.fileNames = fileNames;
  }

  public List<String> getFileNames() {
    return fileNames;
  }
}
