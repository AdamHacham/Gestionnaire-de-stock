package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 
 * @author Narayan
 */

public class ViewTable extends Application{

    //TABLE VIEW AND DATA
    @SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> data;
    @SuppressWarnings("rawtypes")
	public TableView tableview;

    //MAIN EXECUTOR
    public static void main(String[] args) {
        launch(args);
    }

    //CONNECTION DATABASE
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void buildData(){
	String url = "jdbc:mysql://localhost:3306/Users";
        String login = "root";
        String passwd = "doliprane";
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
           Class.forName("com.mysql.jdbc.Driver");

                // Etape 2 : récupération de la connexion                                                                                                                    
                c = DriverManager.getConnection(url, login, passwd);
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT Coli.nompe,Coli.prenompe,Coli.nompr,Coli.prenompr,Coli.dest,Coli.src,Coli.numcolis,Coli.prix,Client.tel FROM Coli INNER JOIN Client ON Coli.id_propriétaire=Client.id AND Coli.tel = Client.tel WHERE Client.tel = 0609699888";
            
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }


      @SuppressWarnings("rawtypes")
	@Override
      public void start(Stage stage) throws Exception {
        //TableView
        this.tableview = new TableView();
        buildData();

        //Main Scene
        Scene scene = new Scene(tableview);        

        stage.setScene(scene);
        stage.show();
      }
}
