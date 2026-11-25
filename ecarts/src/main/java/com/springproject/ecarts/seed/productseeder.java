package com.springproject.ecarts.seed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springproject.ecarts.entity.product;
import com.springproject.ecarts.repository.productrepository;

@Component
public class productseeder  implements CommandLineRunner{

	@Autowired
	private productrepository productrepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if (productrepository.count()==0){
			List<product> demoProducts = List.of(

				    // MOBILE (4)
				    new product(null, "Vivo X200 Pro", 899.00, "Premium smartphone with ZEISS camera", "mobile", 4.9, "Amazon", 5),

				    new product(null, "Oppo Reno 13 Pro", 549.00, "AI powered smartphone with AMOLED display", "mobile", 4.6, "Flipkart", 55),

				    new product(null, "Realme GT 7 Pro", 699.00, "Gaming smartphone with Snapdragon processor", "mobile", 4.7, "Realme", 43),

				    new product(null, "Samsung Galaxy S24", 799.00, "Flagship smartphone with advanced camera", "mobile", 4.8, "Samsung", 30),

				    // LAPTOP (3)
				    new product(null, "Dell Inspiron 15", 750.00, "Laptop with Intel Core i5 processor", "laptop", 4.5, "Dell", 20),

				    new product(null, "HP Pavilion 14", 820.00, "Laptop for office and personal use", "laptop", 4.6, "HP", 15),

				    new product(null, "MacBook Air M3", 1299.00, "Apple laptop with M3 chip", "laptop", 4.9, "Apple", 10),

				    // AUDIO (2)
				    new product(null, "Sony WH-1000XM5", 349.00, "Wireless noise cancelling headphones", "audio", 4.9, "Sony", 40),

				    new product(null, "JBL Flip 6", 129.00, "Portable Bluetooth speaker", "audio", 4.5, "JBL", 35),

				    // EARPHONES (2)
				    new product(null, "Boat Airdopes 141", 25.00, "Wireless Bluetooth earbuds", "earphones", 4.3, "Boat", 60),

				    new product(null, "Samsung Galaxy Buds 3", 149.00, "Premium wireless earbuds", "earphones", 4.6, "Samsung", 22),

				    // SMARTWATCH (1)
				    new product(null, "Apple Watch Series 10", 399.00, "Smartwatch with health tracking", "smartwatch", 4.8, "Apple", 18),

				    // TABLET (1)
				    new product(null, "iPad Air M2", 599.00, "Tablet for entertainment and productivity", "tablet", 4.7, "Apple", 12),

				    // KEYBOARD (1)
				    new product(null, "Logitech K380", 39.00, "Wireless Bluetooth keyboard", "keyboard", 4.4, "Logitech", 50),

				    // MOUSE (1)
				    new product(null, "Logitech MX Master 3S", 99.00, "Wireless ergonomic computer mouse", "mouse", 4.8, "Logitech", 30)

				);
			
			productrepository.saveAll(demoProducts);
			System.out.println("successfully seed the dempproducts");
	    
		}else {
			System.out.println("products already exists");
		}
	}

}
