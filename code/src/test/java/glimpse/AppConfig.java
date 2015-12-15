package glimpse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.group4.glimpse.dao.ProjectDAO;
import com.group4.glimpse.dao.impl.ProjectDAOImpl;
import com.group4.glimpse.service.ProjectService;
import com.group4.glimpse.service.ProjectStateService;
import com.group4.glimpse.service.impl.ProjectServiceImpl;
import com.group4.glimpse.service.impl.ProjectStateServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public ProjectService getProjectService() {
		return new ProjectServiceImpl();
	}
	
	@Bean
	public ProjectDAO getProjectDAO() {
		return new ProjectDAOImpl();
	}
	
	@Bean
	public ProjectStateService getProjectStateService() {
		return new ProjectStateServiceImpl();
	}
	
}

