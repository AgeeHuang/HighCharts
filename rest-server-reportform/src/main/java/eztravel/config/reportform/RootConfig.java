/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: eztravel.config.reportform
 * @FileName: RootConfig.java
 * @date: 2015/1/7, 下午 03:47:16
 * 
 * <pre>
 *  Copyright 2013-2014 The ezTravel Co., Ltd. all rights reserved.
 *
 *  NOTICE:  All information contained herein is, and remains
 *  the property of ezTravel Co., Ltd. and its suppliers,
 *  if any.  The intellectual and technical concepts contained
 *  herein are proprietary to ezTravel Co., Ltd. and its suppliers
 *  and may be covered by TAIWAN and Foreign Patents, patents in 
 *  process, and are protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material
 *  is strictly forbidden unless prior written permission is obtained
 *  from ezTravel Co., Ltd.
 *  </pre>
 */
package eztravel.config.reportform;


import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import eztravel.config.AppProperties;
import eztravel.config.server.CommonRootConfig;
import eztravel.core.service.reportform.ReportformService;
import eztravel.core.service.reportform.impl.ReportformServiceImpl;
import eztravel.persistence.repository.reportform.ReportformRepository;


/**
 * <pre>
 * RootConfig,
 * </pre>
 * 
 * .
 * 
 */
@Configuration
@Import({AppProperties.class})
@EnableTransactionManagement
@MapperScan({"eztravel.persistence.repository.reportform"})
public class RootConfig extends CommonRootConfig {

  /** The Constant logger. */
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(RootConfig.class);

  /**
   * reportform service.
   * 
   * @param reportformRepository the reportform repository
   * @return the reportform service
   */
  @Bean
  public ReportformService reportformService(ReportformRepository reportformRepository) {
    return new ReportformServiceImpl(reportformRepository);
  }

  /**
   * Transaction manager.
   * 
   * @param dataSource the data source
   * @return the data source transaction manager
   */
  @Bean
  public DataSourceTransactionManager transactionManager(DataSource dataSource) {;
    DataSourceTransactionManager txManager = new DataSourceTransactionManager();
    txManager.setDataSource(dataSource);
    return txManager;
  }

}
