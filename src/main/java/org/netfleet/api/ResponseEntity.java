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

import org.netfleet.api.commons.http.HttpHeaders;
import org.netfleet.api.commons.http.HttpStatus;

import java.io.Serializable;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public class ResponseEntity<T> implements Serializable {

  public static final ResponseEntity<?> EMPTY = new ResponseEntity<>();

  private final HttpHeaders headers;
  private final HttpStatus status;
  private final T body;

  public ResponseEntity() {
    this(null, null, null);
  }

  public ResponseEntity(HttpHeaders headers, T body) {
    this(headers, null, body);
  }

  public ResponseEntity(HttpHeaders headers, HttpStatus status) {
    this(headers, status, null);
  }

  public ResponseEntity(HttpHeaders headers, HttpStatus status, T body) {
    this.headers = headers;
    this.status = status;
    this.body = body;
  }

  public static <T> ResponseEntity<T> of(HttpHeaders headers, HttpStatus status, T body) {
    return new ResponseEntity<>(headers, status, body);
  }

  public static <T> ResponseEntity<T> of(HttpHeaders headers, HttpStatus status) {
    return new ResponseEntity<>(headers, status, null);
  }

  public HttpHeaders getHeaders() {
    return headers;
  }

  public T getBody() {
    return body;
  }

  public boolean hasBody() {
    return (this.body != null);
  }

  public HttpStatus getStatus() {
    return status;
  }
}
