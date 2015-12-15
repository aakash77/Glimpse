package glimpse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.group4.glimpse.dao.ProjectDAO;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.service.ProjectService;
import com.group4.glimpse.service.impl.ProjectServiceImpl;


public class ServiceTest {
	
	
	@Autowired
	ProjectService projectService;
	
@Before	
public void setUp() {
	
	
}
@Test
public void testCase() {
	
	ProjectServiceImpl test = new ProjectServiceImpl();
	Project projecttest = projectService.read(1);
	assertTrue(projecttest.getTitle() != null);
}
	
}
