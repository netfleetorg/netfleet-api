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
package org.netfleet.api.commons.services;

import java.io.Serializable;
import java.util.Map;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public abstract class MessengerEvent<T> implements Serializable {

  private Map<String, Object> properties;
  private EventDestination source;
  private EventDestination destination;
  private T payload;
  private Long timestamp;

  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  public EventDestination getSource() {
    return source;
  }

  public void setSource(EventDestination source) {
    this.source = source;
  }

  public EventDestination getDestination() {
    return destination;
  }

  public void setDestination(EventDestination destination) {
    this.destination = destination;
  }

  public T getPayload() {
    return payload;
  }

  public void setPayload(T payload) {
    this.payload = payload;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
}
