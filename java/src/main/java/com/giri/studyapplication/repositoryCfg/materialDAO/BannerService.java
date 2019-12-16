package com.giri.studyapplication.repositoryCfg.materialDAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {

	public BannerService() {
		super();
	}

	// private SessionFactory sessionFactory;
	private EntityManager em;

	@Autowired
	public BannerService(/* SessionFactory sessionFactory, */ EntityManager em) {
		// this.sessionFactory = sessionFactory;
		this.em = em;
	}

	public List<?> getBannerNames() {
		return this.em
				.createNativeQuery("SELECT  wm_id,  seq_no,  internal_name,display_name FROM public.v_banner_teplate")
				.getResultList();
		// return this.sessionFactory.openSession()
		// .createSQLQuery("SELECT wm_id, seq_no, internal_name,display_name FROM
		// public.v_banner_teplate")
		// .addEntity(Banner.class).getResultList();
	}

}
