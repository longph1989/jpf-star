package star.formula.heap;

import java.util.List;
import java.util.Map;

import gov.nasa.jpf.vm.FieldInfo;
import star.formula.Variable;

public abstract class HeapTerm {
	
	public HeapTerm substitute(Variable[] fromVars, Variable[] toVars,
			Map<String,String> existVarSubMap) {
		return null;
	}
	
	public Variable[] getVars() {
		return null;
	}
	
	public HeapTerm copy() {
		return this;
	}
	
	public void updateType(List<Variable> knownTypeVars) {
		return;
	}
	
	public void genConcreteVars(List<Variable> initVars, StringBuffer test, String objName, String clsName,
			FieldInfo[] insFields, FieldInfo[] staFields) {
		return;
	}
	
	public void setFields(StringBuffer test, String objName, String clsName,
			FieldInfo[] insFields, FieldInfo[] staFields) {
		return;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	public String toS2SATString() {
		return "";
	}

}
