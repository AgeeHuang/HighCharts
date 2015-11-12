/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: eztravel.config.payment
 * @FileName: ServletConfig.java
 * @date: 2015/1/7, 上午 09:31:11
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

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

import eztravel.config.server.CommonServletConfig;

/**
 * <pre>
 * ServletConfig,
 * </pre>
 * 
 * .
 */
@Configuration
@ComponentScan(basePackages = {"eztravel.rest.controller"})
public class ServletConfig extends CommonServletConfig {

  /*
   * (non-Javadoc)
   * 
   * @see eztravel.config.server.CommonServletConfig#addFormatters(org.springframework
   * .format.FormatterRegistry)
   */
  @Override
  public void addFormatters(FormatterRegistry registry) {
    super.addFormatters(registry);
  }

  /*
   * (non-Javadoc)
   * 
   * @see eztravel.config.server.CommonServletConfig#addPackagesToScan(java.lang .String[])
   */
  @Override
  public void addPackagesToScan(String... packagesToScan) {
    super.addPackagesToScan(new String[] {"eztravel.rest.enums.reportform", "eztravel.rest.pojo.reportform"});
  }

}
