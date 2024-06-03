package pe.edu.upc.center.platform.learning.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentPerformanceMetricSet;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentRecordId;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.ProfileId;
import pe.edu.upc.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * Represents a student.
 * The student is an aggregate root.
 */
@Entity
public class Student extends AuditableAbstractAggregateRoot<Student> {

  @Getter
  @Embedded
  @Column(name = "student_id")
  private final StudentRecordId studentRecordId;

  @Embedded
  private ProfileId profileId;

  @Embedded
  private StudentPerformanceMetricSet performanceMetricSet;

  public Student() {
    this.studentRecordId = new StudentRecordId();
    this.performanceMetricSet = new StudentPerformanceMetricSet();
  }

  public Student(Long profileId) {
    this();
    this.profileId = new ProfileId(profileId);
  }

  public Student(ProfileId profileId) {
    this();
    this.profileId = profileId;
  }

  /**
   * Updates the student metrics when a course is completed.
   * It increments the total completed courses.
   *
   */
  public void updateMetricsOnCourseCompleted() {
    this.performanceMetricSet = this.performanceMetricSet.incrementTotalCompletedCourses();
  }

  /**
   * Updates the student metrics when a tutorial is completed.
   * It increments the total completed tutorials.
   *
   */
  public void updateMetricsOnTutorialCompleted() {
    this.performanceMetricSet = this.performanceMetricSet.incrementTotalTutorials();
  }

  public String getStudentId() {
    return this.studentRecordId.studentId();
  }

  public Long getProfileId() {
    return this.profileId.profileId();
  }

  public Integer getTotalCompletedCourses() {
    return this.performanceMetricSet.totalCompletedCourses();
  }

  public Integer getTotalTutorials() {
    return this.performanceMetricSet.totalTutorials();
  }
}
