package order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8090/book/";

    @GetMapping("/book/order/{title}")
    public ResponseEntity<String> placeOrderForBook(@PathVariable String title) {
        String bookUrl = BASE_URL + title;
        ResponseEntity<String> response = restTemplate.getForEntity(bookUrl, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Order Created!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book not found.");
        }
    }
}

