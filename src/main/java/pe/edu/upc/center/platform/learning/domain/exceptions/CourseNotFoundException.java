package pe.edu.upc.center.platform.learning.domain.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException(Long aLong) {
    super("Course with id " + aLong + " not found");
  }
}
