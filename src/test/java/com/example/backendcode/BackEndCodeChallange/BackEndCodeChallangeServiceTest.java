package com.example.backendcode.BackEndCodeChallange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.backendcode.BackEndCodeChallange.dto.ResponseTo;
import com.example.backendcode.BackEndCodeChallange.repository.ApplicationDetailRespository;
import com.example.backendcode.BackEndCodeChallange.service.BackEndCodeChallangeService;
import com.example.backendcode.BackEndCodeChallange.util.BackEndCodeChallangeUtil;

public class BackEndCodeChallangeServiceTest {
	
	@InjectMocks
	BackEndCodeChallangeService backEndCodeChallangeService;
	
	@Mock
	ApplicationDetailRespository applicationDetailRespository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetResponse() {
		Mockito.when(applicationDetailRespository.findBySubType(Mockito.anyString())).thenReturn(BackEndCodeChallangeUtil.getApplicationDetailEntity());
		ResponseTo responseTo = backEndCodeChallangeService.getResponse("SA-11-TT", "Application1");
		assertEquals("Application1", responseTo.getApplicationDetail().get(0).getSubType());

		assertEquals("SA-11-TT", responseTo.getApplicationDetail().get(0).getApplicationPartDetail().getFilePN());

	}
	
	@Test
	public void testGetResponse_NullCheck() {
		Mockito.when(applicationDetailRespository.findBySubType(Mockito.anyString())).thenReturn(null);
		ResponseTo responseTo = backEndCodeChallangeService.getResponse("SA-11-TT", "Application3");
		assertTrue(responseTo.getApplicationDetail().size()==0);		

	}
	
	@Test
	public void testGetResponse_NullCheck_GetApplicationPartDetail() {
		Mockito.when(applicationDetailRespository.findBySubType(Mockito.anyString())).thenReturn(BackEndCodeChallangeUtil.getApplicationDetailEntityNullPartDetails());
		ResponseTo responseTo = backEndCodeChallangeService.getResponse("SA-11-TT", "Application1");
		assertTrue(responseTo.getApplicationDetail().size()==0);		

	}
	
	@Test
	public void testGetResponse_NullCheck_GetMGMFile() {
		Mockito.when(applicationDetailRespository.findBySubType(Mockito.anyString())).thenReturn(BackEndCodeChallangeUtil.getApplicationDetailEntityNullMGMFile());
		ResponseTo responseTo = backEndCodeChallangeService.getResponse("SA-11-TT", "Application1");
		assertEquals("Application1", responseTo.getApplicationDetail().get(0).getSubType());

		assertEquals("SA-11-TT", responseTo.getApplicationDetail().get(0).getApplicationPartDetail().getFilePN());
		assertNull(responseTo.getApplicationDetail().get(0).getApplicationPartDetail().getMGMFile());
	}

}
