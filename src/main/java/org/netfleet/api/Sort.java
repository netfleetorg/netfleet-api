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
package org.netfleet.api;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public class Sort implements Iterable<Map.Entry<String, OrderType>>, Serializable {

  private Map<String, OrderType> parameters;

  public Sort() {
    this(new LinkedHashMap<String, OrderType>());
  }

  public Sort(Map<String, OrderType> parameters) {
    this.parameters = parameters;
  }

  public Sort putParameter(String property, OrderType orderType) {
    getParameters().put(property, orderType);
    return this;
  }

  public Sort removeParameter(String property) {
    getParameters().remove(property);
    return this;
  }

  public boolean containsProperty(String property) {
    return getParameters().containsKey(property);
  }

  @Override
  public Iterator<Map.Entry<String, OrderType>> iterator() {
    return getParameters().entrySet().iterator();
  }

  public Map<String, OrderType> getParameters() {
    return parameters;
  }

}
