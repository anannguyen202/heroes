package com.example.heroes.bll;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.heroes.dal.UserDao;
import com.example.heroes.dto.ProfileDto;
import com.example.heroes.model.UserModel;

@Service(value = "userService")
@Transactional
public class UserService {
	
	// region -- Fields --

	@Autowired
	private UserDao userDao;

	@PersistenceContext
	private EntityManager entityManager;

	// end

	// region -- Methods --
	
	public UserModel getBy(int id) {
		UserModel res = userDao.getBy(id);
		return res;
	}

	public UserModel getBy(String userName, String email) {
		UserModel res = userDao.getBy(userName, email);
		return res;
	}

	public UserModel getByPassword(String userName, String password) {
		UserModel res = userDao.getByPassword(userName, password);
		return res;
	}

	public String save(UserModel m) {
		String res = "";

		Integer id = m.getId();
		String userName = m.getUserName();
		String email = m.getEmail();

		UserModel m1;
		if (id == null || id == 0) {
			m1 = userDao.getBy(email);
			if (m1 != null) {
				res = "Duplicate data";
			} else {
//				m.setUuid(UUID.randomUUID());
//				m.setCreateBy(1);
//				m.setCreateOn(new Date());

				userDao.save(m);
			}
		} else {
			m1 = userDao.getBy(id);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
//				m1.setModifyBy(1);
//				m1.setModifyOn(new Date());

				m1.setFirstName(m.getFirstName());
				m1.setLastName(m.getLastName());
				m1.setEmail(m.getEmail());

				userDao.save(m1);
			}
		}

		return res;
	}

	public ProfileDto getProfile(int id) {
		ProfileDto res = new ProfileDto();

		UserModel m = userDao.getBy(id);
		res.setEmail(m.getEmail());
		res.setFirstName(m.getFirstName());
		res.setLastName(m.getLastName());
		res.setUserName(m.getUserName());

		return res;
	}

	public String delete(int id) {
		String res = "";

		UserModel m = userDao.getBy(id);
		if (m != null) {
//			m.setDeleted(true);
			userDao.save(m);
		}

		return res;
	}

}