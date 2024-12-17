package com.springstartboot.com.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApplicationTests {

	
	@Mock
	private TrainingService ts;
	
	@InjectMocks
	private TrainingImp tm;
	
	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void test() {
//		TrainingImp i=new TrainingImp();
//		String c=i.TrainerCheck();
//		assertEquals("VOILA",c,"VOILA");
//	}
	
//	public void test() {
//		TrainingService ts=mock(TrainingService.class);
//		when(ts.retrievename()).thenReturn(new Training("Mercy"));
//		TrainingImp tm=new TrainingImp(ts);
//		String c=tm.TrainerCheck();
//		assertEquals(c, "VOILA");
//	}
	@Test
	public void test() {
		when(ts.retrievename()).thenReturn(new Training("Mercy"));
		String c=tm.TrainerCheck();
		assertEquals(c, "VOILA");
	}
	

}
