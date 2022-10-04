package com.fiec.lpiiiback;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class LpiiiBackApplication  {

	public static void main(String[] args) {
		SpringApplication.run(LpiiiBackApplication.class, args);
		try {
			FileInputStream serviceAccount =
					new FileInputStream( System.getenv("HOMEPATH") +
							"\\Downloads\\tcc-fiec-3mod-firebase-adminsdk-zv6co-b492127104.json");
			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					//.setDatabaseUrl("https://tcc-fiec-3mod-default-rtdb.firebaseio.com/")
					.build();

			FirebaseApp.initializeApp(options);
			Files.createDirectory(Paths.get("uploads"));
		} catch (IOException e) {

		}
	}



}
