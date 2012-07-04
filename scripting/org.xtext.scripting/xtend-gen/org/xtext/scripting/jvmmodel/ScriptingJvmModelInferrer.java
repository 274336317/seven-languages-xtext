package org.xtext.scripting.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.scripting.scripting.Script;

/**
 * Infers a Java class with a main method from a {@link Script}.
 */
@SuppressWarnings("all")
public class ScriptingJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  protected void _infer(final Script application, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    String _name = application.getName();
    JvmGenericType _class = this._jvmTypesBuilder.toClass(application, _name);
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          EList<JvmMember> _members = it.getMembers();
          JvmTypeReference _newTypeRef = ScriptingJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(application, Void.TYPE);
          final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
              public void apply(final JvmOperation it) {
                it.setVarArgs(true);
                EList<JvmFormalParameter> _parameters = it.getParameters();
                JvmTypeReference _newTypeRef = ScriptingJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(application, String.class);
                JvmTypeReference _addArrayTypeDimension = ScriptingJvmModelInferrer.this._jvmTypesBuilder.addArrayTypeDimension(_newTypeRef);
                JvmFormalParameter _parameter = ScriptingJvmModelInferrer.this._jvmTypesBuilder.toParameter(application, "args", _addArrayTypeDimension);
                ScriptingJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
                it.setStatic(true);
                XBlockExpression _main = application.getMain();
                ScriptingJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _main);
              }
            };
          JvmOperation _method = ScriptingJvmModelInferrer.this._jvmTypesBuilder.toMethod(application, "main", _newTypeRef, _function);
          ScriptingJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
        }
      };
    _accept.initializeLater(_function);
  }
  
  public void infer(final EObject application, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (application instanceof Script) {
      _infer((Script)application, acceptor, isPreIndexingPhase);
      return;
    } else if (application != null) {
      _infer(application, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(application, acceptor, isPreIndexingPhase).toString());
    }
  }
}
