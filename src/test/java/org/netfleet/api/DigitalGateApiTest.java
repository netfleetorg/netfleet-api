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

import org.junit.Ignore;
import org.junit.Test;
import org.netfleet.api.digitalgate.DigitalGateRequestType;
import org.netfleet.api.digitalgate.DigitalGateRequestTypes;
import org.netfleet.api.digitalgate.DigitalGateResponse;
import org.netfleet.api.digitalgate.EnterpriseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigitalGateApiTest {

  private final Logger log = LoggerFactory.getLogger(DigitalGateApiTest.class);

  @Ignore
  public void testSimple() {
    String token = "";
    String url = "";

    DigitalGateRequestType type = DigitalGateRequestTypes.ENTERPRISE;
    DigitalGateApi digitalGateApi = new DigitalGateApi(token, url);
    DigitalGateResponse response = digitalGateApi.request("", type);

    if (response != null) {
      log.info("host: {}", response.host());
    }
  }

  @Ignore
  public void test2() {
    String token = "";
    String url = "";

    DigitalGateApi digitalGateApi = new DigitalGateApi(token, url);
    DefaultDigitalGateApiAdapter adapter = new DefaultDigitalGateApiAdapter(digitalGateApi);

    EnterpriseConfiguration cfg = adapter.makeRequest("");
  }

}