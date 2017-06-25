package UIModule;


import java.io.FileNotFoundException;

import UIModule.ActionListenersGenerator;
import UIModule.ElementGenerator;
import UIModule.LayoutGenerator;
import UIModule.MAIN;

public class AppInitializer {
	
	//01_ATTRIBUTES
	//*************************************************************
	private MAIN application;
	private ElementGenerator elements;
	private LayoutGenerator layout;
	private ActionListenersGenerator actionListeners;
	//private HotKeysInitializer hotKeys;
	
	
	//02_CONSTRUCTOR
	//*************************************************************
	public AppInitializer(MAIN application){
		this.application=application;
		elements=new ElementGenerator();
		layout=new LayoutGenerator(elements);
		actionListeners=new ActionListenersGenerator(elements);
		//hotKeys=new HotKeysInitializer(elements);
		
		
		
	}
	
	//03_METHODS
	//*************************************************************
	public void initialize() throws FileNotFoundException{
		elements.initialize();
		
		layout.initialize();
		application.setLayout(elements.getLayout());
		
		actionListeners.initialize();
		//hotKeys.initialize();
		
	}
	
	
}
