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
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public class Pageable implements Serializable {

  private Integer page;
  private Integer size;
  private Sort sort;

  public Pageable() {
  }

  public Pageable(Integer page, Integer size, Sort sort) {
    this.page = page;
    this.size = size;
    this.sort = sort;
  }

  public static Pageable empty() {
    return new Pageable();
  }

  public static Pageable of(Integer page, Integer size, Sort sort) {
    return new Pageable(page, size, sort);
  }

  public RequestParameters toRequestParameters() {
    return toRequestParameters(new RequestParameters());
  }

  public RequestParameters toRequestParameters(RequestParameters parameters) {
    if (getPage() != null) {
      parameters.put("page", getPage());
    }

    if (getSize() != null) {
      parameters.put("size", getSize());
    }

    if (sort != null) {
      for (Map.Entry<String, OrderType> entry: sort) {
        String param = entry.getKey() + "," + entry.getValue() + "&";
        parameters.put("sort", param);
      }
    }

    return parameters;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Sort getSort() {
    return sort;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }

}
