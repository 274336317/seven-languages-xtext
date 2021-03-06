/*
 * generated by Xtext
 */
package org.xtext.builddsl.ui;

import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.xtext.builddsl.ui.internal.BuilddslActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class BuildDSLExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(BuilddslActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		BuilddslActivator activator = BuilddslActivator.getInstance();
		return activator != null ? activator.getInjector(BuilddslActivator.ORG_XTEXT_BUILDDSL_BUILDDSL) : null;
	}

}
