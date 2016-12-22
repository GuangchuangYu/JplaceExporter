import dr.evolution.tree.Tree;
import dr.evolution.tree.NodeRef;
import java.io.Writer;
import java.io.IOException;
import java.io.BufferedReader;

public class JplaceExporter {
    private final Writer writer;

    public JplaceExporter(Writer writer, Tree tree, Placement placement) {
	this.writer = writer;
    }

    public static void toNewick(Tree tree) {
	StringBuilder buffer = new StringBuilder();
	toNewick(tree, tree.getRoot(), buffer);
	buffer.append(';');
	// return buffer.toString();
	System.out.println(buffer.toString());
    }

    public static void toNewick(Tree tree, NodeRef node, StringBuilder buffer) {
	if (tree.isExternal(node)) {
	    String label = tree.getTaxonId(node.getNumber());
	    buffer.append(label);
	    appendLength(tree, node, buffer);
	} else {
	    buffer.append('(');
	    int n = tree.getChildCount(node);
	    for (int i=0; i<n; i++) {
		toNewick(tree, tree.getChild(node, i), buffer);
		if (i == (n-1)) {
		    buffer.append(')');
		} else {
		    buffer.append(',');
		}
	    }
	    NodeRef parentNode = tree.getParent(node);
	    if (parentNode != null) {
		appendLength(tree, node, buffer);
	    }
	}
    }

    private static void appendLength(Tree tree, NodeRef node, StringBuilder buffer) {
	if (tree.hasBranchLengths()) {
	    buffer.append(':');
	    buffer.append(tree.getBranchLength(node));
	}
    }


}


