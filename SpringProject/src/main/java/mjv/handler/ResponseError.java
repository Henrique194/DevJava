package mjv.handler;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseError {
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate time;
	
	private String status = "error";
	
	private int statusCode = 400;
	
	private String error = "error";

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
