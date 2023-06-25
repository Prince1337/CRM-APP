package pieritz.prince.CRMAPP;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableCaching
@EnableAsync
public class CrmAppApplication implements AsyncConfigurer, SchedulingConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CrmAppApplication.class, args);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler thPoolTaskScheduler = new ThreadPoolTaskScheduler();
		thPoolTaskScheduler.setPoolSize(10);
		thPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
		thPoolTaskScheduler.initialize();
		taskRegistrar.setTaskScheduler(thPoolTaskScheduler);
	}

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setThreadNamePrefix("CustomExecutor-");
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}
}
