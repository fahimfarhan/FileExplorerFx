package applicationsfx;

import javafx.scene.control.TreeItem;

import java.io.File;
import java.util.Comparator;

/**
 * Created by Fahim on 5/2/2017.
 */
public class FileComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        FileExplorerFx ob = new ClassTreeView();
        TreeItem<String> i1 = (TreeItem<String>)o1;
        TreeItem<String> i2 = (TreeItem<String>)o2;

        File f1, f2; f1 = new File(ob.FindAbsolutePath(i1,i1.getValue()));
        f2 = new File(ob.FindAbsolutePath(i2,i2.getValue()));

        if(f1.listFiles().length == f2.listFiles().length) return 0;
        else if (f1.listFiles().length > f2.listFiles().length) return 1;
        else return -1;

    }
}
