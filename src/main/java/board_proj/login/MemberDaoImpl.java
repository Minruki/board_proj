package board_proj.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao {
	private static final MemberDaoImpl instance = new MemberDaoImpl();
	private Connection con;
	
	public static MemberDaoImpl getInstance() {
		return instance;
	}
	private MemberDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public Member selectLoginMember(Member member) {
		String sql = "SELECT id " 
				+ 	 "  FROM users " 
				+	 " WHERE id = ?" 
				+	 "   AND passwd = password(?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return new Member(rs.getString("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
