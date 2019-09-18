package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.MedicalExam;


@Named
public class MedicalExamRepository implements Serializable{


	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public List<MedicalExam> findAll() throws Exception {
		List<MedicalExam> medicalExams = new ArrayList<>();

		TypedQuery<MedicalExam> query = em.createQuery("FROM MedicalExam me", MedicalExam.class);
		medicalExams = query.getResultList();

		return medicalExams;
	}

	
	
}
