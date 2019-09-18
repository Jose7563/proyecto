package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.model.entity.MedicalExam;
import com.hampcode.model.repository.MedicalExamRepository;

@Named
public class MedicalExamBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MedicalExamRepository medicalExamRepository;

	public List<MedicalExam> getAllMedicalExams() throws Exception {
		return medicalExamRepository.findAll();
	}

}
