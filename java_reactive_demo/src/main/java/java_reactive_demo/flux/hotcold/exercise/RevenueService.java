package java_reactive_demo.flux.hotcold.exercise;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;

public class RevenueService {
	
	private Map<String, Double> db = new HashMap<>();
	
	public RevenueService() {
		db.put("Kids", 0.0);
		db.put("Clothing", 0.0);
	}
	
	public Consumer<PurchaseOrder> consumeOrderStreaming(){
		return p -> {
			System.out.println("order---" + p);
			db.computeIfPresent(p.getCategory(), (k,v) -> v + p.getPrice());
		};
	}
	
	public Flux<String> getRevenue(){
		return Flux.interval(Duration.ofSeconds(2))
			.map(x -> db.toString());
	}
	
	
	

}
