package com.example.backendcode.BackEndCodeChallange.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.backendcode.BackEndCodeChallange.dto.ApplicationDetail;
import com.example.backendcode.BackEndCodeChallange.dto.ApplicationPartDetail;
import com.example.backendcode.BackEndCodeChallange.dto.CompatibleAssemblies;
import com.example.backendcode.BackEndCodeChallange.dto.FunctionalTypeValues;
import com.example.backendcode.BackEndCodeChallange.dto.MGMFile;
import com.example.backendcode.BackEndCodeChallange.dto.Protocol;
import com.example.backendcode.BackEndCodeChallange.dto.ResponseTo;
import com.example.backendcode.BackEndCodeChallange.entity.ApplicationDetailEntity;
import com.example.backendcode.BackEndCodeChallange.entity.ValuesEntity;
import com.example.backendcode.BackEndCodeChallange.repository.ApplicationDetailRespository;

@Service
public class BackEndCodeChallangeService {
	
	@Autowired
	ApplicationDetailRespository applicationDetailRespository;

	public ResponseTo getResponse(String fileName, String section) {
		
		ResponseTo response = new ResponseTo();
		List<ApplicationDetail> userDetails = new ArrayList<>();
		
		Optional<ApplicationDetailEntity> userInfo = applicationDetailRespository.findBySubType(section);
		if(null != userInfo && null != userInfo.get().getApplicationPartDetail()
				&& userInfo.get().getApplicationPartDetail().getFilePN().equalsIgnoreCase(fileName)) {
			
			userDetails.add(getResponseMapping(userInfo.get()));
		}
		response.setApplicationDetail(userDetails);
		return response;
	}
	
	public ApplicationDetail getResponseMapping(ApplicationDetailEntity applicationDetailsRequest) {
		ApplicationDetail applicationDetails = new ApplicationDetail();
		ApplicationPartDetail applicationPartDetail = new ApplicationPartDetail();
		
		applicationDetails.setSubType(applicationDetailsRequest.getSubType());
		applicationDetails.setValues(applicationDetailsRequest.getValuesEntity().stream().map(ValuesEntity::getValueString).collect(Collectors.toList()));
		if(null != applicationDetailsRequest.getApplicationPartDetail()) {
			applicationPartDetail.setFilePN(applicationDetailsRequest.getApplicationPartDetail().getFilePN());
			applicationPartDetail.setFrozenStatus(applicationDetailsRequest.getApplicationPartDetail().getFrozenStatus());
			applicationPartDetail.setSuccessorPartNumber(applicationDetailsRequest.getApplicationPartDetail().getSuccessorPartNumber());
			if(null != applicationDetailsRequest.getApplicationPartDetail().getMGMFile()) {
				MGMFile mgmFile = new MGMFile();
				if(!CollectionUtils.isEmpty(applicationDetailsRequest.getApplicationPartDetail().getMGMFile().getProtocol())) {
					List<Protocol> protocols = new ArrayList<>();
					applicationDetailsRequest.getApplicationPartDetail().getMGMFile().getProtocol().forEach(val -> {
						Protocol protocol = new Protocol();
						protocol.setNetworkWireless(val.getNetworkWireless());
						protocol.setNetworkProtocol(val.getEmbeddedId().getNetworkProtocol());
						protocols.add(protocol);
					});
					mgmFile.setProtocol(protocols);
				}
				mgmFile.setFileFormat(applicationDetailsRequest.getApplicationPartDetail().getMGMFile().getFileFormat());
				mgmFile.setChecksum(applicationDetailsRequest.getApplicationPartDetail().getMGMFile().getChecksum());
				mgmFile.setFileFingerprint(applicationDetailsRequest.getApplicationPartDetail().getMGMFile().getFileFingerprint());
				mgmFile.setROMSizeKB(applicationDetailsRequest.getApplicationPartDetail().getMGMFile().getROMSizeKB());
				mgmFile.setSize(applicationDetailsRequest.getApplicationPartDetail().getMGMFile().getSize());
				mgmFile.setFileDateModified(applicationDetailsRequest.getApplicationPartDetail().getMGMFile().getFileDateModified());
				
				applicationPartDetail.setMGMFile(mgmFile);
				
			}
			applicationPartDetail.setVersion(applicationDetailsRequest.getApplicationPartDetail().getVersion());
			applicationPartDetail.setRunTimeSize(applicationDetailsRequest.getApplicationPartDetail().getRunTimeSize());
			
			applicationDetails.setApplicationPartDetail(applicationPartDetail);
		}
		applicationDetails.setApplicationDescription(applicationDetailsRequest.getApplicationDescription());
		applicationDetails.setServiceable(applicationDetailsRequest.getServiceable());
		applicationDetails.setTestable(applicationDetailsRequest.getTestable());
		
		if(!CollectionUtils.isEmpty(applicationDetailsRequest.getCompatibleAssemblies())) {
			List<CompatibleAssemblies> compAssemList = new ArrayList<>();
			applicationDetailsRequest.getCompatibleAssemblies().forEach(val -> {
				CompatibleAssemblies compAssem = new CompatibleAssemblies();
				compAssem.setAssyPN(val.getAssyPN());
				compAssemList.add(compAssem);
			});
			applicationDetails.setCompatibleAssemblies(compAssemList);
		}
		
		FunctionalTypeValues funcTypVal = new FunctionalTypeValues();
		funcTypVal.setFunctionalType(applicationDetailsRequest.getFunctionalTypeValues().getFunctionalType());
		applicationDetails.setFunctionalTypeValues(funcTypVal);
		
		applicationDetails.setSellable(applicationDetailsRequest.getSellable());
		applicationDetails.setResidentOnVehicle(applicationDetailsRequest.getResidentOnVehicle());
		applicationDetails.setDigitallySigned(applicationDetailsRequest.getDigitallySigned());
		applicationDetails.setConsumerViewable(applicationDetailsRequest.getConsumerViewable());
		applicationDetails.setConsumerDownloadable(applicationDetailsRequest.getConsumerDownloadable());
		applicationDetails.setDealerDownloadable(applicationDetailsRequest.getDealerDownloadable());
		applicationDetails.setOTAViewable(applicationDetailsRequest.getOTAViewable());
		applicationDetails.setOTADownloadable(applicationDetailsRequest.getOTADownloadable());
		
		return applicationDetails;
		
	}

}
