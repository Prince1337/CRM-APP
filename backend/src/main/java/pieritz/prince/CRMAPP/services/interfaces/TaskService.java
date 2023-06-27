package pieritz.prince.CRMAPP.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pieritz.prince.CRMAPP.dto.TaskRequest;
import pieritz.prince.CRMAPP.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    TaskResponse createTask(TaskRequest request);
    TaskResponse getTaskById(Long id);
    Page<TaskResponse> getAllTasks(Pageable pageable);
    TaskResponse updateTask(Long id, TaskRequest request);
    void deleteTask(Long id);
    Page<TaskResponse> getTasksByContactId(Long contactId, Pageable pageable);
    long countByArt(String art);
    Page<TaskResponse> getTasksByDescription(String description, Pageable pageable);

}
