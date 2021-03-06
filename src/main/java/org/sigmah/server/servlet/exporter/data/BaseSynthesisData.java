package org.sigmah.server.servlet.exporter.data;

/*
 * #%L
 * Sigmah
 * %%
 * Copyright (C) 2010 - 2016 URD
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import javax.persistence.EntityManager;

import org.sigmah.server.dispatch.CommandHandler;
import org.sigmah.server.domain.OrgUnit;
import org.sigmah.server.domain.Project;
import org.sigmah.server.handler.GetValueHandler;
import org.sigmah.server.servlet.exporter.base.Exporter;
import org.sigmah.shared.command.GetValue;

import com.google.inject.Injector;

/*
 * Base synthesis data for project and org unit synthesis exports
 * @author sherzod
 */
public abstract class BaseSynthesisData extends ExportData {

	protected final EntityManager entityManager;
	private final GlobalExportDataProvider dataProvider;
	private final CommandHandler<GetValue, ?> handler;

	/*
	 * private final Locale locale; private final Translator translator;
	 */
	public BaseSynthesisData(final Exporter exporter, final Injector injector) {
		super(exporter, 3);
		entityManager = injector.getInstance(EntityManager.class);
		dataProvider = injector.getInstance(GlobalExportDataProvider.class);
		handler = injector.getInstance(GetValueHandler.class);
		/*
		 * this.locale = locale; translator = new UIConstantsTranslator(new Locale(""));
		 */
	}

	public GlobalExportDataProvider getDataProvider() {
		return dataProvider;
	}

	public CommandHandler<GetValue, ?> getHandler() {
		return handler;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/*
	 * public Locale getLocale() { return locale; } public Translator getTranslator() { return translator; }
	 */
	public abstract Project getProject();

	public abstract OrgUnit getOrgUnit();

}
