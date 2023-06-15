package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.TaskRequest;
import pieritz.prince.CRMAPP.dto.TaskResponse;
import pieritz.prince.CRMAPP.services.interfaces.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
        logger.info("Received request to create task: {}", request);
        TaskResponse response = taskService.createTask(request);
        logger.info("Created task: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id) {
        logger.info("Received request to get task with ID: {}", id);
        TaskResponse response = taskService.getTaskById(id);
        logger.info("Retrieved task: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        logger.info("Received request to get all tasks");
        List<TaskResponse> responses = taskService.getAllTasks();
        logger.info("Retrieved all tasks: {}", responses);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        logger.info("Received request to update task with ID {}: {}", id, request);
        TaskResponse response = taskService.updateTask(id, request);
        logger.info("Updated task: {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        logger.info("Received request to delete task with ID: {}", id);
        taskService.deleteTask(id);
        logger.info("Task deleted successfully");
        return ResponseEntity.noContent().build();
    }
}
