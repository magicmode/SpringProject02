package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
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
		vo.setTitle("제목");
		vo.setContent("콘텐츠");
		vo.setWriter("글쓴이");
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
}
