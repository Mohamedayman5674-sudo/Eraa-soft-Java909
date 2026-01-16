package myservlet;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.classfmt.NonNullDefaultAwareTypeAnnotationWalker;


@SuppressWarnings("serial")
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	@Resource(name="jdbc/connection")
private DataSource dataSource;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter=  response.getWriter();
		try {

Connection Connection=  dataSource.getConnection();
java.sql.Statement statement =  Connection.createStatement();

String query="SELECT * from REGIONS";

ResultSet resultSet=   statement.executeQuery(query);


while (resultSet.next()) {
	
	 int id=   resultSet.getInt("REGION_ID");
	 String name= resultSet.getString("REGION_NAME");
	 

		printWriter.append("<h1>" + id +  "</h1>");
		printWriter.append("<h1>" + name +  "</h1>");
	
}



			
			

} catch (SQLException exception) {
	printWriter.append("<h1>Exception:" + exception.getMessage() +  "</h1>");

}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter printWriter= response.getWriter();
printWriter.append("<h1> i am on depost</h1>");

}
	}
