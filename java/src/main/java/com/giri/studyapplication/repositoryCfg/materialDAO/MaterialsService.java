package com.giri.studyapplication.repositoryCfg.materialDAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialsService {

	// private SessionFactory sessionFactory;
	private EntityManager em;

	@Autowired
	public MaterialsService(/* SessionFactory sessionFactory, */ EntityManager em) {
		// this.sessionFactory = sessionFactory;
		this.em = em;
	}

	public MaterialsService() {
		super();
	}

	public List<?> getMaterial() {
		return this.em.createNativeQuery("select *from material").getResultList();
	}
	/*
	 * List<?> li=null; try {
	 * li=this.sessionFactory.openSession().createSQLQuery("select *from material").
	 * addEntity(Material.class).getResultList(); } catch (Exception e) { li=null; }
	 * return li; }
	 */
}
