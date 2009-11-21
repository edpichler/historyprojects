package test.com.appegine;

import java.util.HashMap;
import java.util.Map;

public class TestEnvironment implements
		com.google.apphosting.api.ApiProxy.Environment {
	public String getAppId() {
		return "Unit Tests";

	}

	public String getVersionId() {
		return "1.0";
	}

	public void setDefaultNamespace(String s) {
	}

	public String getRequestNamespace() {
		return null;
	}

	public String getDefaultNamespace() {
		return null;
	}

	public String getAuthDomain() {
		return null;
	}

	public boolean isLoggedIn() {
		return false;
	}

	public String getEmail() {
		return null;
	}

	public boolean isAdmin() {
		return false;
	}

	@Override
	public Map<String, Object> getAttributes() {
		Map<String, Object> map = new HashMap<String, Object>();

		return map;
	}
}