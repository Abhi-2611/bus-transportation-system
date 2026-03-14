// package com.transport.bus.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Contact;
// import io.swagger.v3.oas.models.info.Info;

// @Configuration
// public class OpenApiConfig {

//     @Bean
//     public OpenAPI busTransportationAPI() {

//         Contact contact = new Contact();
//         contact.setName("Bus Transportation System");
//         contact.setEmail("support@transport.com");

//         Info info = new Info()
//                 .title("Bus Transportation System API")
//                 .version("1.0")
//                 .description("API documentation for Bus Transportation System backend")
//                 .contact(contact);

//         return new OpenAPI().info(info);
//     }
// }


// // http://localhost:10002/swagger-ui/index.html
