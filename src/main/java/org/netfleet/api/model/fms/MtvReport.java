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
public class MtvReport implements Model {

  private Long id;
  private Long vehicleId;
  private Integer semesterYear;
  private Integer semester;
  private Float amount;
  private String fullname;
  private String appellation;
  private String identityNumber;
  private String taxIdentificationNumber;
  private String filePath;
  private List<String> fileNames;

  public MtvReport() {
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

  public Integer getSemesterYear() {
    return semesterYear;
  }

  public void setSemesterYear(Integer semesterYear) {
    this.semesterYear = semesterYear;
  }

  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getAppellation() {
    return appellation;
  }

  public void setAppellation(String appellation) {
    this.appellation = appellation;
  }

  public String getIdentityNumber() {
    return identityNumber;
  }

  public void setIdentityNumber(String identityNumber) {
    this.identityNumber = identityNumber;
  }

  public String getTaxIdentificationNumber() {
    return taxIdentificationNumber;
  }

  public void setTaxIdentificationNumber(String taxIdentificationNumber) {
    this.taxIdentificationNumber = taxIdentificationNumber;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public void setFileNames(List<String> fileNames) {
    this.fileNames = fileNames;
  }

  public List<String> getFileNames() {
    return fileNames;
  }
}
