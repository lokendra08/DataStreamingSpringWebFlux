package com.wissen.datastreaming.repository;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.wissen.datastreaming.model.UserTradingTransactions;
import com.wissen.datastreaming.utils.UserTradingTransactionsGenerator;

import reactor.core.publisher.Flux;

@Repository
public class TradingReactiveRepository {
	
	 public Flux<UserTradingTransactions> findAll() {
	        //simulate data streaming every 2 second.
	        return Flux.interval(Duration.ofSeconds(2))
	                .onBackpressureDrop()
	                .map(this::generateUserTradingTransactions);
	                //.flatMapIterable(x -> x);
	    }
	 
	   private UserTradingTransactions generateUserTradingTransactions(long interval) {

	    	UserTradingTransactions userTradingTransactions = new UserTradingTransactions(UserTradingTransactionsGenerator.randomUsers(), 
	    			                                                  UserTradingTransactionsGenerator.randomScurites(), 
	    			                                                  UserTradingTransactionsGenerator.randomCurrentPosition());
	        return userTradingTransactions;

	    }

	   /* private List<UserTradingTransactions> generateUserTradingTransactions(long interval) {

	    	UserTradingTransactions obj = new UserTradingTransactions(UserTradingTransactionsGenerator.randomUsers(), 
	    			                                                  UserTradingTransactionsGenerator.randomScurites(), 
	    			                                                  UserTradingTransactionsGenerator.randomCurrentPosition());
	        return Arrays.asList(obj);

	    }*/

}
