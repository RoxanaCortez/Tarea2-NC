package com.uca.capas.tarea2.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	//URL: http://localhost:8080/informacion
	@RequestMapping("/informacion")
	public @ResponseBody String informacion() {
		String info = "Roxana Cortéz 00502211  Ing. Informática 4° año";
		return info;
	}
	
	//URL: http://localhost:8080/nombreDia?dia=16&mes=4&anio=2020
	@RequestMapping("/nombreDia")
	public @ResponseBody String nombreDia(HttpServletRequest request) {
		Integer dia = Integer.parseInt(request.getParameter("dia"));
		Integer mes = Integer.parseInt(request.getParameter("mes"));
		Integer anio = Integer.parseInt(request.getParameter("anio"));
		
		String nombre = " ";
		
		Calendar calendar = new GregorianCalendar(anio, mes - 1, dia); 
        int n = calendar.get(Calendar.DAY_OF_WEEK);
	  
        switch (n){
	    	case 1: nombre = "Domingo";
	        	break;
	    	case 2: nombre = "Lunes";
	            break;
	        case 3: nombre = "Martes";
	            break;
	        case 4: nombre = "Miercoles";
	            break;
	        case 5: nombre = "Jueves";
	            break;
	        case 6: nombre = "Viernes";
	            break;
	        case 7: nombre = "Sabado";
	            break;
	    }
        return "Dia: "+ nombre;
	}
}
