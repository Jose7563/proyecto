package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.MedicalConsultation;



@Named
public class MedicalConsultationRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public Integer insert(MedicalConsultation medicalConsultation) throws Exception {
		em.persist(medicalConsultation);
		return medicalConsultation.getId();
	}
	
	
	public List<MedicalConsultation> findAll() throws Exception {
		List<MedicalConsultation> medicalConsultations = new ArrayList<>();

		TypedQuery<MedicalConsultation> query = em.createQuery("FROM MedicalConsultation mc", MedicalConsultation.class);
		medicalConsultations = query.getResultList();

		return medicalConsultations;
	}

}
