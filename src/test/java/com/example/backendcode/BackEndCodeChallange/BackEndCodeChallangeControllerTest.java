package com.example.backendcode.BackEndCodeChallange;

import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.backendcode.BackEndCodeChallange.controller.BackEndCodeChallangeController;
import com.example.backendcode.BackEndCodeChallange.dto.BackEndException;
import com.example.backendcode.BackEndCodeChallange.dto.ResponseTo;
import com.example.backendcode.BackEndCodeChallange.service.BackEndCodeChallangeService;
import com.google.gson.Gson;
@RunWith(SpringRunner.class)
@WebMvcTest(BackEndCodeChallangeController.class)
public class BackEndCodeChallangeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BackEndCodeChallangeService backEndCodeChallangeService;
	
	@Test
	public void testGetUserInformationForFile() throws Exception {
		
		String result = "{\"ApplicationDetail\":[{\"SubType\":\"Application1\",\"Values\":[\"CS\",\"DA\",\"DE\",\"FR-FR\",\"PL\",\"PT-PT\",\"RU\",\"SV\",\"TR\"],\"ApplicationPartDetail\":{\"FilePN\":\"SA-11-TT\",\"FrozenStatus\":\"True\",\"SuccessorPartNumber\":\"SA-11-TS\",\"MGMFile\":{\"Protocol\":[{\"NetworkWireless\":\"Yes\",\"NetworkProtocol\":\"OTA\"},{\"NetworkWireless\":\"No\",\"NetworkProtocol\":\"USB\"}],\"FileFormat\":\"TAR.GZ\",\"Checksum\":\"0xC7C1DA2F\",\"FileFingerprint\":\"0x61192B821A9EA47D72DD360175C7A8EE\",\"ROMSizeKB\":\"1664508640\",\"Size\":\"1664508640\",\"FileDateModified\":\"Feb-18-2016 21:19:40\"},\"Version\":\"1.0\",\"RunTimeSize\":\"1664508640\"},\"ApplicationDescription\":\"Test Application to run certain features in the vehicle\",\"Serviceable\":\"Y\",\"Testable\":\"Y\",\"CompatibleAssemblies\":[{\"AssyPN\":\"SA-12-AAA\"},{\"AssyPN\":\"SA-12-AAB\"},{\"AssyPN\":\"SA-12-AAC\"},{\"AssyPN\":\"SA-12-FAA\"},{\"AssyPN\":\"SA-12-FAB\"},{\"AssyPN\":\"SA-12-FAC\"}],\"FunctionalTypeValues\":{\"FunctionalType\":\"Custom Application\"},\"Sellable\":\"N\",\"ResidentOnVehicle\":\"Y\",\"DigitallySigned\":\"Generically Signed\",\"ConsumerViewable\":\"Y\",\"ConsumerDownloadable\":\"Y\",\"DealerDownloadable\":\"Y\",\"OTAViewable\":\"Y\",\"OTADownloadable\":\"Y\"},{\"SubType\":\"Application2\",\"Values\":[\"CS\",\"DA\",\"EN-GB\",\"NL\",\"NO\",\"PL\",\"SV\",\"TR\"],\"ApplicationPartDetail\":{\"FilePN\":\"VA-16-AA\",\"FrozenStatus\":\"True\",\"SuccessorPartNumber\":\"VA-16-AB\",\"MGMFile\":{\"Protocol\":[{\"NetworkWireless\":\"No\",\"NetworkProtocol\":\"USB\"}],\"FileFormat\":\"TAR.GZ\",\"Checksum\":\"0xC7C1DA2F\",\"FileFingerprint\":\"0x61192B821A9EA47D72DD360175CTYEE\",\"ROMSizeKB\":\"166678908640\",\"Size\":\"166678908640\",\"FileDateModified\":\"Mar-212-2016 21:20:40\"},\"Version\":\"2.0\",\"RunTimeSize\":\"166678908640\"},\"ApplicationDescription\":\"Application to modulate ambient light\",\"Serviceable\":\"N\",\"Testable\":\"N\",\"CompatibleAssemblies\":[{\"AssyPN\":\"VA-17-OP\"},{\"AssyPN\":\"VA-17-QP\"}],\"FunctionalTypeValues\":{\"FunctionalType\":\"Language Pack\"},\"Sellable\":\"Y\",\"ResidentOnVehicle\":\"Y\",\"DigitallySigned\":\"Generically Signed\",\"ConsumerViewable\":\"Y\",\"ConsumerDownloadable\":\"Y\",\"DealerDownloadable\":\"Y\",\"OTAViewable\":\"Y\",\"OTADownloadable\":\"N\"}]}";
		Gson gson = new Gson();
		ResponseTo responseTo = gson.fromJson(result, ResponseTo.class);
				
		given(backEndCodeChallangeService.getResponse("SA-11-TT", "Application1")).willReturn(responseTo);
		
		ResultMatcher status_200 = MockMvcResultMatchers.status().isOk();
		//ResultMatcher json_path = MockMvcResultMatchers.jsonPath(result).value("Application1");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/backEndCodeChallange/user/getDetails?fileName=SA-11-TT&section=Application1");
		mockMvc.perform(builder).andExpect(status_200);

		
	}
	
	@Test
	public void testGetUserInformationForFile_notFound() throws Exception {
		ResultMatcher status_404 = MockMvcResultMatchers.status().isNotFound();
		given(backEndCodeChallangeService.getResponse("SA-11-TT", "Application1")).willThrow(new BackEndException());
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/backEndCodeChallange/user/getDetails?fileName=SA-11-TT&section=Application1");
		mockMvc.perform(builder).andExpect(status_404);
	}

}
