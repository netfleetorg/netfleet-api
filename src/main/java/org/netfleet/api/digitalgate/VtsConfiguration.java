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
package org.netfleet.api.digitalgate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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
public class VtsConfiguration extends AbstractDigitalGateResponse {

  private Long id;
  private String code;
  private String description;
  private String endpoint;
  private String basePath;
  private Integer port;
  private String login;
  private String accessKey;
  private String websocketEndpoint;
  private String gpsDestination;
  private String gpsTopic;
  private String notificationDestination;
  private String notificationPublicDestination;
  private String notificationTopic;

  public VtsConfiguration() {
  }

  public String websocketHost() {
    StringBuilder sb = new StringBuilder();
    sb.append("http://").append(endpoint);
    if (port != null) {
      sb.append(":").append(port);
    }

    sb.append(websocketEndpoint);

    return sb.toString();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  @Override
  public String getBasePath() {
    return basePath;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  @Override
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getWebsocketEndpoint() {
    return websocketEndpoint;
  }

  public void setWebsocketEndpoint(String websocketEndpoint) {
    this.websocketEndpoint = websocketEndpoint;
  }

  public String getGpsDestination() {
    return gpsDestination;
  }

  public void setGpsDestination(String gpsDestination) {
    this.gpsDestination = gpsDestination;
  }

  public String getGpsTopic() {
    return gpsTopic;
  }

  public void setGpsTopic(String gpsTopic) {
    this.gpsTopic = gpsTopic;
  }

  public String getNotificationDestination() {
    return notificationDestination;
  }

  public void setNotificationDestination(String notificationDestination) {
    this.notificationDestination = notificationDestination;
  }

  public String getNotificationPublicDestination() {
    return notificationPublicDestination;
  }

  public void setNotificationPublicDestination(String notificationPublicDestination) {
    this.notificationPublicDestination = notificationPublicDestination;
  }

  public String getNotificationTopic() {
    return notificationTopic;
  }

  public void setNotificationTopic(String notificationTopic) {
    this.notificationTopic = notificationTopic;
  }
}
