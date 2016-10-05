package com.felix.util.logging;

public class SystemOutLogger implements LoggerInterface {

	@Override
	public void error(String message) {
		System.err.println(message);

	}

	@Override
	public void debug(String message) {
		System.out.println(message);
	}

	@Override
	public void info(String message) {
		System.out.println(message);
	}

	@Override
	public void warn(String message) {
		System.out.println(message);
	}

	@Override
	public void fatal(String message) {
		System.err.println(message);

	}

	@Override
	public void trace(String message) {
		System.out.println(message);
	}

	@Override
	public void configure(String configPath) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
