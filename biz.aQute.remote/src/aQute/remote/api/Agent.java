package aQute.remote.api;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.osgi.framework.dto.BundleDTO;
import org.osgi.framework.dto.FrameworkDTO;

public interface Agent {
	public static final int DEFAULT_PORT = 29998;

	boolean isEnvoy();

	FrameworkDTO getFramework() throws Exception;

	BundleDTO install(String location, String sha) throws Exception;

	String start(long... id) throws Exception;

	String stop(long... id) throws Exception;

	String uninstall(long... id) throws Exception;

	String update(Map<String, String> bundles) throws Exception;

	boolean redirect(boolean on) throws Exception;

	boolean stdin(String s) throws Exception;

	String shell(String cmd) throws Exception;

	Map<String, String> getSystemProperties() throws Exception;

	int createFramework(String name, Collection<String> runpath,
			Map<String, Object> properties) throws Exception;

	boolean abort() throws IOException;
}
