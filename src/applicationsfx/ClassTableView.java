package applicationsfx;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;



/**
 * Created by Fahim on 4/27/2017.
 */
public class ClassTableView extends FileExplorerFx {
    ClassTableView(){}
    public void setValues(TableView<FileInfo> tableview,TableColumn<FileInfo, ImageView> image,TableColumn<FileInfo, String> date,
                   TableColumn<FileInfo, String> name,TableColumn<FileInfo, String> size){
        this.tableview = tableview;
        this.date = date;
        this.name=name;
        this.size = size;
        this.image=image;
    }


    @Override
    public void CreateTableView() {
        sdf = new SimpleDateFormat("dd/MM/yy");
        File[] fl;
        ObservableList<FileInfo> list;
        if(CurrDirFile==null){CurrDirFile = new File("./"); }
        if(CurrDirName.equals("This PC")){  fl = File.listRoots();}
        else{fl = CurrDirFile.listFiles();}
        // donot delete . original
        FileInfo st[] = new FileInfo[fl.length];
        for(int i=0; i<fl.length;i++){
            String s1=null; String s2=null; String s3=null; ImageView img = null;
            try{
                if(IsDrive(fl[i])){
                    img = new ImageView(getIconImageFX(fl[i]));
                    s1 = fl[i].getAbsolutePath();}
                else{img = new ImageView(getIconImageFX(fl[i]));
                    s1 = fl[i].getName();}
                s2 = calculateSize(fl[i]);
                s3 = sdf.format(fl[i].lastModified());
            }catch(Exception x){
                System.out.println("Exception detected in tableview strings: "+x.getMessage());
            }
            st[i] = new FileInfo(img,s1,s2,s3);
        }

        list = FXCollections.observableArrayList(st);

        //id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableview.setItems(list);
    }

    @Override
    public void CreateTiles() { }
    @Override
    public TreeItem<String>[] TreeCreate(File dir) {return null;}
    @Override
    public String FindAbsolutePath(TreeItem<String> item, String s) {return null;}
    @Override
    public void CreateTreeView(TreeView<String> treeview) {}
    @Override
    public void CreateTilesView() {}
    @Override
    public void Initiate() {}
    @Override
    public void CreateTableView(TableView<FileInfo> tableview,TableColumn<FileInfo, ImageView> image,TableColumn<FileInfo, String> date,
                                TableColumn<FileInfo, String> name,TableColumn<FileInfo, String> size){}
    /*{
        sdf = new SimpleDateFormat("dd/MM/yy");
        File[] fl;
        ObservableList<FileInfo> list;
        if(CurrDirName.equals("This PC")){  fl = File.listRoots();}
        else{fl = CurrDirFile.listFiles();}
        // donot delete . original
        FileInfo st[] = new FileInfo[fl.length];
        for(int i=0; i<fl.length;i++){
            String s1=null; String s2=null; String s3=null; ImageView img = null;
            try{
                if(IsDrive(fl[i])){
                    img = new ImageView(getIconImageFX(fl[i]));
                    s1 = fl[i].getAbsolutePath();}
                else{img = new ImageView(getIconImageFX(fl[i]));
                    s1 = fl[i].getName();}
                s2 = calculateSize(fl[i]);
                s3 = sdf.format(fl[i].lastModified());
            }catch(Exception x){
                System.out.println("Exception detected in tableview strings: "+x.getMessage());
            }
            st[i] = new FileInfo(img,s1,s2,s3);
        }

        list = FXCollections.observableArrayList(st);

        //id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableview.setItems(list);
    }*/
}
