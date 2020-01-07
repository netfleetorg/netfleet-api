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

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public enum Projection {

  NONE(""),
  DEFAULT_ANNOUNCEMENT_PROJECTION("defaultAnnouncementProjection"),
  DEFAULT_ARCHIVED_NOTIFICATION_PROJECTION("defaultArchivedNotificationProjection"),
  DEFAULT_DEPARTMENT_PROJECTION("defaultDepartmentProjection"),
  DEFAULT_DUTY_PROJECTION("defaultDutyProjection"),
  DEFAULT_DUTY_TYPE_PROJECTION("defaultDutyTypeProjection"),
  DEFAULT_ISSUE_PROJECTION("defaultIssueProjection"),
  DEFAULT_ISSUE_TYPE_PROJECTION("defaultIssueTypeProjection"),
  DEFAULT_MESSAGE_PROJECTION("defaultMessageProjection"),
  DEFAULT_NOTIFICATION_PROJECTION("defaultNotificationProjection"),
  DEFAULT_PLACE_PROJECTION("defaultPlaceProjection"),
  DEFAULT_PLACE_GROUP_PROJECTION("defaultPlaceGroupProjection"),
  DEFAULT_ROUTE_PROJECTION("defaultRouteProjection"),
  DEFAULT_ROUTE_GROUP_PROJECTION("defaultRouteGroupProjection"),
  DEFAULT_USER_PROJECTION("defaultUserProjection"),
  DEFAULT_VEHICLE_PROJECTION("defaultVehicleProjection"),
  DEFAULT_VEHICLE_TRACKING_PROJECTION("defaultVehicleTrackingProjection"),
  LIGHTWEIGHT_VEHICLE_TRACKING_PROJECTION("lightweightVehicleTrackingProjection"),
  DEFAULT_VELOCITY_VIOLATION_PROJECTION("defaultVelocityViolationProjection"),
  DEFAULT_ACTIVITY_PROJECTION("defaultActivityProjection"),
  DEFAULT_CHECKPOINT_PROJECTION("defaultCheckpointProjection"),
  DEFAULT_REGION_ALARM_PROJECTION("defaultRegionAlarmProjection"),
  DEFAULT_REGION_ALARM_ACTIVITY_PROJECTION("defaultRegionAlarmActivityProjection"),
  DEFAULT_MONITORING_PERMISSION_PROJECTION("defaultMonitoringPermissionProjection"),
  DEFAULT_GEOGRAPHIC_ZONE_PROJECTION("defaultGeographicZoneProjection"),
  DEFAULT_GEOGRAPHIC_ZONE_ALARM_PROJECTION("defaultGeographicZoneAlarmProjection"),
  DEFAULT_GEOGRAPHIC_ZONE_ALARM_ACTIVITY_PROJECTION("defaultGeographicZoneAlarmActivityProjection"),
  SPEED_ALARM_PROJECTION("defaultSpeedAlarmProjection"),
  SPEED_ALARM_ACTIVITY_PROJECTION("defaultSpeedAlarmActivityProjection"),
  DEFAULT_ACCIDENT_PROJECTION("defaultAccidentProjection"),
  DEFAULT_BALATA_MAINTENANCE_PROJECTION("defaultBalataMaintenanceProjection"),
  DEFAULT_CAR_WASHING_PROJECTION("defaultCarWashingProjection"),
  DEFAULT_ENGINE_MAINTENANCE_PROJECTION("defaultEngineMaintenanceProjection"),
  DEFAULT_FUEL_TRACKING_PROJECTION("defaultFuelTrackingProjection"),
  DEFAULT_GAS_STATION_PROJECTION("defaultGasStationProjection"),
  DEFAULT_INSPECTION_REPORT_PROJECTION("defaultInspectionReportProjection"),
  DEFAULT_INSURANCE_POLICY_PROJECTION("defaultInsurancePolicyProjection"),
  DEFAULT_MTV_REPORT_PROJECTION("defaultMtvReportProjection"),
  DEFAULT_ODY_CERTIFICATE_PROJECTION("defaultOdyCertificateProjection"),
  DEFAULT_REMINDER_PROJECTION("defaultReminderProjection"),
  DEFAULT_SRC_CERTIFICATE_PROJECTION("defaultSrcCertificateProjection"),
  DEFAULT_TIRE_MAINTENANCE_PROJECTION("defaultTireMaintenanceProjection"),
  DEFAULT_TRAFFIC_FINE_PROJECTION("defaultTrafficFineProjection"),
  DEFAULT_PSYCHOTECHNICS_CERTIFICATE_PROJECTION("defaultPsychotechnicsCertificateProjection"),
  DEFAULT_SEAT_INSURANCE_PROJECTION("defaultSeatInsuranceProjection"),
  DEFAULT_OUTGOING_PROJECTION("defaultOutgoingProjection"),
  DEFAULT_EXHAUST_INSPECTION_PROJECTION("defaultExhaustInspectionProjection"),
  DEFAULT_STUDENT_PROJECTION("defaultStudentProjection"),
  DEFAULT_SCHOOL_PROJECTION("defaultSchoolProjection"),
  DEFAULT_TRANSPORTATION_PROJECTION("defaultTransportationProjection"),
  DEFAULT_TRANSPORTATION_SCHEMA_PROJECTION("defaultTransportationSchemaProjection"),
  DEFAULT_ABSENCE_PROJECTION("defaultAbsenceProjection"),
  DEFAULT_PARENT_NOTIFICATION_PROJECTION("defaultParentNotificationProjection"),
  DEFAULT_PARENT_ARCHIVED_NOTIFICATION_PROJECTION("defaultParentArchivedNotificationProjection"),
  DEFAULT_TRANSPORTATION_MAPPING_PROJECTION("defaultTransportationMappingProjection"),
  DEFAULT_TRANSPORTATION_STUDENT_MAPPING_PROJECTION("defaultTransportationStudentMappingProjection"),

  DEFAULT_DEVICE_MAPPING_PROJECTION("defaultDeviceMappingProjection"),
  DEFAULT_CURRENT_LOCATION_PROJECTION("defaultCurrentLocationProjection"),
  DEFAULT_GEOFENCE_JOB_PROJECTION("defaultGeofenceJobProjection"),
  DEFAULT_GEOFENCE_PROJECTION("defaultGeofenceProjection"),
  DEFAULT_GEOFENCE_ACTIVITY_PROJECTION("defaultGeofenceActivityProjection"),
  DEFAULT_GEOFENCE_ROUTE_PROJECTION("defaultGeofenceRouteProjection"),
  DEFAULT_GEOFENCE_ZONE_PROJECTION("defaultGeofenceZoneProjection"),
  LIGHTWEIGHT_GEOFENCE_JOB_PROJECTION("lightweightGeofenceJobProjection"),
  DEFAULT_GEOFENCE_JOB_SCHEMA_PROJECTION("defaultGeofenceJobSchemaProjection");

  public static String PARAMETER = "projection";
  private final String value;

  Projection(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return super.toString();
  }

}
