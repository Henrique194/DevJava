package mjv.handler;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseError {
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime time;
	
	private String status = "error";
	
	private int statusCode = 400;
	
	private String error = "error";

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
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
