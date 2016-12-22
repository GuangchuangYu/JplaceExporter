import dr.evolution.io.NewickImporter;
import dr.evolution.tree.Tree;
import java.io.*;

public class TEST {
    public static void main(String[] args) {
	try{
	    FileReader reader = new FileReader("sample.tree");

	    NewickImporter tni = new NewickImporter(reader);
	    Tree tree = tni.importNextTree();

	    System.out.println("Tip count: " + tree.getExternalNodeCount() + "\tInternal count: " + tree.getInternalNodeCount());

	    JplaceExporter.toNewick(tree);
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }

}


