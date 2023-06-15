package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pieritz.prince.CRMAPP.domain.Task;
import pieritz.prince.CRMAPP.dto.TaskRequest;
import pieritz.prince.CRMAPP.dto.TaskResponse;
import pieritz.prince.CRMAPP.repositories.TaskRepository;
import pieritz.prince.CRMAPP.services.interfaces.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskResponse createTask(TaskRequest request) {
        Task task = toTask(request);
        Task createdTask = taskRepository.save(task);
        return toTaskResponse(createdTask);
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return toTaskResponse(task);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(this::toTaskResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        updateTaskFromRequest(request, task);
        Task updatedTask = taskRepository.save(task);
        return toTaskResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }

    private TaskResponse toTaskResponse(Task task) {
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

    private Task toTask(TaskRequest request) {
        return Task.builder()
                .art(request.getArt())
                .bezeichnung(request.getBezeichnung())
                .kontaktId(request.getKontaktId())
                .startdatum(request.getStartdatum())
                .startzeit(request.getStartzeit())
                .ort(request.getOrt())
                .build();
    }

    private void updateTaskFromRequest(TaskRequest request, Task task) {
        task.setArt(request.getArt());
        task.setBezeichnung(request.getBezeichnung());
        task.setKontaktId(request.getKontaktId());
        task.setStartdatum(request.getStartdatum());
        task.setStartzeit(request.getStartzeit());
        task.setOrt(request.getOrt());
    }
}
