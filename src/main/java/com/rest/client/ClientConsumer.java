package com.rest.client;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.rest.client.model.Product;

@Controller
public class ClientConsumer {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@RequestMapping(value="/welcome")
	public String welcome(Model model) {
		System.out.println("Print");
		String url = "http://localhost:8080/api/listProducts";
		List<LinkedHashMap> products = restTemplate.getForObject(url, List.class);
		//System.out.println(products.get(0).getProductName());
		
		model.addAttribute("products", products);
		
		return "listProduct";
	}
	
//	@RequestMapping(value="/createProduct")
//	public String createProductGet(Model model) {
//		
//		Product product = new Product();
//		model.addAttribute("products", product);
//		
//		return "createProduct";
//	}
//	
//	@PostMapping(value="/createProduct")
//	public String createProduct(Model model) {
//		System.out.println("Print");
//		String url = "http://localhost:8080/api/listProducts";
//		List<LinkedHashMap> products = restTemplate.getForObject(url, List.class);
//		//System.out.println(products.get(0).getProductName());
//		
//		model.addAttribute("products", products);
//		
//		return "listProduct";
//	}

	

}
