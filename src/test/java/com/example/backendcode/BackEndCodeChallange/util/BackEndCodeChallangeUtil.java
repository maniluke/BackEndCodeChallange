package com.example.backendcode.BackEndCodeChallange.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.backendcode.BackEndCodeChallange.dto.ApplicationDetail;
import com.example.backendcode.BackEndCodeChallange.dto.ApplicationPartDetail;
import com.example.backendcode.BackEndCodeChallange.dto.CompatibleAssemblies;
import com.example.backendcode.BackEndCodeChallange.dto.FunctionalTypeValues;
import com.example.backendcode.BackEndCodeChallange.dto.MGMFile;
import com.example.backendcode.BackEndCodeChallange.dto.Protocol;
import com.example.backendcode.BackEndCodeChallange.entity.ApplicationDetailEntity;
import com.example.backendcode.BackEndCodeChallange.entity.ProtocolPK;
import com.example.backendcode.BackEndCodeChallange.entity.ValuesEntity;

public class BackEndCodeChallangeUtil {

	public static Optional<ApplicationDetailEntity> getApplicationDetailEntity(){
		ApplicationDetailEntity applicationDetails = new ApplicationDetailEntity();
		com.example.backendcode.BackEndCodeChallange.entity.ApplicationPartDetail applicationPartDetail = new com.example.backendcode.BackEndCodeChallange.entity.ApplicationPartDetail();
		
		applicationDetails.setSubType("Application1");
		Set<ValuesEntity> valuesList = new HashSet<>();
		
		ValuesEntity values= null;
		values = new ValuesEntity();
		values.setSubType("Application1");
		values.setValuesId(1);
		values.setValueString("CS");
		valuesList.add(values);		
		
		values = new ValuesEntity();
		values.setSubType("Application1");
		values.setValuesId(1);
		values.setValueString("DA");
		valuesList.add(values);	
		
		applicationDetails.setValuesEntity(valuesList);
		
		applicationPartDetail.setFilePN("SA-11-TT");
		applicationPartDetail.setFrozenStatus("true");
		applicationPartDetail.setSuccessorPartNumber("SA-11-TS");
		com.example.backendcode.BackEndCodeChallange.entity.MGMFile mgmFile = new com.example.backendcode.BackEndCodeChallange.entity.MGMFile();
		Set<com.example.backendcode.BackEndCodeChallange.entity.Protocol> protocols = new HashSet<>();
		com.example.backendcode.BackEndCodeChallange.entity.Protocol protocol = new com.example.backendcode.BackEndCodeChallange.entity.Protocol();
			protocol.setNetworkWireless("yes");
			ProtocolPK  protocolPk = new ProtocolPK();
			protocolPk.setNetworkProtocol("USB");
			protocol.setEmbeddedId(protocolPk);
			protocols.add(protocol);
		mgmFile.setProtocol(protocols);

		mgmFile.setFileFormat("TAR.GZ");
		mgmFile.setChecksum("0xC7C1DA2F");
		mgmFile.setFileFingerprint("0x61192B821A9EA47D72DD360175C7A8EE");
		mgmFile.setROMSizeKB("1664508640");
		mgmFile.setSize("1664508640");
		mgmFile.setFileDateModified(Timestamp.valueOf(LocalDateTime.now()));
		
		applicationPartDetail.setMGMFile(mgmFile);
			
		applicationPartDetail.setVersion("1.0");
		applicationPartDetail.setRunTimeSize("1664508640");
		
		applicationDetails.setApplicationPartDetail(applicationPartDetail);

		applicationDetails.setApplicationDescription("Test Application to run certain features in the vehicle");
		applicationDetails.setServiceable("Y");
		applicationDetails.setTestable("Y");
		Set<com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies> compAssemList = new HashSet<>();
		com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies compAssem = new com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies();
			compAssem.setAssyPN("SA-12-AAA");
			compAssemList.add(compAssem);
		
		applicationDetails.setCompatibleAssemblies(compAssemList);
		
		com.example.backendcode.BackEndCodeChallange.entity.FunctionalTypeValues funcTypVal = new com.example.backendcode.BackEndCodeChallange.entity.FunctionalTypeValues();
		funcTypVal.setFunctionalType("Custom Application");
		applicationDetails.setFunctionalTypeValues(funcTypVal);
		
		applicationDetails.setSellable("Y");
		applicationDetails.setResidentOnVehicle("Y");
		applicationDetails.setDigitallySigned("Generically Signed");
		applicationDetails.setConsumerViewable("Y");
		applicationDetails.setConsumerDownloadable("Y");
		applicationDetails.setDealerDownloadable("Y");
		applicationDetails.setOTAViewable("N");
		applicationDetails.setOTADownloadable("Y");
		
		return Optional.of(applicationDetails);
	}
	
	public static Optional<ApplicationDetailEntity> getApplicationDetailEntityNullPartDetails(){
		ApplicationDetailEntity applicationDetails = new ApplicationDetailEntity();
		
		applicationDetails.setSubType("Application1");
		Set<ValuesEntity> valuesList = new HashSet<>();
		
		ValuesEntity values= null;
		values = new ValuesEntity();
		values.setSubType("Application1");
		values.setValuesId(1);
		values.setValueString("CS");
		valuesList.add(values);		
		
		values = new ValuesEntity();
		values.setSubType("Application1");
		values.setValuesId(1);
		values.setValueString("DA");
		valuesList.add(values);	
		
		applicationDetails.setValuesEntity(valuesList);
		
		applicationDetails.setApplicationPartDetail(null);

		applicationDetails.setApplicationDescription("Test Application to run certain features in the vehicle");
		applicationDetails.setServiceable("Y");
		applicationDetails.setTestable("Y");
		Set<com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies> compAssemList = new HashSet<>();
		com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies compAssem = new com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies();
			compAssem.setAssyPN("SA-12-AAA");
			compAssemList.add(compAssem);
		
		applicationDetails.setCompatibleAssemblies(compAssemList);
		
		com.example.backendcode.BackEndCodeChallange.entity.FunctionalTypeValues funcTypVal = new com.example.backendcode.BackEndCodeChallange.entity.FunctionalTypeValues();
		funcTypVal.setFunctionalType("Custom Application");
		applicationDetails.setFunctionalTypeValues(funcTypVal);
		
		applicationDetails.setSellable("Y");
		applicationDetails.setResidentOnVehicle("Y");
		applicationDetails.setDigitallySigned("Generically Signed");
		applicationDetails.setConsumerViewable("Y");
		applicationDetails.setConsumerDownloadable("Y");
		applicationDetails.setDealerDownloadable("Y");
		applicationDetails.setOTAViewable("N");
		applicationDetails.setOTADownloadable("Y");
		
		return Optional.of(applicationDetails);
	}

	public static Optional<ApplicationDetailEntity> getApplicationDetailEntityNullMGMFile(){
		ApplicationDetailEntity applicationDetails = new ApplicationDetailEntity();
		com.example.backendcode.BackEndCodeChallange.entity.ApplicationPartDetail applicationPartDetail = new com.example.backendcode.BackEndCodeChallange.entity.ApplicationPartDetail();
		
		applicationDetails.setSubType("Application1");
		Set<ValuesEntity> valuesList = new HashSet<>();
		
		ValuesEntity values= null;
		values = new ValuesEntity();
		values.setSubType("Application1");
		values.setValuesId(1);
		values.setValueString("CS");
		valuesList.add(values);		
		
		values = new ValuesEntity();
		values.setSubType("Application1");
		values.setValuesId(1);
		values.setValueString("DA");
		valuesList.add(values);	
		
		applicationDetails.setValuesEntity(valuesList);
		
		applicationPartDetail.setFilePN("SA-11-TT");
		applicationPartDetail.setFrozenStatus("true");
		applicationPartDetail.setSuccessorPartNumber("SA-11-TS");
		
		applicationPartDetail.setMGMFile(null);
			
		applicationPartDetail.setVersion("1.0");
		applicationPartDetail.setRunTimeSize("1664508640");
		
		applicationDetails.setApplicationPartDetail(applicationPartDetail);

		applicationDetails.setApplicationDescription("Test Application to run certain features in the vehicle");
		applicationDetails.setServiceable("Y");
		applicationDetails.setTestable("Y");
		Set<com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies> compAssemList = new HashSet<>();
		com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies compAssem = new com.example.backendcode.BackEndCodeChallange.entity.CompatibleAssemblies();
			compAssem.setAssyPN("SA-12-AAA");
			compAssemList.add(compAssem);
		
		applicationDetails.setCompatibleAssemblies(compAssemList);
		
		com.example.backendcode.BackEndCodeChallange.entity.FunctionalTypeValues funcTypVal = new com.example.backendcode.BackEndCodeChallange.entity.FunctionalTypeValues();
		funcTypVal.setFunctionalType("Custom Application");
		applicationDetails.setFunctionalTypeValues(funcTypVal);
		
		applicationDetails.setSellable("Y");
		applicationDetails.setResidentOnVehicle("Y");
		applicationDetails.setDigitallySigned("Generically Signed");
		applicationDetails.setConsumerViewable("Y");
		applicationDetails.setConsumerDownloadable("Y");
		applicationDetails.setDealerDownloadable("Y");
		applicationDetails.setOTAViewable("N");
		applicationDetails.setOTADownloadable("Y");
		
		return Optional.of(applicationDetails);
		
	}
	
	public static ApplicationDetail getApplicationDetail(){
		ApplicationDetail applicationDetails = new ApplicationDetail();
		ApplicationPartDetail applicationPartDetail = new ApplicationPartDetail();
		
		applicationDetails.setSubType("Application1");
		
		applicationDetails.setValues(Arrays.asList("CS",
		        "DA",
		        "DE",
		        "FR-FR",
		        "PL",
		        "PT-PT",
		        "RU",
		        "SV",
		        "TR"));
		
		applicationPartDetail.setFilePN("SA-11-TT");
		applicationPartDetail.setFrozenStatus("True");
		applicationPartDetail.setSuccessorPartNumber("SA-11-TS");
		MGMFile mgmFile = new MGMFile();
		List<Protocol> protocols = new ArrayList<>();
			Protocol protocol = new Protocol();
			protocol.setNetworkWireless("NO");
			protocol.setNetworkProtocol("USB");
			protocols.add(protocol);
		mgmFile.setProtocol(protocols);

		mgmFile.setFileFormat("TAR.GZ");
		mgmFile.setChecksum("0xC7C1DA2F");
		mgmFile.setFileFingerprint("0x61192B821A9EA47D72DD360175C7A8EE");
		mgmFile.setROMSizeKB("1664508640");
		mgmFile.setSize("1664508640");
		mgmFile.setFileDateModified(Timestamp.valueOf(LocalDateTime.now()));
		
		applicationPartDetail.setMGMFile(mgmFile);
			
		applicationPartDetail.setVersion("1.0");
		applicationPartDetail.setRunTimeSize("1664508640");
		
		applicationDetails.setApplicationPartDetail(applicationPartDetail);

		applicationDetails.setApplicationDescription("Test Application to run certain features in the vehicle");
		applicationDetails.setServiceable("Y");
		applicationDetails.setTestable("Y");
		List<CompatibleAssemblies> compAssemList = new ArrayList<>();
			CompatibleAssemblies compAssem = new CompatibleAssemblies();
			compAssem.setAssyPN("SA-12-AAB");
			compAssemList.add(compAssem);
		
		applicationDetails.setCompatibleAssemblies(compAssemList);
		
		FunctionalTypeValues funcTypVal = new FunctionalTypeValues();
		funcTypVal.setFunctionalType("Custom Application");
		applicationDetails.setFunctionalTypeValues(funcTypVal);
		
		applicationDetails.setSellable("N");
		applicationDetails.setResidentOnVehicle("Y");
		applicationDetails.setDigitallySigned("Generically Signed");
		applicationDetails.setConsumerViewable("Y");
		applicationDetails.setConsumerDownloadable("Y");
		applicationDetails.setDealerDownloadable("Y");
		applicationDetails.setOTAViewable("Y");
		applicationDetails.setOTADownloadable("Y");
		
		return applicationDetails;
	}
}
