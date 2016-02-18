/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sigmah.server.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.sigmah.server.dao.ProjectDAO;
import org.sigmah.server.dispatch.impl.UserDispatch;
import org.sigmah.server.domain.Project;
import org.sigmah.server.handler.base.AbstractCommandHandler;
import org.sigmah.shared.command.GetProjectById;
import org.sigmah.shared.dispatch.CommandException;
import org.sigmah.shared.dto.ProjectDTO;

/**
 *
 * @author Mohamed KHADHRAOUI
 */
@Singleton
public class GetProjectByIdHandler extends AbstractCommandHandler<GetProjectById, ProjectDTO> {

	@Inject
	private ProjectDAO projectDAO;
	
	@Override
	protected ProjectDTO execute(GetProjectById command, UserDispatch.UserExecutionContext context) throws CommandException {
		final Project findById = projectDAO.findById(command.getProjectId());
		return mapper().map(findById, new ProjectDTO());
	}
	
}
