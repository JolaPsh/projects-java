package crudapplication;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;

/**
 * Created by Joanna Pakosh on 06, 2018
 */

@SpringBootApplication
public class CrudApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	/*
	 * Script execution with ibatis
	 */
	@Override
	public void run(String... args) throws Exception {
		String script = "D:/app/src/main/resources/schema.sql";
		ScriptRunner scriptRunner = new ScriptRunner(DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root"));
        scriptRunner.runScript(new BufferedReader(new FileReader(script)));

	}

}
