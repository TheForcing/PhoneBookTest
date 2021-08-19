package PhonebookPJ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhoneBookDAOImpl implements PhoneBookDAO {
	

private Connection getConnection( )throws SQLException{
	Connection conn = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bituser","bituser");
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	return conn;
}
@Override
public List<PhoneBookVo> getlist() {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs= null;
	List<PhoneBookVo> list = new ArrayList<PhoneBookVo>();
	try {
		conn = getConnection();
		
		String sql= "SELECT id, name, hp, tel"+" from Phone_book";
		pstmt= conn.prepareStatement(sql);
		
		 rs= pstmt.executeQuery();
		
		 while((rs.next())) {
			  
			Long id= rs.getLong("id");
			String name=rs.getString("name");
			String hp=rs.getString("hp");
			String tel=rs.getString("tel");
			
			PhoneBookVo vo= new PhoneBookVo();
			vo.setId(id);
			vo.setName(name);
			vo.setHp(hp);
			vo.setTel(tel);
			
			list.add(vo);
			
		
		}
			 
		 } catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			
			}
			
			}return list;
		}
	



@Override
public int insert(PhoneBookVo vo) {
	int count= 0;
	Connection conn = null;
	PreparedStatement pstmt = null;

 try{
	conn=getConnection();
		
		String sql= "INSERT INTO PHONE_BOOK"+"(id, name, hp, tel)"+
		"VALUES(seq_phone_book.NEXTVAL,?,?,?,?)";
		 pstmt = conn.prepareStatement(sql);
		
		pstmt.setLong(1, vo.getId());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getHp());
		pstmt.setString(4, vo.getTel());
		
		count= pstmt.executeUpdate()
;		
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return count;
}
@Override
public int delete(Long pk) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int deletedCount=0;
	try {
		conn=getConnection();
		
		String sql="Delete FROM Phone_book ";
		 pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, pk);
		
		deletedCount = pstmt.executeUpdate();
		
		
		
	} catch (Exception e) {
	     e.printStackTrace();
	} finally {
		try {
			pstmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	return deletedCount;
}
@Override
public List<PhoneBookVo> search(PhoneBookVo vo) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		conn=getConnection();
		String sql ="SELECCT id , name, hp, tel From Phone_book";
		 pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, vo.getId());
		 rs= pstmt.executeQuery();
		
		if(rs.next()) {
			Long id=rs.getLong("id");
			String name=rs.getString("name");
			String hp=rs.getString("hp");
			String tel=rs.getString("tel");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		
	} finally {
		try {
			pstmt.close();
			conn.close();
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	return null;

}
}
