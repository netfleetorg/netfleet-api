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
import org.netfleet.api.digitalgate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 */
public class DefaultDigitalGateApiAdapter implements DigitalGateApiAdapter {

  private static final Logger log = LoggerFactory.getLogger(DefaultDigitalGateApiAdapter.class);

  private final ObjectMapper mapper;
  private final DigitalGateApi api;

  public DefaultDigitalGateApiAdapter(DigitalGateApi api) {
    this.mapper = new ObjectMapper();
    this.api = api;
  }

  @Override
  public EnterpriseConfiguration makeRequest(String code) {
    String body = api.get(code, DigitalGateRequestTypes.ENTERPRISE.getValue());

    EnterpriseConfiguration gate = null;
    try {
      gate = mapper.readValue(body, EnterpriseConfiguration.class);
    } catch (IOException e) {
      log.info("", e);
    }

    return gate;
  }

}
