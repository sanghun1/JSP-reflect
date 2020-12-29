package app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dto.JoinDto;
import dto.LoginDto;

public class ReflectApp {
	
	static <T> void myReflect(T dto) {
		Method[] methods = dto.getClass().getMethods();
		
		for (Method method : methods) {
//			System.out.println(method.getName());
		}
		Field[] fs = dto.getClass().getDeclaredFields(); 
		for (Field f : fs) {
			f.setAccessible(true);
			
			try {
				Object o = f.get(dto);
				System.out.println(o);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}

	public static void main(String[] args) {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("ssar");
		loginDto.setPassword("1234");
		
		JoinDto joinDto = new JoinDto();
		joinDto.setUsername("ssar");
		joinDto.setPassword("1234");
		joinDto.setEmail("ssar@nate.com");
		
		myReflect(joinDto);
	}

}
