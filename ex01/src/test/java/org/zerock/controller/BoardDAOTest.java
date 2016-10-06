package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testCreate() throws Exception{
		
		BoardVO vo = new BoardVO();
		/*for(int i=1; i<1000; i++){
			vo.setTitle("이 글은"+i+"번 글 제목입니다.");
			vo.setContent("이 글은 " + i + " 번 글입니다. 해당 내용은 생략 합니다.");
			vo.setWriter("글쓴이 " + i);
			dao.create(vo);
		}*/
		vo.setTitle("이 글은"+1000+"번 글 제목입니다.");
		vo.setContent("이 글은 " + 1000 + " 번 글입니다. 해당 내용은 생략 합니다.");
		vo.setWriter("글쓴이 " + 1000);
		dao.create(vo);
	}
	
	@Test
	public void testRead() throws Exception{

		logger.info(dao.read(1).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("제목-수정");
		vo.setContent("콘텐츠-수정");
		vo.setWriter("글쓴이-수정");
		dao.update(vo);		
	}
	
	@Test
	public void testDelte()  throws Exception{
	
		dao.delete(1);
	}
	
	@Test
	public void testListPage() throws Exception{
		
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO: list){
			logger.info(boardVO.getBno() + " : " + boardVO.getTitle());
		}
	}
	
	@Test
	public void testListCriteria() throws Exception{
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPrePageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO boardVO: list){
			logger.info(boardVO.getBno() + " : " + boardVO.getTitle());
		}
	}
}
