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

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.RequestBody;
import org.netfleet.api.converter.ResponseModelConverter;
import org.netfleet.api.converter.ResponseModelListConverter;
import org.netfleet.api.converter.ResponsePageableConverter;
import org.netfleet.api.converter.ResponsePrimitiveConverter;
import org.netfleet.sdk.network.http.HttpHeaders;
import org.netfleet.sdk.network.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public final class RequestTemplate {

  private static final Logger log = LoggerFactory.getLogger(RequestTemplate.class);
  private static final long DEFAULT_TIMEOUT = 5000;

  private final OkHttpClient httpClient;
  private final HttpHeaders httpHeaders;
  private final String url;

  public static final RequestContext REQUEST_CONTEXT;

  static {
    REQUEST_CONTEXT = new DefaultRequestContext();
  }

  public RequestTemplate(String url) {
    this(url, DEFAULT_TIMEOUT);
  }

  public RequestTemplate(String url, long timeout) {
    this.httpHeaders = new HttpHeaders();
    this.url = url;

    this.httpClient = new OkHttpClient.Builder()
      .connectTimeout(timeout, TimeUnit.MILLISECONDS)
      .readTimeout(timeout, TimeUnit.MILLISECONDS)
      .build();
  }

  public RequestTemplate(String url, RequestContext context) {
    this(url);
    mergeRequestContext(context);
  }

  public RequestTemplate(String url, long timeout, RequestContext context) {
    this(url, timeout);
    mergeRequestContext(context);
  }

  private void mergeRequestContext(RequestContext context) {
    for (Map.Entry<Class<?>, Projection> entry: context.getProjections().entrySet()) {
      REQUEST_CONTEXT.getProjections().put(entry.getKey(), entry.getValue());
    }

    for (Map.Entry<Class<?>, String> entry :context.getPaths().entrySet()) {
      REQUEST_CONTEXT.getPaths().put(entry.getKey(), entry.getValue());
    }
  }

  /**
   * adds given pair of strings as header key value.
   *
   * @param key   the header key.
   * @param value the header value.
   */
  public void setHeader(String key, String value) {
    httpHeaders.add(key, value);
  }

  /**
   * Helper method for creating base namespace
   */
  private Namespace createNamespace(String model) {
    Namespace namespace = new Namespace(getUrl());
    namespace.add(model);

    return namespace;
  }

  /**
   * Helper method for creating okhttp3.Request.Builder from RequestTemplate.
   */
  private okhttp3.Request.Builder createRequestBuilder(Namespace ns) {
    Request.Builder builder = new Request.Builder();

    for (Map.Entry<String, List<String>> entry : getHttpHeaders()) {
      for (String value : entry.getValue()) {
        builder.header(entry.getKey(), value);
      }
    }

    builder.url(ns.toString());

    return builder;
  }

  private <T> Projection handleProjection(Class<T> classType, Projection projection) {
    final Projection proj;
    if (projection == null) {
      proj = REQUEST_CONTEXT.getProjections().get(classType);
    } else {
      proj = projection;
    }

    return proj;
  }

  public ResponseEntity<String> get(Namespace path, RequestParameters parameters) {
    Namespace namespace = createNamespace(path.toString());

    if (parameters != null) {
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        namespace.addParameter(entry.getKey(), entry.getValue());
      }
    }

    Request.Builder builder = createRequestBuilder(namespace);
    okhttp3.Request request = builder.build();

    return execute(request);
  }

  public ResponseEntity<String> get(Namespace path) {
    return get(path, null);
  }

  public ResponseEntity<String> post(Namespace path, RequestParameters parameters, String jsonBody) {
    Namespace namespace = createNamespace(path.toString());

    if (parameters != null) {
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        namespace.addParameter(entry.getKey(), entry.getValue());
      }
    }

    Request.Builder builder = createRequestBuilder(namespace);
    RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody);
    builder.post(body);

    okhttp3.Request request = builder.build();
    return execute(request);
  }

  public ResponseEntity<String> post(Namespace path, String jsonBody) {
    return post(path, null, jsonBody);
  }

  /**
   * Business method for executing okhttp3.Request.
   */
  private ResponseEntity<String> execute(okhttp3.Request request) {
    okhttp3.Response response = null;
    try {
      response = httpClient.newCall(request).execute();
    } catch (IOException e) {
      log.error("", e);
    }

    if (response == null)
      throw new IllegalStateException();

    HttpHeaders headers = new HttpHeaders();
    headers = headers.add(response.headers().toMultimap());

    String body = null;
    try {
      body = response.body().string();
    } catch (IOException e) {
      log.error("", e);
    }

    return ResponseEntity.of(headers, HttpStatus.of(response.code()), body);
  }

  /**
   * Finds the target entity from given id. Method uses default projection of
   * the classType.
   *
   * @param classType the class type to be mapped.
   * @param id        the id of target entity
   * @return response entity.
   */
  public <T extends Model> ResponseEntity<T> findById(Class<T> classType, Object id) {
    return findById(classType, id, null);
  }

  /**
   * Finds the target entity from given id and projection.
   *
   * @param classType  the class type to be mapped.
   * @param id         the id of target entity
   * @param projection the projection type
   * @return response entity.
   */
  public <T extends Model> ResponseEntity<T> findById(Class<T> classType, Object id, Projection projection) {
    String path = REQUEST_CONTEXT.getPaths().get(classType);

    Namespace namespace = createNamespace(path);
    namespace.add(id);

    Projection proj = handleProjection(classType, projection);
    namespace.addParameter("projection", proj.getValue());

    Request.Builder builder = createRequestBuilder(namespace);
    okhttp3.Request request = builder.build();

    ResponseEntity<String> entity = execute(request);
    ResponseConverter<T, T> converter = new ResponseModelConverter<>();

    return converter.convert(classType, entity);
  }

  public <T extends Model> List<T> findAll(Class<T> classType) {
    ResponseEntity<Page<T>> response = findAll(classType, null, null, null);

    Page<T> page = response.getBody();
    int pageCount = page.getTotalPages();

    List<T> stack = new ArrayList<>(page.getElements());
    if (pageCount > 1) {
      for (int i = 1; i < pageCount; i++) {
        response = findAll(classType, i, null, null);
        Page<T> tempPage = response.getBody();
        stack.addAll(tempPage.getElements());
      }
    }

    return stack;
  }

  /**
   * @param classType   the class type of model, cannot be {@literal null}.
   * @param pageable    the pageable object, may be {@literal null}.
   */
  public <T extends Model> ResponseEntity<Page<T>> findAll(Class<T> classType, Pageable pageable) {
    if (pageable == null) {
      return findAll(classType, null, null, null, null);
    } else {
      return findAll(classType, pageable.getPage(), pageable.getSize(), pageable.getSort(), null);
    }
  }

  public <T extends Model> ResponseEntity<Page<T>> findAll(Class<T> classType, Integer page,
                                                           Integer size, Sort sort) {
    return findAll(classType, page, size, sort, null);
  }

  public <T extends Model> ResponseEntity<Page<T>> findAll(Class<T> classType, Integer page,
                                                           Integer size, Sort sort,
                                                           Projection projection) {
    Namespace namespace = createNamespace(REQUEST_CONTEXT.getPaths().get(classType));

    if (page != null)
      namespace.addParameter("page", page);

    if (size != null)
      namespace.addParameter("size", size);

    if (sort != null) {
      for (Map.Entry<String, OrderType> entry: sort) {
        String param = entry.getKey() + "," + entry.getValue() + "&";
        namespace.addParameter("sort", param);
      }
    }

    Projection proj = handleProjection(classType, projection);
    namespace.addParameter("projection", proj.getValue());

    Request.Builder builder = createRequestBuilder(namespace);
    okhttp3.Request request = builder.build();

    ResponseEntity<String> entity = execute(request);
    ResponseConverter<T, Page<T>> converter = new ResponsePageableConverter<>();

    return converter.convert(classType, entity);
  }

  public <T extends Model> ResponseEntity<T> insert(Class<T> tClass, String entity, MediaType mediaType) {
    Namespace namespace = createNamespace(REQUEST_CONTEXT.getPaths().get(tClass));

    Request.Builder builder = createRequestBuilder(namespace);
    builder.post(RequestBody.create(mediaType, entity));
    okhttp3.Request request = builder.build();

    ResponseEntity<String> responseEntity = execute(request);

    return ResponseEntity.of(responseEntity.getHeaders(), responseEntity.getStatus());
  }

  public <T extends Model> ResponseEntity<T> update(Class<T> tClass, Object id, String entity, MediaType mediaType) {
    Namespace namespace = createNamespace(REQUEST_CONTEXT.getPaths().get(tClass));
    namespace.add(id);

    Request.Builder builder = createRequestBuilder(namespace);
    builder.patch(RequestBody.create(mediaType, entity));
    okhttp3.Request request = builder.build();

    ResponseEntity<String> responseEntity = execute(request);

    return ResponseEntity.of(responseEntity.getHeaders(), responseEntity.getStatus());
  }

  public <T extends Model> ResponseEntity<T> replace(Class<T> tClass, Object id, String entity, MediaType mediaType) {
    Namespace namespace = createNamespace(REQUEST_CONTEXT.getPaths().get(tClass));
    namespace.add(id);

    Request.Builder builder = createRequestBuilder(namespace);
    builder.put(RequestBody.create(mediaType, entity));
    okhttp3.Request request = builder.build();

    ResponseEntity<String> responseEntity = execute(request);

    return ResponseEntity.of(responseEntity.getHeaders(), responseEntity.getStatus());
  }

  public <T extends Model> ResponseEntity<T> delete(Class<T> tClass, Object id) {
    Namespace namespace = createNamespace(REQUEST_CONTEXT.getPaths().get(tClass));
    namespace.add(id);

    Request.Builder builder = createRequestBuilder(namespace);
    builder.delete();
    okhttp3.Request request = builder.build();

    ResponseEntity<String> responseEntity = execute(request);

    return ResponseEntity.of(responseEntity.getHeaders(), responseEntity.getStatus());
  }

  private <T> ResponseEntity<String> search(Class<T> tClass, String query, RequestParameters parameters,
                                            Projection projection) {
    Namespace namespace = createNamespace(REQUEST_CONTEXT.getPaths().get(tClass));
    namespace.add("search");
    namespace.add(query);

    if (parameters != null && !parameters.isEmpty()) {
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        namespace.addParameter(entry.getKey(), entry.getValue());
      }
    }

    if (!Projection.NONE.equals(projection)) {
      Projection proj = handleProjection(tClass, projection);
      if (proj != null)
        namespace.addParameter(Projection.PARAMETER, proj.getValue());
    }

    Request.Builder builder = createRequestBuilder(namespace);
    okhttp3.Request request = builder.build();

    return execute(request);
  }

  public <T extends Model> ResponseEntity<T> searchForEntity(Class<T> tClass, String query,
                                                             RequestParameters parameters,
                                                             Projection projection) {
    ResponseEntity<String> entity = search(tClass, query, parameters, projection);
    ResponseConverter<T, T> converter = new ResponseModelConverter<>();

    return converter.convert(tClass, entity);
  }

  public <T extends Model> ResponseEntity<List<T>> searchForAll(Class<T> tClass, String query,
                                                                RequestParameters parameters,
                                                                Projection projection) {
    ResponseEntity<String> entity = search(tClass, query, parameters, projection);
    ResponseConverter<T, List<T>> converter = new ResponseModelListConverter<>();

    return converter.convert(tClass, entity);
  }

  public <T extends Model> ResponseEntity<Page<T>> searchForPage(Class<T> tClass, String query,
                                                                 RequestParameters parameters,
                                                                 Projection projection) {
    ResponseEntity<String> entity = search(tClass, query, parameters, projection);
    ResponseConverter<T, Page<T>> converter = new ResponsePageableConverter<>();

    return converter.convert(tClass, entity);
  }

  /**
   * @param tClass      the class type of the model, cannot be {@literal null}.
   * @param query       the url path for request, cannot be {@literal null}.
   * @param pageable    the pageable object, may be {@literal null}.
   * @param parameters  the request parameters, may be {@literal null}.
   * @param projection  the projection type, may be {@literal null}.
   */
  public <T extends Model> ResponseEntity<Page<T>> searchForPage(Class<T> tClass, String query,
                                                                 Pageable pageable,
                                                                 RequestParameters parameters,
                                                                 Projection projection) {
    if (parameters == null) {
      parameters = new RequestParameters();
    }

    if (pageable != null) {
      parameters = pageable.toRequestParameters(parameters);
    }

    ResponseEntity<String> entity = search(tClass, query, parameters, projection);
    ResponseConverter<T, Page<T>> converter = new ResponsePageableConverter<>();

    return converter.convert(tClass, entity);
  }

  public <T> ResponseEntity<T> searchForObject(Class<?> modelType, Class<T> tClass,
                                               String query, RequestParameters parameters) {
    ResponseEntity<String> entity = search(modelType, query, parameters, Projection.NONE);
    ResponseConverter<T, T> converter = new ResponsePrimitiveConverter<>();

    return converter.convert(tClass, entity);
  }

  public <T> ResponseEntity<T> searchGet(Class<T> tClass, String query, RequestParameters parameters,
                                         Projection projection) {
    ResponseEntity<String> entity = search(tClass, query, parameters, projection);

    return ResponseEntity.of(entity.getHeaders(), entity.getStatus());
  }

  public String getUrl() {
    return url;
  }

  public HttpHeaders getHttpHeaders() {
    return httpHeaders;
  }
}
