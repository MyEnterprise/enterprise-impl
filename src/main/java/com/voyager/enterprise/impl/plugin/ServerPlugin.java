package com.voyager.enterprise.impl.plugin;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Function;

import com.voyager.enterprise.plugin.entity.Emitter;
import com.voyager.enterprise.plugin.entity.Plugin;
import com.voyager.enterprise.plugin.entity.PluginManager;
import com.voyager.enterprise.server.Server;

public class ServerPlugin implements PluginManager {

	@Override
	public PluginManager register(Object eventFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginManager register(Method eventMethod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginManager register(String nameEvent, Function eventFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enablePlugin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disablePlugin() {
		// TODO Auto-generated method stub

	}

	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getDataFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getConfigGlobal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDB() {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Plugin> findPluginByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Plugin> findPluginByPackage(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Class<?>> findPluginDependency(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Emitter emit() {
		// TODO Auto-generated method stub
		return null;
	}

}
