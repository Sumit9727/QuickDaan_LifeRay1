package com.crowd.funding.database.service.persistence.impl;

import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.impl.ProjectRegistrationImpl;
import com.crowd.funding.database.service.persistence.ProjectRegistrationFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;

public class ProjectRegistrationFinderImpl extends ProjectRegistrationFinderBaseImpl  implements ProjectRegistrationFinder {

	public List<ProjectRegistration> findByProjectCreationDate(String creationDate) {
		
		Session session = null;
		try {
			session = openSession();
			
			//String sql = "SELECT * 	FROM cf_project_master WHERE DATE(CREATION_DATE) = DATE (?)";
			String sql = CustomSQLUtil.get(getClass(), "projectByCreationDateQuery");
			
			
			SQLQuery sqlQueryObject = session.createSQLQuery(sql);
			sqlQueryObject.setCacheable(false);
			sqlQueryObject.addEntity("ProjectRegistration", ProjectRegistrationImpl.class);
			
			QueryPos queryPos = QueryPos.getInstance(sqlQueryObject);
			queryPos.add(creationDate);
			
			return (List<ProjectRegistration>) sqlQueryObject.list();
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			   closeSession(session);
		 }
		return null;
	}
	
	public List<ProjectRegistration> findProjectBetweenCreationDateQuery(String startCreationDate , String endCreationDate) {
		
		Session session = null;
		try {
			session = openSession();
			
			//String sql = "SELECT * 	FROM cf_project_master WHERE DATE(CREATION_DATE) BETWEEN  DATE (?) AND DATE (?)";
			String sql = CustomSQLUtil.get(getClass(), "projectByBetweenCreationDateQuery");
			
			SQLQuery sqlQueryObject = session.createSQLQuery(sql);
			sqlQueryObject.setCacheable(false);
			sqlQueryObject.addEntity("ProjectRegistration", ProjectRegistrationImpl.class);
			
			QueryPos queryPos = QueryPos.getInstance(sqlQueryObject);
			queryPos.add(startCreationDate);
			queryPos.add(endCreationDate);
			
			return (List<ProjectRegistration>) sqlQueryObject.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<ProjectRegistration> findprojectByBenificiaryIdCreationDate(long benificiaryId, String creationDate) {
		
		Session session = null;
		try {
			session = openSession();
			
			//String sql = "SELECT * 	FROM cf_project_master WHERE DATE(CREATION_DATE) BETWEEN  DATE (?) AND DATE (?)";
			String sql = CustomSQLUtil.get(getClass(), "projectByBenificiaryIdCreationDateQuery");
			
			SQLQuery sqlQueryObject = session.createSQLQuery(sql);
			sqlQueryObject.setCacheable(false);
			sqlQueryObject.addEntity("ProjectRegistration", ProjectRegistrationImpl.class);
			
			QueryPos queryPos = QueryPos.getInstance(sqlQueryObject);
			queryPos.add(benificiaryId);
			queryPos.add(creationDate);
			
			return (List<ProjectRegistration>) sqlQueryObject.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<ProjectRegistration> findprojectByBenificiaryIdStatusCreationDate(long benificiaryId, int status, String creationDate) {
		
		Session session = null;
		try {
			session = openSession();
			
			//String sql = "SELECT * 	FROM cf_project_master WHERE DATE(CREATION_DATE) BETWEEN  DATE (?) AND DATE (?)";
			String sql = CustomSQLUtil.get(getClass(), "projectByBenificiaryIdStatusCreationDateQuery");
			
			SQLQuery sqlQueryObject = session.createSQLQuery(sql);
			sqlQueryObject.setCacheable(false);
			sqlQueryObject.addEntity("ProjectRegistration", ProjectRegistrationImpl.class);
			
			QueryPos queryPos = QueryPos.getInstance(sqlQueryObject);
			queryPos.add(benificiaryId);
			queryPos.add(status);
			queryPos.add(creationDate);
			
			return (List<ProjectRegistration>) sqlQueryObject.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeSession(session);
		}
		return null;
	}

	public List<ProjectRegistration> findprojectByStatusCreationDate(int status, String creationDate) {
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(getClass(), "projectByStatusCreationDateQuery");
			
			SQLQuery sqlQueryObject = session.createSQLQuery(sql);
			sqlQueryObject.setCacheable(false);
			sqlQueryObject.addEntity("ProjectRegistration", ProjectRegistrationImpl.class);
			
			QueryPos queryPos = QueryPos.getInstance(sqlQueryObject);
			queryPos.add(status);
			queryPos.add(creationDate);
			
			return (List<ProjectRegistration>) sqlQueryObject.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeSession(session);
		}
		return null;
	}

}
