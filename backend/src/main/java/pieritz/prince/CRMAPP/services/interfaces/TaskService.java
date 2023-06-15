package pieritz.prince.CRMAPP.services.interfaces;

import pieritz.prince.CRMAPP.dto.TaskRequest;
import pieritz.prince.CRMAPP.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    TaskResponse createTask(TaskRequest request);
    TaskResponse getTaskById(Long id);
    List<TaskResponse> getAllTasks();
    TaskResponse updateTask(Long id, TaskRequest request);
    void deleteTask(Long id);
}
