import dr.evolution.tree.Tree;
import java.io.Writer;
import java.io.IOException;
import java.io.BufferedReader;

public class JplaceExporter {
    private final Writer writer;

    public JplaceExporter(Writer writer, Tree tree, Placement placement) {
	this.writer = writer;
    }

    public static String toNewick(Tree tree) {
	String res = "";
	return res;
    }

}


