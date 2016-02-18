/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sigmah.client.ui.view.formation;

import com.extjs.gxt.ui.client.widget.form.Field;
import org.sigmah.client.i18n.I18N;
import org.sigmah.client.ui.presenter.formation.FormationPresenter;
import org.sigmah.client.ui.view.base.AbstractView;
import org.sigmah.client.ui.widget.button.Button;
import org.sigmah.client.ui.widget.form.FormPanel;
import org.sigmah.client.ui.widget.form.Forms;

/**
 *
 * @author Mohamed KHADHRAOUI
 */
public class FormationView extends AbstractView implements FormationPresenter.View{

	private Field<Number> projectIdField;
		
	private	Button searchButton;
	
	@Override
	public void initialize() {
		projectIdField = Forms.number(I18N.CONSTANTS.formationId(), true);		
		searchButton = Forms.button(I18N.CONSTANTS.formationSearch());
		
		FormPanel panel=Forms.panel();
		
		panel.add(projectIdField);
		panel.addButton(searchButton);
		panel.getElement().getStyle().setBackgroundColor("#FFFFFF");
		
		add(panel);
	}

	@Override
	public Field<Number> getProjectIdField() {
		return projectIdField;
		
	}

	@Override
	public Button getSearchButton() {
		return searchButton;
		
	}
	
	
	
}
