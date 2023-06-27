package pieritz.prince.CRMAPP.exceptions;

public class TaskNotFoundException extends RuntimeException {
  public TaskNotFoundException(String taskNotFound) {
    super(taskNotFound);
  }
}
