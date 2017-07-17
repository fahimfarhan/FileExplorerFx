package applicationsfx;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Created by Fahim on 4/27/2017.
 */
public class ClassTilesView extends FileExplorerFx{

    ClassTilesView(){}

    public void CreateTiles() {
        File[] fl;
        if(CurrDirFile==null){CurrDirFile=new File("./");}
        fl = CurrDirFile.listFiles();
        if(CurrDirName.equals("This PC")){fl = File.listRoots(); }
        int len = fl.length;
        //Pane newLoadedPane[]=new Pane[len];
        tilePane.getChildren().clear();
        for(int i=0; i<len;i++){
            //Label temp = new Label();
            Label title = new Label(fl[i].getName());
            title.setId(fl[i].getName());
            ImageView imageview = new ImageView(getIconImageFX(fl[i]));
            VBox vbox = new VBox();
            vbox.setId(fl[i].getName());
            vbox.getChildren().addAll(imageview,title);

            vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getClickCount() == 2){
                        System.out.println("Tile pressed "+vbox.getId());
                        String str = vbox.getId();
                        String str1 = CurrDirStr+"\\"+str;
                        File f = new File(str1);
                        if(f.isFile()){ Desktop d =Desktop.getDesktop();
                            try {
                                d.open(f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            CurrDirStr = str1;
                            CurrDirFile = new File(CurrDirStr);
                            setLabelTxt();
                            tilePane.getChildren().clear();
                            CreateTiles();
                        }

                    }
                }
            });

            TilePane.setAlignment(vbox, Pos.BOTTOM_LEFT);

            tilePane.getChildren().add(vbox);
        }

    }

    @Override
    public TreeItem<String>[] TreeCreate(File dir)
    {return null;}
    @Override
    public String FindAbsolutePath(TreeItem<String> item, String s)
    {return null;}
    @Override
    public void CreateTreeView(TreeView<String> treeview) {}
    @Override
    public void CreateTableView
    (TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date, TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size)
    {}
    @Override
    public void CreateTableView() {}
    @Override
    public void CreateTilesView() {}
    @Override
    public void Initiate() {}
    @Override
    public void setValues
    (TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date, TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size)
    {}
}
