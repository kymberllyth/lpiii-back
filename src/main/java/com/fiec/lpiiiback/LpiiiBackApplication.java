package com.fiec.lpiiiback;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class LpiiiBackApplication  {



	public static void main(String[] args) {
		try {
			 SpringApplication.run(LpiiiBackApplication.class, args);


			URL resource = new LpiiiBackApplication().getClass().getClassLoader()
					.getResource("tcc-fiec-3mod-firebase-adminsdk-zv6co-9a2eb44ff4.json");
			FileInputStream serviceAccount =
					new FileInputStream(resource.getPath());
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
