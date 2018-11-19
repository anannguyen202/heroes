/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.example.heroes.rsp;

import com.example.heroes.common.Const;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseRsp {
	// region -- Fields --

	@JsonProperty(value = "status")
	private String status;

	@JsonProperty(value = "message")
	private String message;

	// end

	// region -- Get set --

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// end

	// region -- Methods --

	public BaseRsp() {
		this.status = Const.HTTP.STATUS_SUCCESS;
		this.message = "";
	}

	public BaseRsp(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public void setError(String message) {
		this.status = Const.HTTP.STATUS_ERROR;
		this.message = message;
	}

	// end
}