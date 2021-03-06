/*
 * generated by Xtext
 */
package org.xtext.template.ui;

import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.xtext.template.ui.internal.TemplateActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TemplateExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(TemplateActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		TemplateActivator activator = TemplateActivator.getInstance();
		return activator != null ? activator.getInjector(TemplateActivator.ORG_XTEXT_TEMPLATE_TEMPLATE) : null;
	}

}
