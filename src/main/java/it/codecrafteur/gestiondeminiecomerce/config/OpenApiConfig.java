package it.codecrafteur.gestiondeminiecomerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Panier API",
                description = "API de gestion de panier d'achat - Mini E-commerce",
                version = "1.0.0",
                contact = @Contact(
                        name = "CodeCrafteur",
                        email = "codecrafteur.it"
                )),
        servers = {
                @Server(url = "http://localhost:8090", description = "Serveur de developpement")
        })
public class OpenApiConfig {
}
