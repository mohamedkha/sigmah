/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sigmah.client.ui.presenter.formation;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import org.sigmah.client.dispatch.CommandResultHandler;
import org.sigmah.client.inject.Injector;
import org.sigmah.client.page.Page;
import org.sigmah.client.page.PageRequest;
import org.sigmah.client.ui.notif.N10N;
import org.sigmah.client.ui.presenter.base.AbstractPagePresenter;
import org.sigmah.client.ui.presenter.project.AbstractProjectPresenter;
import org.sigmah.client.ui.view.formation.FormationView;
import org.sigmah.client.ui.widget.button.Button;
import org.sigmah.shared.command.GetProject;
import org.sigmah.shared.command.GetProjectById;
import org.sigmah.shared.dto.ProjectDTO;

/**
 *
 * @author Mohamed KHADHRAOUI
 */

public class FormationPresenter extends AbstractPagePresenter<FormationPresenter.View> {

	@ImplementedBy(FormationView.class)
	public static interface View extends AbstractProjectPresenter.View {
		Field<Number> getProjectIdField();
		
		Button getSearchButton();
	} 
	
	@Inject
	public FormationPresenter(View view, Injector injector) {
		super(view, injector);
	}
	@Override
	public Page getPage() {
		return Page.FORMATION;
	}

	@Override
	public void onPageRequest(PageRequest request) {
		view.getProjectIdField().clear();
	}

	@Override
	public void onBind() {
		super.onBind(); //To change body of generated methods, choose Tools | Templates.
		view.getSearchButton().addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				dispatch.execute(new GetProjectById(view.getProjectIdField().getValue().intValue()), new CommandResultHandler<ProjectDTO>() {
					@Override
					protected void onCommandSuccess(ProjectDTO result) {
						if(result == null){
							N10N.errorNotif("l'objet n'existe pas");
						}else{
							N10N.infoNotif("Info", "<p>"+result.getName()+"</p>");
						}
							
						
					}					
					
				}, view.getSearchButton());
				
			}
		});
	}
	
	
	
}
