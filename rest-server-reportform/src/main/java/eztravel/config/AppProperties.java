/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: eztravel.config
 * @FileName: AppProperties.java
 * @date: 2015/1/7, 上午 09:31:39
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
package eztravel.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import tw.com.eztravel.ezlogger.Logger;
import tw.com.eztravel.ezlogger.LoggerFactory;

/**
 * <pre>
 * AppProperties, TODO: add Class Javadoc here.
 * </pre>
 * 
 */
@Configuration
public class AppProperties {

  /**
   * Property placeholder configurer.
   * 
   * @return the property placeholder configurer
   */
  @Bean
  public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
    PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
    String location = System.getenv("TEMPLATE_CONF");
    Resource[] resource = new Resource[1];

    // 若未設定環境變數也不直接讀取專案內的，避免讀取到錯誤的設定檔
//    if (location == null) {
      location = "template.properties";
      resource[0] = new ClassPathResource(location);
      logger.info("Use config file: classpath:" + location);
//    } else {
//      resource[0] = new FileSystemResource(location + "/jboss/template.properties");
//      logger.info("Use config file: " + location + "/jboss/template.properties");
//    }
    configurer.setLocations(resource);
    return configurer;
  }

  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(AppProperties.class);
}
