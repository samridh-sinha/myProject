package myGroup.myProject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Product;


public class App 
{ 
	
	
	
    public static void main( String[] args )
    {
       
        

		ObjectMapper map = new ObjectMapper();  
		File file = new File("Product.json");   
		
		try {
			Product[] products = map.readValue(file,Product[].class); 
			Map<String,Integer> uniqueCountMap = getUniqueProductCount(map,products);  
			Product[] prodList = getUniqueProducts(map, products);   
			System.out.println(uniqueCountMap);
			System.out.println("{");
			for(Product p : prodList) {
				System.out.println(" "+p.toString());
			}
			System.out.println("}");
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} 
		
		
    }

	
	private static Map<String,Integer> getUniqueProductCount(ObjectMapper map, Product[] products) throws StreamReadException, DatabindException, IOException {
		
	
		Map<String,Integer> countMap = new HashMap<>(); 
		
		for(Product p : products) {
			
			if(countMap.containsKey(p.getProductName())) {
				
				countMap.put(p.getProductName(), countMap.get(p.getProductName())+1); 
			} 
			else 
				countMap.put(p.getProductName(), 1);
				
			
		} 
		
		return countMap;   
		
		
		
	} 
	
	private static Product[] getUniqueProducts(ObjectMapper map, Product[] products) throws StreamReadException, DatabindException, IOException {
		
		
		Map<String,Product> productmap = new HashMap<>();  
		
		for(Product p : products) { 
			
			if(productmap.containsKey(p.getProductName())) {
				
				Product product = productmap.get(p.getProductName());  
				Integer quantity = product.getQuantity()+p.getQuantity(); 
				product.setQuantity(quantity); 
				productmap.put(p.getProductName(),product);
				
			} 
			else {
				
				productmap.put(p.getProductName(),p);
			} 
		} 
		
		 Product[] productlist = new Product[productmap.size()];  
		 
		 int i = 0;
		 for (Map.Entry<String, Product> entry : productmap.entrySet()) {
			 productlist[i++] = entry.getValue();
		 }
		 
		return productlist;
	 }
	}
