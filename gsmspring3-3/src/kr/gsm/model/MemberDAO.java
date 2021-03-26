package kr.gsm.model;
// JDBC->myBatis->JPA
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MemberDAO {
   private Connection conn; // 연결객체
   private PreparedStatement ps; // SQL문장을 전송객체
   private ResultSet rs; // 결과집합을 저장하는 객체
   // 연결객체생성
   public void getConnect() {
	   String url="jdbc:mysql://localhost:3306/gsm3";
	   String user="root";
	   String password="12345";
	   // MySQL Driver class : 
	   // new com.mysql.jdbc.Driver();
	   try {
		  // 동적바인딩
		  Class.forName("com.mysql.jdbc.Driver");
		  conn=DriverManager.getConnection(url, user, password);
	   } catch (Exception e) {
		 e.printStackTrace();
	   }
   }
   // 전체리스트를 가져오는 동작
   public List<MemberVO> memberList() {
	   getConnect(); // conn
	   String SQL="select * from member";
	   List<MemberVO> list=new ArrayList<MemberVO>();
	   try {
		  // PreparedStatement
		  ps=conn.prepareStatement(SQL);
		  rs=ps.executeQuery();// 실행
		  while(rs.next()) {
			  int num=rs.getInt("num");
			  String id=rs.getString("id");
			  String pass=rs.getString("pass");
			  String name=rs.getString("name");
			  int age=rs.getInt("age");
			  String phone=rs.getString("phone");
			  String email=rs.getString("email");
			  // VO(묶고)
			  MemberVO vo=new MemberVO();
			  vo.setNum(num);
			  vo.setId(id);
			  vo.setPass(pass);
			  vo.setName(name);
			  vo.setAge(age);
			  vo.setPhone(phone);
			  vo.setEmail(email);
			  // 담고(List)
			  list.add(vo);			  
		  }
	   } catch (Exception e) {
		e.printStackTrace();
	   }finally {
		   dbClose();
	   }
	   return list;
   }
   public int memberInsert(MemberVO vo) {
	   getConnect();                                                    //파라메터(1,2,3,4..)
	   String SQL="insert into member(id,pass,name,age,phone,email) values(?,?,?,?,?,?)";
	   int cnt=0;
	   try {
		  ps=conn.prepareStatement(SQL);
		  ps.setString(1, vo.getId());
		  ps.setString(2, vo.getPass());
		  ps.setString(3, vo.getName());
		  ps.setInt(4, vo.getAge());
		  ps.setString(5, vo.getPhone());
		  ps.setString(6, vo.getEmail());
	      cnt=ps.executeUpdate();//실행 	  
	   } catch (Exception e) {
		   e.printStackTrace();
	   }finally {
		   dbClose();
	   }
	   return cnt;
   }
   public void dbClose() {
	   try {
		   if(rs!=null) rs.close();
		   if(ps!=null) ps.close();
	       if(conn!=null) conn.close();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
}
