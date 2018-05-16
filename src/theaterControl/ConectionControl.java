package theaterControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConectionControl {
	
	private static ConectionControl uniqueInstance;

	private ConectionControl() {
	}

	public static synchronized ConectionControl getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new ConectionControl();

		return uniqueInstance;
	}
	
    private String url, userid, password;
    	
	public void setDadosLogin(String url, String userid, String pass) {
		this.url = "jdbc:mysql://" + url;
		this.userid = userid;
		this.password = pass;
	}


    
    private ArrayList columnNames = new ArrayList();
    private ArrayList data = new ArrayList();
    
    private Connection connection;
    private Statement stmt;
    private ResultSet rs;
    
    public void Concta() throws SQLException {
			connection = DriverManager.getConnection( url, userid, password );
			stmt = connection.createStatement();

    }
    
    public void fechaConec() throws SQLException {
    	
    	stmt.close();
    	connection.close();
    }
    
    public void executaComando(String sql) throws SQLException {
    	Concta();
    	rs = stmt.executeQuery(sql);
    	ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        //  Get column names
        for (int i = 1; i <= columns; i++)
        {
            columnNames.add( md.getColumnName(i) );
        }

        //  Get row data
        while (rs.next())
        {
            ArrayList row = new ArrayList(columns);

            for (int i = 1; i <= columns; i++)
            {
                row.add( rs.getObject(i) );
            }

            data.add( row );
        }
        fechaConec();
    }
    public void executaUpdate(String sql) throws SQLException{
    Concta();
	 stmt.executeUpdate(sql);
    }
    public void setArrays() {
    	columnNames.clear();
    	data.clear();
    }
    
    public ArrayList retornaColumnNames() {
    	return columnNames;
    }
    
    public ArrayList RetornaData() {
    	return data;
    }
   

}
