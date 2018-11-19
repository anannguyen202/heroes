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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.heroes.bll.UserService;
import com.example.heroes.model.UserModel;
import com.example.heroes.req.UserSignInReq;
import com.example.heroes.req.UserSignUpReq;
import com.example.heroes.rsp.MultipleRsp;
import com.example.heroes.rsp.SingleRsp;

@RestController
@RequestMapping("/user")
public class UserController {
	// region -- Fields --

	@Autowired
	private UserService userService;

	// end

	// region -- Methods --

	/**
	 * Request new token to log in (just and only when enable login authentication,
	 * user name & password have existed in db)
	 * 
	 * @param req include (user name, password)
	 * @return
	 */
	@PostMapping("/sign-in")
	public ResponseEntity<?> signIn(@RequestBody UserSignInReq req) {
		MultipleRsp res = new MultipleRsp();

		try {
			// Get data
			String userName = req.getUserName();
			String password = req.getPassword();

			// Handle
			UserModel m = userService.getByPassword(userName, password);
			if (m == null) {
				res.setError("User name doesn't exist!");
			} else {
				userName = m.getUserName();
				int userId = m.getId();

				// Set data
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("key", userName);
				
				res.setResult(data);
			}
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody UserSignUpReq req) {
		SingleRsp res = new SingleRsp();

		try {
			// Get data
			String userName = req.getUserName();
			String email = req.getEmail();
			String firstName = req.getFirstName();
			String lastName = req.getLastName();

			String password = req.getPassword();

			// Convert data
			UserModel m = new UserModel();
			m.setEmail(email);
			m.setFirstName(firstName);
			m.setLastName(lastName);
			m.setPassword(password);
			m.setUserName(userName);

			// Handle
			String tmp = userService.save(m);

			if (tmp.isEmpty()) {
				// Set Data
				res.setResult(tmp);
				res.setMessage("Register success!");
			} else {
				res.setError("User name or email have already registed!");
			}
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

//	@GetMapping("/view")
//	public ResponseEntity<?> view(@RequestHeader HttpHeaders header) {
//		SingleRsp res = new SingleRsp();
//
//		try {
//			PayloadDto pl = Utils.getTokenInfor(header);
//			int id = pl.getId();
//
//			// Handle
//			ProfileDto m = userService.getProfile(id);
//
//			// Set data
//			res.setResult(m);
//		} catch (Exception ex) {
//			res.setError(ex.getMessage());
//		}
//
//		return new ResponseEntity<>(res, HttpStatus.OK);
//	}

	// end
}