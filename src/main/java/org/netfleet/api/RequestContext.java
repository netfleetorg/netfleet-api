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
import java.util.Map;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 */
public class RequestContext implements Serializable {

  private Map<Class<?>, String> paths;
  private Map<Class<?>, Projection> projections;

  public RequestContext() {
  }

  public RequestContext(Map<Class<?>, String> paths, Map<Class<?>, Projection> projections) {
    this.paths = paths;
    this.projections = projections;
  }

  public void setPaths(Map<Class<?>, String> paths) {
    this.paths = paths;
  }

  public Map<Class<?>, String> getPaths() {
    return paths;
  }

  public void setProjections(Map<Class<?>, Projection> projections) {
    this.projections = projections;
  }

  public Map<Class<?>, Projection> getProjections() {
    return projections;
  }
}
