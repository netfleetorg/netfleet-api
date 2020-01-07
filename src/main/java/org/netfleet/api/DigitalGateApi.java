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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.netfleet.api.commons.Namespace;
import org.netfleet.api.commons.http.HttpStatus;
import org.netfleet.api.digitalgate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public final class DigitalGateApi {

  private static final Logger log = LoggerFactory.getLogger(DigitalGateApi.class);

  public static final String PATH = "digitalgate";
  public static final String TOKEN_PARAMETER = "token";
  public static final String CODE_PARAMETER = "code";
  public static final String TYPE_PARAMETER = "type";

  private final String token;
  private final String url;

  public DigitalGateApi(String token, String url) {
    this.token = token;
    this.url = url;
  }

  public DigitalGateResponse request(String code, DigitalGateRequestType requestType) {
    RequestTemplate template = new RequestTemplate(url);

    Namespace ns = new Namespace();
    ns.add(PATH);

    RequestParameters parameters = new RequestParameters();
    parameters.put(TOKEN_PARAMETER, token);
    parameters.put(CODE_PARAMETER, code);
    parameters.put(TYPE_PARAMETER, requestType.toString());

    ResponseEntity<String> response = template.get(ns, parameters);
    HttpStatus status = response.getStatus();
    if (status == null || status.getCode() == 400) {
      return null;
    }

    ObjectMapper mapper = new ObjectMapper();
    DigitalGateResponse gate = null;
    try {
      switch (requestType) {
        case VTS: gate = mapper.readValue(response.getBody(), VtsConfiguration.class); break;
        case FMS: gate = mapper.readValue(response.getBody(), FmsConfiguration.class); break;
        case SERVIS: gate = mapper.readValue(response.getBody(), ServisConfiguration.class); break;
      }
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }

    return gate;
  }

  public VtsConfiguration requestForVts(String code) {
    return (VtsConfiguration) request(code, DigitalGateRequestType.VTS);
  }

  public FmsConfiguration requestForFms(String code) {
    return (FmsConfiguration) request(code, DigitalGateRequestType.FMS);
  }

  public ServisConfiguration requestForServis(String code) {
    return (ServisConfiguration) request(code, DigitalGateRequestType.SERVIS);
  }
}
