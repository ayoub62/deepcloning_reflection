package com.ayoub.me;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Cloner {

	@SuppressWarnings("unchecked")
	public static Object solve(Object a) throws Exception {
		Object out = a.getClass().getConstructor().newInstance();
		if(a.getClass().getName().contains("List")){
			ArrayList<Object> arr = (ArrayList<Object>) a;
			ArrayList<Object> clList = new ArrayList<>();
			for(Object ob : arr){
				clList.add(solve(ob));
			}
			return clList;
		}
		
		List<String> methodes = (List<String>) a.getClass().getMethod("getSetters").invoke(out);
		for(String method : methodes){
			String getter = method.replaceAll("set", "get");
			Object val = getVal(a,getter);
			if(val == null)
				continue;
			
			 Method met = out.getClass().getDeclaredMethod(getter);
		     Type type = met.getGenericReturnType();
			if (isNotCloneableObject(type)) {
				out.getClass().getMethod(method, val.getClass()).invoke(out, val);
				continue;
			}
			out.getClass().getMethod(method, val.getClass()).invoke(out, solve(val));
		}
		return out;
	}
	
	public static boolean isNotCloneableObject(Type type) {
		String name = type.getTypeName();
		if(name.startsWith("java")){
			if(!name.contains("List"))
				return true;
			if(name.contains("java.lang"))
				return true;
			return false;
		}
		
		return false;
		
	}
	
	public static Object getVal(Object a, String meth) throws Exception {
		Object result = null;
		Method method = a.getClass().getMethod(meth);
		result = method.invoke(a);
		return result;
	}

}
