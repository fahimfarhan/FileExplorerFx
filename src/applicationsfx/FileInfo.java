package applicationsfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;


/**
 * Created by Fahim on 4/19/2017.
 */
public class FileInfo {
    //private SimpleIntegerProperty id;
    private ImageView image;
    private SimpleStringProperty name;
    private SimpleStringProperty size;
    private SimpleStringProperty date;

    public FileInfo(ImageView image, String name, String size, String date){
        super();
        this.image = image;
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleStringProperty(size);
        this.date = new SimpleStringProperty(date);
    }

    public FileInfo(String name, String size, String date){
        super();
        //this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleStringProperty(size);
        this.date = new SimpleStringProperty(date);
    }

    //public Integer getId(){ return id.get(); }
    public String getDate(){ return date.get();}
    public String getSize(){return size.get();}
    public String getName(){return name.get();}
    public void setImage(ImageView value) {image = value;}
    public ImageView getImage() {return image;}
}
