/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sigmah.shared.command;

import org.sigmah.shared.command.base.AbstractCommand;
import org.sigmah.shared.dto.ProjectDTO;

/**
 *
 * @author Mohamed KHADHRAOUI
 */
public class GetProjectById extends AbstractCommand<ProjectDTO>{
	
	private Integer projectId;

	public GetProjectById(Integer projectId) {
		this.projectId = projectId;
	}
	public GetProjectById() {
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	
	
	
	
}
