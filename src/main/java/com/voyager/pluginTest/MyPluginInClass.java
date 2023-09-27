package com.voyager.pluginTest;

import com.voyager.enterprise.plugin.entity.Emitter;
import com.voyager.enterprise.plugin.entity.Plugin;
import com.voyager.enterprise.plugin.entity.PluginManager;

public class MyPluginInClass implements Plugin{

	@Override
	public void initialize(PluginManager manager) {
		System.out.println(" Plugin INTERNAL load !!!! ");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emit(Emitter emit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPluginDescription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reloadConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getName() {
		// TODO Auto-generated method stub
		
	}

}
