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
package org.netfleet.api.commons;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public final class Namespace {

  private final StringBuilder source;
  private boolean parameterized = false;

  public Namespace() {
    this(new StringBuilder());
  }

  public Namespace(String source) {
    this(new StringBuilder(source));
  }

  public static Namespace newNamespace() {
    return new Namespace();
  }

  public static Namespace newNamespace(String source) {
    return new Namespace(source);
  }

  public static String merge(String source, Object... namespaces) {
    Namespace resolver = new Namespace(source);
    resolver = resolver.add(namespaces);

    return resolver.toString();
  }

  private Namespace(StringBuilder source) {
    this.source = source;
  }

  private void resolve(Object... namespaces) {
    for (Object namespace : namespaces) {
      // if next namespace is null, then ignore it.
      if (namespace == null) {
        continue;
      }

      if (namespace instanceof String) {
        if (((String) namespace).startsWith("/")) {
          namespace = ((String) namespace).substring(1);
        }
      }

      // if source of namespace is not blank.
      if (source.length() != 0) {
        // get true length.
        int len = source.length() - 1;
        // if last char of source is not '/' then add.
        if (source.charAt(len) != '/') {
          source.append('/');
        }
      }

      if (namespace instanceof String) {
        String ns = (String) namespace;
        if (ns.length() == 0) {
          continue;
        }
      }

      source.append(namespace);
    }

    if (source.charAt(source.length() - 1) != '/') {
      source.append('/');
    }
  }

  public Namespace add(Object... namespaces) {
    resolve(namespaces);
    return this;
  }

  public Namespace add(Namespace namespace) {
    resolve(namespace.toString());
    return this;
  }

  public Namespace addParameter(String parameter, Object value) {
    if (parameterized) {
      source.append("&");
    }

    if (source.charAt(source.length() - 1) == '/') {
      source.deleteCharAt(source.length() -1);
    }

    if (!parameterized) {
      source.append("?");
    }

    source.append(parameter);
    source.append("=");
    source.append(value);

    parameterized = true;

    return this;
  }

  @Override
  public String toString() {
    return source.toString();
  }

}
