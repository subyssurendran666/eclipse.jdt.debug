package org.eclipse.jdt.internal.debug.ui.actions;

/**********************************************************************
Copyright (c) 2000, 2002 IBM Corp.  All rights reserved.
This file is made available under the terms of the Common Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/cpl-v10.html
**********************************************************************/

import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.jdt.internal.debug.ui.launcher.RuntimeClasspathViewer;
import org.eclipse.jface.dialogs.IDialogSettings;

/**
 * Abstract action that opens a dialog. Contains a prefix for dialog preference
 * settings.
 */
public abstract class OpenDialogAction extends RuntimeClasspathAction {
	
	/**
	 * Attribute name for the last path used to open a file/directory chooser
	 * dialog.
	 */
	protected static final String LAST_PATH_SETTING = "LAST_PATH_SETTING"; //$NON-NLS-1$
	
	/**
	 * Dialog settings prefix/qualifier
	 */
	private String fPrefix = null;

	/**
	 * Constructs an action that opens a dialog.
	 */
	public OpenDialogAction(String label, RuntimeClasspathViewer viewer, String dialogSettingsPrefix) {
		super(label, viewer);
		fPrefix = dialogSettingsPrefix;
	}
	
	/**
	 * Returns the prefix of the identifier used to store dialog settings for
	 * this action.
	 */
	protected String getDialogSettingsPrefix() {
		return fPrefix;
	}
	
	/**
	 * Returns the value of the dialog setting, associated with the given
	 * settingName, resolved by the dialog setting prefix associated with this
	 * action.
	 * 
	 * @param settingName unqualified setting name
	 * @return value or <code>null</code> if none
	 */
	protected String getDialogSetting(String settingName) {
		return getDialogSettings().get(getDialogSettingsPrefix() + "." + settingName); //$NON-NLS-1$
	}
	
	/**
	 * Sets the value of the dialog setting, associated with the given
	 * settingName, resolved by the dialog setting prefix associated with this
	 * action.
	 * 
	 * @param settingName unqualified setting name
	 * @return value or <code>null</code> if none
	 */
	protected void setDialogSetting(String settingName, String value) {
		getDialogSettings().put(getDialogSettingsPrefix() + "." + settingName, value); //$NON-NLS-1$
	}

	/**
	 * Returns this plug-in's dialog settings.
	 * 
	 * @return IDialogSettings
	 */
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = JDIDebugUIPlugin.getDefault().getDialogSettings();
		return settings;
	}	

}
