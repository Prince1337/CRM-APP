package pieritz.prince.CRMAPP.dto;

import pieritz.prince.CRMAPP.domain.Task;

public class TaskMapper {
  public TaskMapper() {
  }

  public TaskResponse toTaskResponse(Task task) {
    return TaskResponse.builder()
        .id(task.getId())
        .art(task.getArt())
        .bezeichnung(task.getBezeichnung())
        .kontaktId(task.getKontaktId())
        .startdatum(task.getStartdatum())
        .startzeit(task.getStartzeit())
        .ort(task.getOrt())
        .build();
  }

  public Task toTask(TaskRequest request) {
    return Task.builder()
        .art(request.getArt())
        .bezeichnung(request.getBezeichnung())
        .kontaktId(request.getKontaktId())
        .startdatum(request.getStartdatum())
        .startzeit(request.getStartzeit())
        .ort(request.getOrt())
        .build();
  }

  public void updateTaskFromRequest(TaskRequest request, Task task) {
    task.setArt(request.getArt());
    task.setBezeichnung(request.getBezeichnung());
    task.setKontaktId(request.getKontaktId());
    task.setStartdatum(request.getStartdatum());
    task.setStartzeit(request.getStartzeit());
    task.setOrt(request.getOrt());
  }
}