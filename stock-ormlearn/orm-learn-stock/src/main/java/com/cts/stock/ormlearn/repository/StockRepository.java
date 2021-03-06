package com.cts.stock.ormlearn.repository;
import java.util.List;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.cts.stock.ormlearn.model.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

	@Query(value = "SELECT * FROM stock WHERE st_code='FB' and st_date>= '2019-09-01' and st_date<='2019-09-30'", nativeQuery = true)
	public List<Stock> findByCodeAndDateLike(String code, String datePattern);
	public List<Stock> findByCodeAndOpenGreaterThanAndCloseGreaterThan(String code, BigDecimal price1,BigDecimal price2);
	public List<Stock> findTop3ByOrderByVolumeDesc();
	public List<Stock> findTop3ByCodeOrderByClose(String code);

}
