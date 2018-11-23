/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.example.heroes.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.heroes.bll.HeroService;
import com.example.heroes.bll.UserService;
import com.example.heroes.model.HeroModel;
import com.example.heroes.model.Users;
import com.example.heroes.req.HeroReq;
import com.example.heroes.req.UserSignInReq;
import com.example.heroes.req.UserSignUpReq;
import com.example.heroes.rsp.MultipleRsp;
import com.example.heroes.rsp.SingleRsp;
import com.example.heroes.common.Utils;
import com.example.heroes.dto.PayloadDto;

import java.util.List;


@RestController
@RequestMapping("/hero")
public class HeroController {
	// region -- Fields --

	@Autowired
	private HeroService heroService;

	// end

	// region -- Methods --

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<?> searchBy(
			@RequestHeader HttpHeaders header,
			@RequestParam(value = "name", required = true) String name
		) {
		SingleRsp res = new SingleRsp();

		try {
			// Handle
			String nameLowerCase = name.toLowerCase();
			List<HeroModel> m = heroService.searchBy(nameLowerCase);
		
			res.setResult(m);
			
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<?> getHeroes(@RequestHeader HttpHeaders header) {
		MultipleRsp res = new MultipleRsp();

		try {
			// Handle
			List<HeroModel> m = heroService.getHeroes();
			
			Map<String, Object> data = new LinkedHashMap<>();
			
			data.put("total", heroService.getTotalHero());
//			data.put("list", m);
			data.put("list", heroService.getHeroesFunc());
		
			res.setResult(data);
			
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getHero(
			@RequestHeader HttpHeaders header, 
			@PathVariable("id") int id
		) {
		SingleRsp res = new SingleRsp();

		try {
			PayloadDto pl = Utils.getTokenInfor(header);
			int userId = pl.getId();
			
			// Handle
			HeroModel m = heroService.getBy(id);
		
			res.setResult(m);
			
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addHero(@RequestBody HeroReq req) {
		SingleRsp res = new SingleRsp();
		
		// Get data
		String name = req.getName();

		// Convert data
		HeroModel m = new HeroModel();
		m.setName(name);

		try {
			// Handle
			String tmp = heroService.save(m);

			if (tmp.isEmpty()) {
				// Set Data
				res.setResult(tmp);
				res.setMessage("Add success!");
			} else {
				res.setError("have already!");
			}
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteHero(@RequestBody HeroReq req) {
		SingleRsp res = new SingleRsp();
		
		// Get data
		int id = req.getId();

		try {
			// Handle
			String tmp = heroService.delete(id);

			if (tmp.isEmpty()) {
				// Set Data
				res.setResult(tmp);
				res.setMessage("Delete success!");
			} else {
				res.setError("have already!");
			}
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	// end
}