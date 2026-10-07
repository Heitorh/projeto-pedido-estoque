package com.heitor.pedidoestoque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class PedidoestoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoestoqueApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner testConnection() {
		return args -> {
			String url = "jdbc:postgresql://localhost:5432/pedidoestoque";
			try (Connection conn = DriverManager.getConnection(url, "postgres", "password")) {
				System.out.println("==========================================");
				System.out.println("SUCESSO ABSOLUTO: CONEXAO JDBC FUNCIONOU!");
				System.out.println("==========================================");
			} catch (Exception e) {
				System.out.println("==========================================");
				System.out.println("FALHA NA CONEXAO: " + e.getMessage());
				System.out.println("==========================================");
			}
		};
	}*/

}
