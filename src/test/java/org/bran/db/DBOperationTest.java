package org.bran.db;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBOperationTest {
	private static DBOperation db=new DBOperation();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		db.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExecuteUpdate() {
		String sql="insert into bookTest values('978','数据库系统概论','计算机','王珊','2014-5-1')";
		int i=0;
		try {
			 i=db.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, i);
	}

	@Test
	public void testExecuteQuery() {
		String sql="select bookid from bookTest where bookname='算法'";
		ResultSet rs=null;
		String id=null;
		try {
			rs=db.executeQuery(sql);
			while(rs.next()){
				id=rs.getString("bookid");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("158", id);
	}
	@Test
	public void testGetPreparedStatement(){
		
	}

}
