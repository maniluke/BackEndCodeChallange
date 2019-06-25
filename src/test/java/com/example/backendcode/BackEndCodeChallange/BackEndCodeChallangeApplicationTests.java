
package com.example.backendcode.BackEndCodeChallange;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.backendcode.BackEndCodeChallange.dto.ResponseTo;
import com.example.backendcode.BackEndCodeChallange.util.BackEndCodeChallangeUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackEndCodeChallangeApplicationTests {
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testFuntioanlEndtoEnd() throws URISyntaxException {
		final String baseUrl = "/backEndCodeChallange/user/getDetails?fileName=SA-11-TT&section=Application1";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<ResponseTo> response = testRestTemplate.exchange(
				uri,HttpMethod.GET, null, ResponseTo.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getApplicationDetail().get(0).getSubType()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getSubType());
		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getFilePN()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getFilePN());
		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getFrozenStatus()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getFrozenStatus());
		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getSuccessorPartNumber()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getSuccessorPartNumber());

		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getRunTimeSize()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getRunTimeSize());

		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getVersion()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getVersion());
		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getMGMFile().getChecksum()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getMGMFile().getChecksum());
		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getMGMFile().getFileFingerprint()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getMGMFile().getFileFingerprint());
		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getMGMFile().getFileFormat()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getMGMFile().getFileFormat());

		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getMGMFile().getROMSizeKB()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getMGMFile().getROMSizeKB());

		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getMGMFile().getSize()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getMGMFile().getSize());
		
		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getMGMFile().getProtocol().get(0).getNetworkProtocol()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getMGMFile().getProtocol().get(0).getNetworkProtocol());
		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationPartDetail().getMGMFile().getProtocol().get(0).getNetworkWireless()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationPartDetail().getMGMFile().getProtocol().get(0).getNetworkWireless());

		assertThat(response.getBody().getApplicationDetail().get(0).getApplicationDescription()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getApplicationDescription());
		assertThat(response.getBody().getApplicationDetail().get(0).getServiceable()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getServiceable());
		assertThat(response.getBody().getApplicationDetail().get(0).getTestable()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getTestable());
		assertThat(response.getBody().getApplicationDetail().get(0).getCompatibleAssemblies().get(0).getAssyPN()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getCompatibleAssemblies().get(0).getAssyPN());
		assertThat(response.getBody().getApplicationDetail().get(0).getFunctionalTypeValues().getFunctionalType()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getFunctionalTypeValues().getFunctionalType());

		assertThat(response.getBody().getApplicationDetail().get(0).getSellable()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getSellable());

		assertThat(response.getBody().getApplicationDetail().get(0).getResidentOnVehicle()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getResidentOnVehicle());

		assertThat(response.getBody().getApplicationDetail().get(0).getDigitallySigned()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getDigitallySigned());

		assertThat(response.getBody().getApplicationDetail().get(0).getConsumerViewable()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getConsumerViewable());

		assertThat(response.getBody().getApplicationDetail().get(0).getConsumerDownloadable()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getConsumerDownloadable());

		assertThat(response.getBody().getApplicationDetail().get(0).getDealerDownloadable()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getDealerDownloadable());

		assertThat(response.getBody().getApplicationDetail().get(0).getOTAViewable()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getOTAViewable());

		assertThat(response.getBody().getApplicationDetail().get(0).getOTADownloadable()).isEqualTo( BackEndCodeChallangeUtil.getApplicationDetail().getOTADownloadable());

	}

}
