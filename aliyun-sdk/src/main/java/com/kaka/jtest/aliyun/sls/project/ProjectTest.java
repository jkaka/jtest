package com.kaka.jtest.aliyun.sls.project;

import com.aliyun.openservices.log.common.Project;
import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.response.CreateProjectResponse;
import com.aliyun.openservices.log.response.ListProjectResponse;
import com.kaka.jtest.aliyun.sls.SlsBaseTest;
import org.junit.Test;

import java.util.List;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 16:42
 */
public class ProjectTest extends SlsBaseTest {

	@Test
	public void projectList() throws LogException {
		ListProjectResponse listProjectResponse = cdClient.ListProject();
		List<Project> projects = listProjectResponse.getProjects();
		System.out.println("project size :" + projects.size());
		for (Project project : projects) {
			System.out.println(project.getProjectName());
		}
	}

	/**
	 * project  全局唯一
	 *
	 * @throws LogException
	 */
	@Test
	public void createProject() throws LogException {
		CreateProjectResponse createProjectResponse = cdClient.CreateProject("sls-jsk-cd", "create project by sdk.");
		System.out.println(createProjectResponse.GetAllHeaders());
	}
}
