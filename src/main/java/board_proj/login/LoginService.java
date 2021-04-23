package board_proj.login;

import java.sql.Connection;

import board_proj.ds.JndiDS;

public class LoginService {
	private MemberDaoImpl dao = MemberDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	public LoginService() {
		dao.setCon(con);
	}
	
	public Member getLoginMember(String id, String passwd) {
	Member member = new Member(id, passwd);
	Member loginMember = dao.selectLoginMember(member);
	return loginMember;

}
}