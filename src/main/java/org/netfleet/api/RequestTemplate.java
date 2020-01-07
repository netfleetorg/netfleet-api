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
import org.netfleet.api.commons.Namespace;
import org.netfleet.api.commons.http.HttpHeaders;
import org.netfleet.api.commons.http.HttpStatus;
import org.netfleet.api.converter.ResponseModelConverter;
import org.netfleet.api.converter.ResponseModelListConverter;
import org.netfleet.api.converter.ResponsePageableConverter;
import org.netfleet.api.converter.ResponsePrimitiveConverter;
import org.netfleet.api.model.*;
import org.netfleet.api.model.fms.*;
import org.netfleet.api.model.rts.*;
import org.netfleet.api.model.servis.*;
import org.netfleet.api.model.vts.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
  private HttpHeaders httpHeaders;
  private final String url;

  public static final Map<Class<?>, String> PATHS;
  public static final Map<Class<?>, Projection> PROJECTIONS;

  static {
    PATHS = new HashMap<>();
    PATHS.put(Announcement.class, "announcement");
    PATHS.put(ArchivedNotification.class, "archivednotification");
    PATHS.put(Department.class, "department");
    PATHS.put(Duty.class, "duty");
    PATHS.put(DutyType.class, "dutytype");
    PATHS.put(Issue.class, "issue");
    PATHS.put(IssueType.class, "issuetype");
    PATHS.put(Message.class, "message");
    PATHS.put(Notification.class, "notification");
    PATHS.put(Place.class, "place");
    PATHS.put(PlaceGroup.class, "placegroup");
    PATHS.put(Route.class, "route");
    PATHS.put(RouteGroup.class, "routegroup");
    PATHS.put(User.class, "user");
    PATHS.put(Vehicle.class, "vehicle");
    PATHS.put(VehicleTracking.class, "vehicletracking");
    PATHS.put(VelocityViolation.class, "velocityviolation");
    PATHS.put(Checkpoint.class, "checkpoint");
    PATHS.put(RegionAlarm.class, "regionalarm");
    PATHS.put(RegionAlarmActivity.class, "regionalarmactivity");
    PATHS.put(MonitoringPermission.class, "monitoringpermission");
    PATHS.put(GeographicZone.class, "geographiczone");
    PATHS.put(GeographicZoneAlarm.class, "geographiczonealarm");
    PATHS.put(GeographicZoneAlarmActivity.class, "geographiczonealarmactivity");
    PATHS.put(SpeedAlarm.class, "speedalarm");
    PATHS.put(SpeedAlarmActivity.class, "speedalarmactivity");
    PATHS.put(Activity.class, "activity");
    PATHS.put(Accident.class, "accident");
    PATHS.put(BalataMaintenance.class, "balatamaintenance");
    PATHS.put(CarWashing.class, "carwashing");
    PATHS.put(EngineMaintenance.class, "enginemaintenance");
    PATHS.put(FuelTrack.class, "fueltracking");
    PATHS.put(GasStation.class, "gasstation");
    PATHS.put(InspectionReport.class, "inspectionreport");
    PATHS.put(InsurancePolicy.class, "insurancepolicy");
    PATHS.put(MtvReport.class, "mtvreport");
    PATHS.put(OdyCertificate.class, "odycertificate");
    PATHS.put(Reminder.class, "reminder");
    PATHS.put(SrcCertificate.class, "srccertificate");
    PATHS.put(TireMaintenance.class, "tiremaintenance");
    PATHS.put(TrafficFine.class, "trafficfine");
    PATHS.put(PsychotechnicsCertificate.class, "psychotechnicscertificate");
    PATHS.put(Outgoing.class, "outgoing");
    PATHS.put(SeatInsurance.class, "seatinsurance");
    PATHS.put(ExhaustInspection.class, "exhaustinspection");
    PATHS.put(Student.class, "student");
    PATHS.put(School.class, "school");
    PATHS.put(Transportation.class, "transportation");
    PATHS.put(TransportationSchema.class, "transportationschema");
    PATHS.put(Absence.class, "absence");
    PATHS.put(ParentNotification.class, "parentnotification");
    PATHS.put(ParentArchivedNotification.class, "parentarchivednotification");
    PATHS.put(TransportationMapping.class, "transportationmapping");
    PATHS.put(DeviceMapping.class, "devicemapping");
    PATHS.put(CurrentLocation.class, "currentlocation");
    PATHS.put(GeofenceZone.class, "geofencezone");
    PATHS.put(GeofenceRoute.class, "geofenceroute");
    PATHS.put(Geofence.class, "geofence");
    PATHS.put(GeofenceJob.class, "geofencejob");
    PATHS.put(GeofenceActivity.class, "geofenceactivity");
    PATHS.put(GeofenceJobSchema.class, "geofencejobschema");
    PATHS.put(TransportationStudentMapping.class, "transportationstudentmapping");

    PROJECTIONS = new HashMap<>();
    PROJECTIONS.put(Announcement.class, Projection.DEFAULT_ANNOUNCEMENT_PROJECTION);
    PROJECTIONS.put(ArchivedNotification.class, Projection.DEFAULT_ARCHIVED_NOTIFICATION_PROJECTION);
    PROJECTIONS.put(Department.class, Projection.DEFAULT_DEPARTMENT_PROJECTION);
    PROJECTIONS.put(Duty.class, Projection.DEFAULT_DUTY_PROJECTION);
    PROJECTIONS.put(DutyType.class, Projection.DEFAULT_DUTY_TYPE_PROJECTION);
    PROJECTIONS.put(Issue.class, Projection.DEFAULT_ISSUE_PROJECTION);
    PROJECTIONS.put(IssueType.class, Projection.DEFAULT_ISSUE_TYPE_PROJECTION);
    PROJECTIONS.put(Message.class, Projection.DEFAULT_MESSAGE_PROJECTION);
    PROJECTIONS.put(Notification.class, Projection.DEFAULT_NOTIFICATION_PROJECTION);
    PROJECTIONS.put(Place.class, Projection.DEFAULT_PLACE_PROJECTION);
    PROJECTIONS.put(PlaceGroup.class, Projection.DEFAULT_PLACE_GROUP_PROJECTION);
    PROJECTIONS.put(Route.class, Projection.DEFAULT_ROUTE_PROJECTION);
    PROJECTIONS.put(RouteGroup.class, Projection.DEFAULT_ROUTE_GROUP_PROJECTION);
    PROJECTIONS.put(User.class, Projection.DEFAULT_USER_PROJECTION);
    PROJECTIONS.put(Vehicle.class, Projection.DEFAULT_VEHICLE_PROJECTION);
    PROJECTIONS.put(VehicleTracking.class, Projection.DEFAULT_VEHICLE_TRACKING_PROJECTION);
    PROJECTIONS.put(VelocityViolation.class, Projection.DEFAULT_VELOCITY_VIOLATION_PROJECTION);
    PROJECTIONS.put(Checkpoint.class, Projection.DEFAULT_CHECKPOINT_PROJECTION);
    PROJECTIONS.put(RegionAlarm.class, Projection.DEFAULT_REGION_ALARM_PROJECTION);
    PROJECTIONS.put(RegionAlarmActivity.class, Projection.DEFAULT_REGION_ALARM_ACTIVITY_PROJECTION);
    PROJECTIONS.put(MonitoringPermission.class, Projection.DEFAULT_MONITORING_PERMISSION_PROJECTION);
    PROJECTIONS.put(GeographicZone.class, Projection.DEFAULT_GEOGRAPHIC_ZONE_PROJECTION);
    PROJECTIONS.put(GeographicZoneAlarm.class, Projection.DEFAULT_GEOGRAPHIC_ZONE_ALARM_PROJECTION);
    PROJECTIONS.put(GeographicZoneAlarmActivity.class, Projection.DEFAULT_GEOGRAPHIC_ZONE_ALARM_ACTIVITY_PROJECTION);
    PROJECTIONS.put(SpeedAlarm.class, Projection.SPEED_ALARM_PROJECTION);
    PROJECTIONS.put(SpeedAlarmActivity.class, Projection.SPEED_ALARM_ACTIVITY_PROJECTION);
    PROJECTIONS.put(Activity.class, Projection.DEFAULT_ACTIVITY_PROJECTION);
    PROJECTIONS.put(Accident.class, Projection.DEFAULT_ACCIDENT_PROJECTION);
    PROJECTIONS.put(BalataMaintenance.class, Projection.DEFAULT_BALATA_MAINTENANCE_PROJECTION);
    PROJECTIONS.put(CarWashing.class, Projection.DEFAULT_CAR_WASHING_PROJECTION);
    PROJECTIONS.put(EngineMaintenance.class, Projection.DEFAULT_ENGINE_MAINTENANCE_PROJECTION);
    PROJECTIONS.put(FuelTrack.class, Projection.DEFAULT_FUEL_TRACKING_PROJECTION);
    PROJECTIONS.put(GasStation.class, Projection.DEFAULT_GAS_STATION_PROJECTION);
    PROJECTIONS.put(InspectionReport.class, Projection.DEFAULT_INSPECTION_REPORT_PROJECTION);
    PROJECTIONS.put(InsurancePolicy.class, Projection.DEFAULT_INSURANCE_POLICY_PROJECTION);
    PROJECTIONS.put(MtvReport.class, Projection.DEFAULT_MTV_REPORT_PROJECTION);
    PROJECTIONS.put(OdyCertificate.class, Projection.DEFAULT_ODY_CERTIFICATE_PROJECTION);
    PROJECTIONS.put(Reminder.class, Projection.DEFAULT_REMINDER_PROJECTION);
    PROJECTIONS.put(SrcCertificate.class, Projection.DEFAULT_SRC_CERTIFICATE_PROJECTION);
    PROJECTIONS.put(TireMaintenance.class, Projection.DEFAULT_TIRE_MAINTENANCE_PROJECTION);
    PROJECTIONS.put(TrafficFine.class, Projection.DEFAULT_TRAFFIC_FINE_PROJECTION);
    PROJECTIONS.put(PsychotechnicsCertificate.class, Projection.DEFAULT_PSYCHOTECHNICS_CERTIFICATE_PROJECTION);
    PROJECTIONS.put(Outgoing.class, Projection.DEFAULT_OUTGOING_PROJECTION);
    PROJECTIONS.put(SeatInsurance.class, Projection.DEFAULT_SEAT_INSURANCE_PROJECTION);
    PROJECTIONS.put(ExhaustInspection.class, Projection.DEFAULT_EXHAUST_INSPECTION_PROJECTION);
    PROJECTIONS.put(Student.class, Projection.DEFAULT_STUDENT_PROJECTION);
    PROJECTIONS.put(School.class, Projection.DEFAULT_SCHOOL_PROJECTION);
    PROJECTIONS.put(Transportation.class, Projection.DEFAULT_TRANSPORTATION_PROJECTION);
    PROJECTIONS.put(TransportationSchema.class, Projection.DEFAULT_TRANSPORTATION_SCHEMA_PROJECTION);
    PROJECTIONS.put(Absence.class, Projection.DEFAULT_ABSENCE_PROJECTION);
    PROJECTIONS.put(ParentNotification.class, Projection.DEFAULT_PARENT_NOTIFICATION_PROJECTION);
    PROJECTIONS.put(ParentArchivedNotification.class, Projection.DEFAULT_PARENT_ARCHIVED_NOTIFICATION_PROJECTION);
    PROJECTIONS.put(TransportationMapping.class, Projection.DEFAULT_TRANSPORTATION_MAPPING_PROJECTION);
    PROJECTIONS.put(GeofenceZone.class, Projection.DEFAULT_GEOFENCE_ZONE_PROJECTION);
    PROJECTIONS.put(GeofenceRoute.class, Projection.DEFAULT_GEOFENCE_ROUTE_PROJECTION);
    PROJECTIONS.put(Geofence.class, Projection.DEFAULT_GEOFENCE_PROJECTION);
    PROJECTIONS.put(GeofenceActivity.class, Projection.DEFAULT_GEOFENCE_ACTIVITY_PROJECTION);
    PROJECTIONS.put(GeofenceJob.class, Projection.DEFAULT_GEOFENCE_JOB_PROJECTION);
    PROJECTIONS.put(CurrentLocation.class, Projection.DEFAULT_CURRENT_LOCATION_PROJECTION);
    PROJECTIONS.put(DeviceMapping.class, Projection.DEFAULT_DEVICE_MAPPING_PROJECTION);
    PROJECTIONS.put(GeofenceJobSchema.class, Projection.DEFAULT_GEOFENCE_JOB_SCHEMA_PROJECTION);
    PROJECTIONS.put(TransportationStudentMapping.class, Projection.DEFAULT_TRANSPORTATION_STUDENT_MAPPING_PROJECTION);
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
      proj = PROJECTIONS.get(classType);
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
    String path = PATHS.get(classType);

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
   * @return
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
    Namespace namespace = createNamespace(PATHS.get(classType));

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
    Namespace namespace = createNamespace(PATHS.get(tClass));

    Request.Builder builder = createRequestBuilder(namespace);
    builder.post(RequestBody.create(mediaType, entity));
    okhttp3.Request request = builder.build();

    ResponseEntity<String> responseEntity = execute(request);

    return ResponseEntity.of(responseEntity.getHeaders(), responseEntity.getStatus());
  }

  public <T extends Model> ResponseEntity<T> update(Class<T> tClass, Object id, String entity, MediaType mediaType) {
    Namespace namespace = createNamespace(PATHS.get(tClass));
    namespace.add(id);

    Request.Builder builder = createRequestBuilder(namespace);
    builder.patch(RequestBody.create(mediaType, entity));
    okhttp3.Request request = builder.build();

    ResponseEntity<String> responseEntity = execute(request);

    return ResponseEntity.of(responseEntity.getHeaders(), responseEntity.getStatus());
  }

  public <T extends Model> ResponseEntity<T> replace(Class<T> tClass, Object id, String entity, MediaType mediaType) {
    Namespace namespace = createNamespace(PATHS.get(tClass));
    namespace.add(id);

    Request.Builder builder = createRequestBuilder(namespace);
    builder.put(RequestBody.create(mediaType, entity));
    okhttp3.Request request = builder.build();

    ResponseEntity<String> responseEntity = execute(request);

    return ResponseEntity.of(responseEntity.getHeaders(), responseEntity.getStatus());
  }

  public <T extends Model> ResponseEntity<T> delete(Class<T> tClass, Object id) {
    Namespace namespace = createNamespace(PATHS.get(tClass));
    namespace.add(id);

    Request.Builder builder = createRequestBuilder(namespace);
    builder.delete();
    okhttp3.Request request = builder.build();

    ResponseEntity<String> responseEntity = execute(request);

    return ResponseEntity.of(responseEntity.getHeaders(), responseEntity.getStatus());
  }

  private <T> ResponseEntity<String> search(Class<T> tClass, String query, RequestParameters parameters, Projection projection) {
    Namespace namespace = createNamespace(PATHS.get(tClass));
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
   * @return
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

  public <T> ResponseEntity<T> searchGet(Class<T> tClass, String query, RequestParameters parameters, Projection projection) {
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
