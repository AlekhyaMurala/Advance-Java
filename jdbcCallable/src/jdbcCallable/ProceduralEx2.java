package jdbcCallable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProceduralEx2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","alekhya","java");
		
		//call the procedure
		CallableStatement callableStatement=connection.prepareCall("{call getInfo(?,?,?,?)}");
		
		//set the input data
		callableStatement.setInt(1, 1001);
		
		//register variable to store the data
		callableStatement.registerOutParameter(2, Types.INTEGER);
		callableStatement.registerOutParameter(3, Types.VARCHAR);
		callableStatement.registerOutParameter(4, Types.FLOAT);
		
		//execute the procedure
		callableStatement.executeUpdate();
		
		//get the data
		System.out.println(callableStatement.getInt(2));
		System.out.println(callableStatement.getString(3));
		System.out.println(callableStatement.getFloat(4));
		
		connection.close();
		

	}

}
