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
package org.netfleet.api.commons.servis;

import org.netfleet.api.model.servis.Student;

import java.io.Serializable;
import java.util.*;

/**
 * @author M.Çağrı TEPEBAŞILI - cagritepebasili [at] protonmail [dot] com
 * @version 1.0.0-RELEASE
 * @since 1.0.0-RELEASE
 */
public class StudentList implements Serializable {

  private List<Student> students;

  public StudentList() {
    this(null);
  }

  public StudentList(List<Student> locations) {
    this.students = locations;
  }

  public static StudentList of(Collection<Student> locations) {
    if (locations == null)
      return new StudentList();
    else
      return new StudentList(new ArrayList<>(locations));
  }

  public boolean addStudent(Student student) {
    if (students == null)
      students = new ArrayList<>();

    return students.add(student);
  }

  public boolean removeStudent(Student student) {
    if (students == null)
      return false;

    return students.remove(student);
  }

  public boolean containsStudent(Student student) {
    if (students == null)
      return false;

    return students.contains(student);
  }

  public Iterator<Student> iterator() {
    if (students == null)
      return Collections.emptyIterator();

    return students.iterator();
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public List<Student> getStudents() {
    return students;
  }

}
