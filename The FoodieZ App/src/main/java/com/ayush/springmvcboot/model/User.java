package com.ayush.springmvcboot.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User
{
	@NonNull
	private String name;

	@MongoId
	@Indexed(unique = true)
	private String email;

	@NonNull
	private String password;

}
