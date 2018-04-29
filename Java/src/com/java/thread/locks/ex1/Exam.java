package com.java.thread.locks.ex1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.java8.defaults.TestDefault;

public class Exam {

	public Map<Warehouse, Map<String, Integer>> getInventoryAllocation(Map<String, Integer> shoppingCart,
			Address addressOfCustomer) {

		GivenMethod givenMethod = new GivenMethod();
		Map<Warehouse, Map<String, Integer>> InventoryAllocationMap = new LinkedHashMap<Warehouse, Map<String, Integer>>();

		List<Warehouse> warehouseSortedList = givenMethod.getNearestWarehouses(addressOfCustomer);

		for (String productId : shoppingCart.keySet()) {
			
			Map<Warehouse, Integer> inventory = givenMethod.getInventory(productId);
			int quantity = shoppingCart.get(productId);
			
			for (Warehouse warehouse : warehouseSortedList) {
				
				if(!InventoryAllocationMap.containsKey(warehouse)) {
					InventoryAllocationMap.put(warehouse,new LinkedHashMap<String, Integer>());
				}
				
				int avalibleQuantity = inventory.get(warehouse);
				if(quantity <= avalibleQuantity) {
					InventoryAllocationMap.get(warehouse).put(productId,quantity);
					inventory.put(warehouse,avalibleQuantity-quantity);
					break;
				}else {
					InventoryAllocationMap.get(warehouse).put(productId,avalibleQuantity);
					inventory.put(warehouse,quantity-avalibleQuantity);
				}
				
			}
		}

		return InventoryAllocationMap;
	}
}

enum Warehouse {
	EDMONTON, MONTREAL, TORONTO, VANCOUVER
}

class Address {

}

class GivenMethod {

	public List<Warehouse> getNearestWarehouses(Address addressOfCustomer) {
		return null;
	};

	public Map<Warehouse, Integer> getInventory(String product) {
		return null;

	};
}