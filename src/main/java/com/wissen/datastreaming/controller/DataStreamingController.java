package com.wissen.datastreaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.datastreaming.model.UserTradingTransactions;
import com.wissen.datastreaming.repository.TradingReactiveRepository;

import reactor.core.publisher.Flux;

@RestController
public class DataStreamingController {
	     @Autowired
	    private TradingReactiveRepository tradingReactiveRepository;

	    @GetMapping(path = "/tradedata/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	    public Flux<UserTradingTransactions> getUserTradingTransations() {
	        return this.tradingReactiveRepository.findAll();
	    }
}
