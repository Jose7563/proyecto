package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.dto.MedicalConsultationExamDto;
import com.hampcode.model.entity.MedicalConsultation;
import com.hampcode.model.repository.ConsultationExamRepository;
import com.hampcode.model.repository.MedicalConsultationRepository;


@Named
public class MedicalConsultationBusiness  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MedicalConsultationRepository medicalConsultationRepository;
	
	@Inject
	private ConsultationExamRepository consultationExamenRepository;
	
	@Transactional
	public MedicalConsultation insertMedicalConsultation(MedicalConsultationExamDto medicalConsultationDto) throws Exception {
		
	
		medicalConsultationDto
		       .getMedicalConsultation()
		       .getMedicalConsultationItems()
		       .forEach(item -> 
		            item.setMedicalConsultation(medicalConsultationDto.getMedicalConsultation()));
		
		medicalConsultationRepository.insert(medicalConsultationDto.getMedicalConsultation());
		
		
		medicalConsultationDto.getMedicalExams()
		              .forEach(exam-> {
						try {
							consultationExamenRepository
									  .insert(medicalConsultationDto.getMedicalConsultation().getId(), exam.getId());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		  );
		
		return medicalConsultationDto.getMedicalConsultation();
		
	}
	
	
	
	public List<MedicalConsultation> getAllMedicalConsultation()throws Exception{
		
		return medicalConsultationRepository.findAll();
	}
	

}
