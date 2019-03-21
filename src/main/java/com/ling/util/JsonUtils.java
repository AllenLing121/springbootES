package com.ling.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class JsonUtils {
	private static  Log LOGGER = LogFactory.getLog(JsonUtils.class);
	private static ObjectMapper mapper = new ObjectMapper();
	
	static {
		JsonUtils.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDateTime.class,
				new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		javaTimeModule.addSerializer(LocalDate.class,
				new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
		javaTimeModule.addDeserializer(LocalDateTime.class,
				new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		javaTimeModule.addDeserializer(LocalDate.class,
				new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		javaTimeModule.addDeserializer(LocalTime.class,
				new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));

		JsonUtils.mapper.registerModules(javaTimeModule);
	}
	
	/**
	 * To json string.
	 *
	 * @param obj the obj
	 * @return the string
	 */
	public static String toJsonString(Object obj) {
		
		ByteArrayOutputStream out = null;
		
		try {
			
			out = new ByteArrayOutputStream();
			
			JsonUtils.mapper.writeValue(out, obj);
			
			byte[] bytes = out.toByteArray();
			
			return new String(bytes,"UTF-8");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
		}
		return null;
	}
	
	/**
	 * To object.
	 *
	 * @param <T> the generic type
	 * @param jsonString the json string
	 * @param cls the cls
	 * @return the t
	 */
	public static <T> T toObject(String jsonString, Class<T> cls) {
		
		try {
			return JsonUtils.mapper.readValue(jsonString, cls);
		}
		catch (Exception e) {
			JsonUtils.LOGGER.debug(jsonString);
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T toList(String jsonString, Class<T> cls) {
		
		try {
	        JavaType javaType = JsonUtils.mapper.getTypeFactory().constructParametricType(List.class, cls);
			return JsonUtils.mapper.readValue(jsonString, javaType);
		}
		catch (Exception e) {
			JsonUtils.LOGGER.debug(jsonString);
			e.printStackTrace();
		}
		return null;
	}
	
}
