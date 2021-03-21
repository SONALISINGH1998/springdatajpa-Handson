package com.cts.stock.ormlearn.ormlearnstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import com.cts.stock.ormlearn.model.Stock;
import com.cts.stock.ormlearn.repository.StockRepository;
@SpringBootApplication
public class OrmLearnStockApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnStockApplication.class);
	@Autowired
	static StockRepository stockRepository;
	
	
	private static void getFacebookSep2019Data() {
		LOGGER.info("Start");
		List<Stock> stockList = stockRepository.findByCodeAndDateLike("FB","2019-9%");
		LOGGER.debug("stockList={}", stockList);
		LOGGER.info("End");
	}
	private static void getGooglPriceGreater1250Data() {
		LOGGER.info("Start");
		List<Stock> stockList = stockRepository.findByCodeAndOpenGreaterThanAndCloseGreaterThan("GOOGL", BigDecimal.valueOf(1250), BigDecimal.valueOf(1250));
		LOGGER.debug("stockList={}", stockList);
		LOGGER.info("End");
	}
	
	private static void getTop3VolumeData() {
		LOGGER.info("Start");
		List<Stock> stockList = stockRepository.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("stockList={}", stockList);
		LOGGER.info("End");
	}
	
	private static void getLeast3NetflixData() {
		LOGGER.info("Start");
		List<Stock> stockList = stockRepository.findTop3ByCodeOrderByClose("NFLX");
		LOGGER.debug("stockList={}", stockList);
		LOGGER.info("End");
	}

	public static void main(String[] args) {
		
	
		ApplicationContext context = SpringApplication.run(OrmLearnStockApplication.class, args);
		LOGGER.info("Inside main");
		getFacebookSep2019Data();
		getGooglPriceGreater1250Data();
		getTop3VolumeData();
		getLeast3NetflixData();
	}

}
