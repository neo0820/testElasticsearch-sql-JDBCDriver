package org.nlpcn.es4sql.testElasticsearch_sqlJDBC630;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class esconn {

	String driver = "org.nlpcn.es4sql.jdbc.Driver" ;// 驱动名称
	String url = "jdbc:elasticsearch://127.0.0.1:9300/batsaleindex" ;// 连接字符串
	   String username = "root" ;// 用户名
	   String password = "123456" ;// 密码
	   
	   // 三剑客
	  Connection con = null ;// 连接对象
	  PreparedStatement pstmt = null ;// 语句对象
	  ResultSet rs = null ;// 结果集对象
	  
	      
	  
	  
	  /**
	     * 获得连接对象
	     *
	     * @return 连接对象
	     * @throws ClassNotFoundException
	     * @throws SQLException
	     */
	     public Connection getConnection() throws ClassNotFoundException,
	                SQLException {
	          Class. forName( driver);
	           con = DriverManager.getConnection( url , username , password );
	           return con ;
	    }
	     
	     
	     
	     
	     /**
		   * 关闭三剑客
		   *
		   * @throws SQLException
		   */
		       public void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		 
		             try {
		                   if (rs != null)
		                        rs.close();
		                   if (pstmt != null)
		                        pstmt.close();
		                   if (con != null)
		                        con.close();
		            } catch (SQLException e) {
		                   // TODO: handle exception
		              e.printStackTrace();
		        }
		  }
		       
		       void exec(String sql) throws ClassNotFoundException,SQLException
		       {
		    	   
		    	   Properties connectionProperties = new Properties();
		         
		           try {
		        	   
		        	   Class. forName( driver);
		        	   con = DriverManager.getConnection( url , username , password );
		           } catch (SQLException e) {
		               e.printStackTrace();
		           }
		    
		           //Statement statement = con.createStatement();
		           //ResultSet results = statement.executeQuery(sql);
		           PreparedStatement statement = con.prepareStatement(sql);
		           ResultSet results = statement.executeQuery();
		        		   
		           
		           
		           while (results.next()) {
		               System.out.println(results.getString("FNAME1"));
		           }
		    
		           //关闭资源
		           results.close();
		           statement.close();
		           con.close();
		       }
		   
	
		       
		       
}
