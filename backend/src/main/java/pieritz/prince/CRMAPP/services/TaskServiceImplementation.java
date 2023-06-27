package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pieritz.prince.CRMAPP.domain.Task;
import pieritz.prince.CRMAPP.dto.TaskMapper;
import pieritz.prince.CRMAPP.dto.TaskRequest;
import pieritz.prince.CRMAPP.dto.TaskResponse;
import pieritz.prince.CRMAPP.exceptions.TaskNotFoundException;
import pieritz.prince.CRMAPP.repositories.TaskRepository;
import pieritz.prince.CRMAPP.services.interfaces.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper = new TaskMapper();

    @Override
    public TaskResponse createTask(TaskRequest request) {
        Task task = taskMapper.toTask(request);
        Task createdTask = taskRepository.save(task);
        return taskMapper.toTaskResponse(createdTask);
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        return taskMapper.toTaskResponse(task);
    }

    @Override
    public Page<TaskResponse> getAllTasks(Pageable pageable) {
        Page<Task> tasks = taskRepository.findAll(pageable);
        List<TaskResponse> taskResponses = tasks.getContent().stream()
                .map(taskMapper::toTaskResponse)
                .toList();
        return new PageImpl<>(taskResponses, pageable, tasks.getTotalElements());
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        taskMapper.updateTaskFromRequest(request, task);
        Task updatedTask = taskRepository.save(task);
        return taskMapper.toTaskResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        taskRepository.delete(task);
    }

    @Override
    public Page<TaskResponse> getTasksByContactId(Long contactId, Pageable pageable) {
        Page<Task> tasks = taskRepository.findByKontaktId(contactId, pageable);
        return tasks.map(taskMapper::toTaskResponse);
    }

    @Override
    public long countByArt(String art) {
        return taskRepository.countByArt(art);
    }

    @Override
    public Page<TaskResponse> getTasksByDescription(String description, Pageable pageable) {
        Page<Task> tasks = taskRepository.findByBezeichnung(description, pageable);
        return tasks.map(taskMapper::toTaskResponse);
    }
}
