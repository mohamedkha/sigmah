/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sigmah.offline.handler;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import org.sigmah.offline.dao.ProjectAsyncDAO;
import org.sigmah.offline.dispatch.AsyncCommandHandler;
import org.sigmah.offline.dispatch.OfflineExecutionContext;
import org.sigmah.shared.command.GetProjectById;
import org.sigmah.shared.dto.ProjectDTO;

/**
 *
 * @author Mohamed KHADHRAOUI
 */
public class GetProjectByIdAsyncHandler implements AsyncCommandHandler<GetProjectById, ProjectDTO>{

	@Inject
	private ProjectAsyncDAO projectAsyncDAO;
	
	@Override
	public void execute(GetProjectById command, OfflineExecutionContext executionContext, AsyncCallback<ProjectDTO> callback) {
		projectAsyncDAO.get(command.getProjectId(), callback);
	}
	
}
