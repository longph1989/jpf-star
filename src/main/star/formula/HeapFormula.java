package star.formula;

import java.util.List;
import java.util.Map;

import gov.nasa.jpf.vm.FieldInfo;
import star.formula.heap.HeapTerm;

// a heap formula includes multiple heap terms

public class HeapFormula {
	
	// contains array of heap term, empty mean the heap is empty
	private HeapTerm[] heapTerms;
	
	public HeapFormula(HeapTerm... heapTerms) {
		this.heapTerms = heapTerms;
	}
	
	public HeapTerm[] getHeapTerms() {
		return heapTerms;
	}
	
	public HeapFormula substitute(Variable[] fromVars, Variable[] toVars,
			Map<String,String> existVarSubMap) {
		int length = heapTerms.length;
		HeapTerm[] newHeapTerms = new HeapTerm[length];
		
		for (int i = 0; i < length; i++) {
			newHeapTerms[i] = heapTerms[i].substitute(fromVars, toVars, existVarSubMap);
		}
		
		HeapFormula newHeapFormula = new HeapFormula(newHeapTerms);
		
		return newHeapFormula;
	}
	
	public HeapFormula copy() {
		int length = heapTerms.length;
		HeapTerm[] newHeapTerms = new HeapTerm[length];
		
		for (int i = 0; i < length; i++) {
			newHeapTerms[i] = heapTerms[i].copy();
		}
		
		HeapFormula newHeapFormula = new HeapFormula(newHeapTerms);
		return newHeapFormula;
	}
	
	public void addTerm(HeapTerm term) {
		int length = heapTerms.length + 1;
		HeapTerm[] newHeapTerms = new HeapTerm[length];
		
		for (int i = 0; i < length - 1; i++) {
			newHeapTerms[i] = heapTerms[i];
		}
		
		newHeapTerms[length - 1] = term;
		heapTerms = newHeapTerms;
	}
	
	public void updateType(List<Variable> knownTypeVars) {
		int oldLength = knownTypeVars.size();
		
		while (true) {
			int length = heapTerms.length;
			
			for (int i = 0; i < length; i++) {
				heapTerms[i].updateType(knownTypeVars);
			}
			
			int newLength = knownTypeVars.size();
			
			if (newLength == oldLength) break;
			else oldLength = newLength;
		}
	}
	
	public void genConcreteVars(List<Variable> initVars, StringBuffer test, String objName, String clsName,
			FieldInfo[] insFields, FieldInfo[] staFields) {
		int oldLength = initVars.size();
		
		while (true) {
			int length = heapTerms.length;
			
			for (int i = 0; i < length; i++) {
				heapTerms[i].genConcreteVars(initVars, test, objName, clsName, insFields, staFields);
			}
			
			int newLength = initVars.size();
			
			if (newLength == oldLength) break;
			else oldLength = newLength;
		}
	}
	
	public void setFields(StringBuffer test, String objName, String clsName,
			FieldInfo[] insFields, FieldInfo[] staFields) {
		int length = heapTerms.length;
		
		for (int i = 0; i < length; i++) {
			heapTerms[i].setFields(test, objName, clsName, insFields, staFields);
		}
	}
	
	@Override
	public String toString() {
		if (heapTerms.length == 0)
			return "emp";
		else {
			int length = heapTerms.length;
			String ret = "";
			
			for (int i = 0; i < length; i++) {
				ret += heapTerms[i] + " * ";
			}
			
			ret = ret.substring(0, ret.length() - 3);
			
			return ret;
		}
	}
	
	public String toS2SATString() {
		if (heapTerms.length == 0)
			return "emp";
		else {
			int length = heapTerms.length;
			String ret = "";
			
			for (int i = 0; i < length; i++) {
				ret += heapTerms[i].toS2SATString() + " * ";
			}
			
			ret = ret.substring(0, ret.length() - 3);
			
			return ret;
		}
	}

}
