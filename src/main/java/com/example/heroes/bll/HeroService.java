package com.example.heroes.bll;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.heroes.dal.HeroDao;
import com.example.heroes.dal.UserDao;
import com.example.heroes.dto.ProfileDto;
import com.example.heroes.model.HeroModel;
import com.example.heroes.model.Users;

import ch.qos.logback.classic.Logger;

@Service(value = "heroService")
@Transactional
public class HeroService {
	// region -- Fields --

    private static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(HeroService.class);

	@Autowired
	private HeroDao heroDao;

	// end

	// region -- Methods --

	public int getTotalHero() {
		int res = heroDao.getTotalHero();
		return res;
	}

	public HeroModel getBy(int id) {
		HeroModel res = heroDao.getBy(id);
		return res;
	}

	public List<HeroModel> getHeroes() {
		List<HeroModel> res = heroDao.getHeroes();
		return res;
	}

	public List<HeroModel> searchBy(String name) {
		List<HeroModel> res = heroDao.searchBy(name);
		return res;
	}

	public String save(HeroModel m) {
		String res = "";

		Integer id = m.getId();
		String name = m.getName();

		HeroModel m1;
		
		if (id == null || id == 0) {
			heroDao.save(m);
	
		} else {
			m1 = heroDao.getBy(id);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
				m1.setName(name);
				heroDao.save(m1);
			}
		}

		return res;
	}

	public String delete(int id) {
		String res = "";

		HeroModel m = heroDao.getBy(id);
		if (m != null) {
//			m.setDeleted(true);
			heroDao.delete(m);
		}

		return res;
	}

}