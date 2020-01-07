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
package org.netfleet.api.model.servis;

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
public class ParentNotification implements Model {

  private Long id;
  private String title;
  private String content;
  private Long transportationId;
  private Integer transportationIndex;
  private String transportationTitle;
  private Long parentId;
  private String parentUsername;
  private Long schemaId;
  private String schemaTitle;
  private Long studentId;
  private String studentFullname;
  private String type;
  private Calendar date;
  private Boolean notified;
  private Integer index;

  public ParentNotification() {
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
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

  public Long getTransportationId() {
    return transportationId;
  }

  public void setTransportationId(Long transportationId) {
    this.transportationId = transportationId;
  }

  public Integer getTransportationIndex() {
    return transportationIndex;
  }

  public void setTransportationIndex(Integer transportationIndex) {
    this.transportationIndex = transportationIndex;
  }

  public String getTransportationTitle() {
    return transportationTitle;
  }

  public void setTransportationTitle(String transportationTitle) {
    this.transportationTitle = transportationTitle;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getParentUsername() {
    return parentUsername;
  }

  public void setParentUsername(String parentUsername) {
    this.parentUsername = parentUsername;
  }

  public Long getSchemaId() {
    return schemaId;
  }

  public void setSchemaId(Long schemaId) {
    this.schemaId = schemaId;
  }

  public String getSchemaTitle() {
    return schemaTitle;
  }

  public void setSchemaTitle(String schemaTitle) {
    this.schemaTitle = schemaTitle;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public String getStudentFullname() {
    return studentFullname;
  }

  public void setStudentFullname(String studentFullname) {
    this.studentFullname = studentFullname;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public Boolean getNotified() {
    return notified;
  }

  public void setNotified(Boolean notified) {
    this.notified = notified;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }
}
