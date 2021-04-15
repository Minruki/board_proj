package board_proj.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import board_proj.JdbcUtil;
import board_proj.dao.impl.BoardDaoImpl;
import board_proj.dto.BoardDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardDaoTest {
	private static Connection con = JdbcUtil.getConnection();
	private static BoardDaoImpl dao = BoardDaoImpl.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01NextBoardNum() {
		System.out.println("testNextBoardNum()");
		int res = dao.nextBoardNum();
		Assert.assertNotEquals(0, res);
		System.out.printf("next Number >> " + res);
	}
	
	@Test
	public void test02SelectListCount() {
		System.out.println("testSelectListCount()");
		int res = dao.selectListCount();
		
		Assert.assertNotEquals(-1, res);
		System.out.printf("ListCount >> " + res);
	}

	@Test
	public void test03SelectArticleList() {
		System.out.println("testSelectArticleList()");
		int page = 1;
		int limit = 10;
		ArrayList<BoardDTO> list = dao.selectArticleList(page, limit);
		Assert.assertNotNull(list);
		
		list.stream().forEach(System.out::println);
		
		System.out.println("===================");
		dao.selectArticleList(2, 10).stream().forEach(System.out::println);
	}
	
	@Test
	public void test04InsertArticle() {
		System.out.println("testInsertArticle()");
		BoardDTO article = new BoardDTO(
				"김상건", 
				"1234", 
				"5시 퇴근가능할까?", 
				"불가능 함", 
				"test.txt");
		int res = dao.insertArticle(article);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05SelectArticle() {
		System.out.println("test05SelectArticle()");
		int board_num = 74;
		BoardDTO article = dao.selectArticle(board_num);
		Assert.assertNotNull(article);
		System.out.println(article);
	}

	@Test
	public void test06UpdateReadCount() {
		System.out.println("test06UpdateReadCount()");
		int board_num = 74;
		int res = dao.updateReadCount(board_num);
		Assert.assertEquals(1, res);
		System.out.println("res >> " + res);
	}

	@Test
	public void testInsertReplyArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsArticleBoardWriter() {
		fail("Not yet implemented");
	}

}
