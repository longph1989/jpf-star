package star.examples.aatree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import gov.nasa.jpf.util.test.TestJPF;
import star.data.DataNode;
import star.data.DataNodeLexer;
import star.data.DataNodeMap;
import star.data.DataNodeParser;
import star.precondition.Precondition;
import star.precondition.PreconditionLexer;
import star.precondition.PreconditionMap;
import star.precondition.PreconditionParser;
import star.predicate.InductivePred;
import star.predicate.InductivePredLexer;
import star.predicate.InductivePredMap;
import star.predicate.InductivePredParser;

@SuppressWarnings("deprecation")
public class AATree_findMaxTest extends TestJPF {
	
	private void initDataNode() {
		String data = "data AANode {int element; AANode left; AANode right; int level}";
		
		ANTLRInputStream in = new ANTLRInputStream(data);
		DataNodeLexer lexer = new DataNodeLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DataNodeParser parser = new DataNodeParser(tokens);
		
        DataNode[] dns = parser.datas().dns;
        DataNodeMap.put(dns);
	}
	
	private void initPredicate() {
		String pred1 = "pred aat(root,nnull) == nnull::AANode<a,b,c,d> & root=nnull & a=0 & d=0 & b=nnull & c=nnull || " +
				"root::AANode<element,left,right,level> * nnull::AANode<a,b,c,d> * aat1(left,minE,element,level1,nnull) * aat0(right,element,maxE,level,nnull) & level=level1+1 & a=0 & d=0 & b=nnull & c=nnull || " +
				"root::AANode<element,left,right,level> * nnull::AANode<a,b,c,d> * aat1(left,minE,element,level1,nnull) * aat1(right,element,maxE,level1,nnull) & level=level1+1 & a=0 & d=0 & b=nnull & c=nnull";
			
			String pred2 = "pred aat1(root,minE,maxE,level,nnull) == root=nnull & level=0 || " +
				"root::AANode<element,left,right,level> * aat1(left,minE,element,level1,nnull) * aat0(right,element,maxE,level,nnull) & minE<element & element<maxE & level=level1+1 || " +
				"root::AANode<element,left,right,level> * aat1(left,minE,element,level1,nnull) * aat1(right,element,maxE,level1,nnull) & minE<element & element<maxE & level=level1+1";
			
			String pred3 = "pred aat0(root,minE,maxE,level,nnull) == root=nnull & level=0 || " +
					"root::AANode<element,left,right,level> * aat1(left,minE,element,level1,nnull) * aat1(right,element,maxE,level1,nnull) & minE<element & element<maxE & level=level1+1";
			
			String pred = pred1 + ";" + pred2 + ";" + pred3;
		
		ANTLRInputStream in = new ANTLRInputStream(pred);
		InductivePredLexer lexer = new InductivePredLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InductivePredParser parser = new InductivePredParser(tokens);
        
        InductivePred[] ips = parser.preds().ips;
        InductivePredMap.put(ips);
	}
	
	private void initPrecondition() {
		String pre = "pre findMax == aat(this_root, this_nullNode)";
		
		ANTLRInputStream in = new ANTLRInputStream(pre);
		PreconditionLexer lexer = new PreconditionLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PreconditionParser parser = new PreconditionParser(tokens);
        
        Precondition[] ps = parser.pres().ps;
        PreconditionMap.put(ps);
	}
	
	@Before
	public void init() {
		initDataNode();
		initPredicate();
		initPrecondition();
	}
	
	@Test
	public void testMain() {
		long begin = System.currentTimeMillis();
		
		if (verifyNoPropertyViolation(
				"+listener=.star.StarListener",
				"+star.max_depth=3",
//				"+star.min_int=-100",
//				"+star.max_int=100",
				"+star.test_path=/Users/HongLongPham/Workspace/JPF_HOME/jpf-star/src/examples/gov/nasa/jpf/star/examples/aatree",
				"+star.test_package=gov.nasa.jpf.star.examples.aatree",
				"+star.test_imports=gov.nasa.jpf.star.examples.aatree.AATree.AANode;gov.nasa.jpf.star.examples.Utilities",
				"+classpath=build/examples", 
				"+sourcepath=src/examples",
				"+symbolic.method=gov.nasa.jpf.star.examples.aatree.AATree.findMax()",
				"+symbolic.fields=instance",
				"+symbolic.lazy=true")) {
			AATree tree = new AATree();
			tree.findMax();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}

}
