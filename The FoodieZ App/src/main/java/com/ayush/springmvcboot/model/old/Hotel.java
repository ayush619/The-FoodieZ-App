package com.ayush.springmvcboot.model.old;

//import java.util.List;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Hotel {

	private String name;
	private int hotelid;


	@Override
	public String toString() {
		return "Hotel [name=" + name + ", Menu=" + "]";
	}

	

	
	}

