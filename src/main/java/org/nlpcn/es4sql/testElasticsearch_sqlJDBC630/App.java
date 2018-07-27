package org.nlpcn.es4sql.testElasticsearch_sqlJDBC630;

import java.sql.SQLException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	esconn conn = new esconn();
		
			try {
				conn.exec("select FNAME1 from batsaleindex");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		
    }
}
