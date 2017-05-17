package edu.marshll.lihost.loader;

import java.net.URL;
import java.net.URLClassLoader;

/**This is a subclass of {@link URLClassLoader}, {@link BaseClassLoader} also follows
 * delegation modal that system loaders follow. However, in default, this class will not delegate  
 * to its parent unless call 
 * @author Xuejian Li
 *
 */
public class BaseClassLoader extends URLClassLoader{
	/*
	 * Whether this class loader delegate to its parent
	 */
	private boolean isDelegate=false;
	/*
	 * parent class loader 
	 */
	private ClassLoader parentLoader=null;
	
	public BaseClassLoader() {
		super(new URL[0]);
		
	}
	public BaseClassLoader(ClassLoader parentLoader){
		super(new URL[0], parentLoader);
	}
	public boolean isDelegate() {
		return isDelegate;
	}

	public void setDelegate(boolean isDelegate) {
		this.isDelegate = isDelegate;
	}

	public ClassLoader getParentLoader() {
		return parentLoader;
	}

	public void setParentLoader(ClassLoader parentLoader) {
		this.parentLoader = parentLoader;
	}
	/**
	 * This medthod will return a class instance according to class name,this method works as
	 * following steps:
	 * 1. Call findLoadedClass method to check cache
	 * 2. If isDelegate is true, delegate to parent class loader
	 */
	public Class loadClass(String className){
		Class clazz=null;
		clazz=findLoadedClass(className);
		if(clazz!=null){//exist
			return clazz;
		}
		if(isDelegate){//delegate to parent
			if(parentLoader==null){
				parentLoader=getSystemClassLoader();
			}
			
		}
		
		
		
		
		
		
		
	}


}
