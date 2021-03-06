package star.formula.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import star.formula.Utilities;
import star.formula.Variable;

public class VariableExpression extends Expression {
	
	private Variable var;
	
	public VariableExpression(Variable var) {
		this.var = var;
	}
	
	public Variable getVar() {
		return var;
	}
	
	public List<Variable> getVars() {
		List<Variable> vars = new ArrayList<Variable>();
		vars.add(var);
		
		return vars;
	}
	
	@Override
	public Expression substitute(Variable[] fromVars, Variable[] toVars,
			Map<String,String> existVarSubMap) {
		Variable oldVar = var;
		
		int index = Utilities.find(fromVars, oldVar);
		
		Variable newVar = null;
		
		if (index != -1) {
			newVar = new Variable(toVars[index]);
		} else if (existVarSubMap == null) {
			newVar = oldVar;
		} else {
			if (existVarSubMap.containsKey(oldVar.getName())) {
				newVar = new Variable(existVarSubMap.get(oldVar.getName()), oldVar.getType());
			} else {
				Variable freshVar = Utilities.freshVar(oldVar);
				existVarSubMap.put(oldVar.getName(), freshVar.getName());
				newVar = new Variable(freshVar);
			}
		}
		
		VariableExpression newExpr = new VariableExpression(newVar);
		return newExpr;
	}
	
	@Override
	public void updateType(List<Variable> knownTypeVars) {
		for (Variable v : knownTypeVars) {
			if (v.equals(var)) {
				var.setType(v.getType());
				break;
			}
		}
	}

	@Override
	public String toString() {
		return var.toString();
	}
	
}
