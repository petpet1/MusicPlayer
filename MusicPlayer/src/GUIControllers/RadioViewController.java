package GUIControllers;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.sql.ResultSet;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Petter
 */
public class RadioViewController {
    
    @FXML private TableView<entities.Song> songTable;
    @FXML private TableColumn name;
    @FXML private TableColumn artist;
    @FXML private TableColumn genre;
    @FXML private TableColumn popularity;
    @FXML private TextField searchText = new TextField();
    
    private String sqlStmt = "";
    private String sqlStmt2 = "";
    private database.testDB a = null;
    private ResultSet rs = null;
    private ObservableList<entities.Song> data;
    
     public void handleGenerateButton(Event event){
        try{
            String values = searchText.getText();
            System.out.println(values);
            connectToDB(); //Create connection to the DB.
            //Get the genre the first song of the artist is
            sqlStmt = "SELECT GENRE FROM SONGS where ARTIST like '%" + values + "%' ";
            rs = a.select(sqlStmt);
            if(!rs.next()){
                data.removeAll(data);
            }
            else{
                String rsgenre = rs.getString("GENRE");
                //Get songs in the same genre
                sqlStmt2 = "SELECT * FROM SONGS WHERE GENRE LIKE '%" + rsgenre + "%' ORDER BY NAME LIMIT 10";
                rs = a.select(sqlStmt2);
                data = makeList(rs);
                populateTable(data);
            }
            closeDB();  
        }
        catch(Exception e){
            System.exit(0);
        }
            

    }
    
    @FXML public void handleEnterPressed(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)){
            handleGenerateButton(event);
        }
    }
    
    @FXML public void handleDoubleClickSong(Event event)
    {
        if(true){
            entities.Song song = songTable.getSelectionModel().getSelectedItem();
            
        }
    }
    
    public ObservableList<entities.Song> makeList(ResultSet rs) throws SQLException {
        data = FXCollections.observableArrayList();
        entities.Song song;

        while(rs.next()) {
            song = new entities.Song(rs.getInt("ID"),rs.getString("NAME"),rs.getString("ARTIST"),rs.getString("GENRE"), rs.getInt("POPULARITY"), rs.getString("LOCATION"));
            data.add(song);
        }
        return data;
        
    }
    
    private void populateTable(ObservableList<entities.Song> data) {
        songTable.setEditable(true);
        name.setCellValueFactory(new PropertyValueFactory<>("songName"));
        artist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        popularity.setCellValueFactory(new PropertyValueFactory<>("pop"));
        songTable.setItems(data);
    }
     
    private void sendToPlaylist(){
        //send songs to playlist
        //send the data list as an argument   
    }
    
    private void playSong(){
        //Startview.setMedia(song.getLocation());
    }
            
    public void connectToDB(){
        a = new database.testDB();
    }
    
    public void closeDB() throws SQLException {
        a.close();
        a = null;
    }
}
