/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: eztravel.core.service.reportform
 * @FileName: ReportformService.java
 * @date: 2015/1/7, 上午 09:42:12
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
package eztravel.core.service.reportform;

import java.util.List;
import java.util.Map;


/**
 * <pre>
 * ReportformService, TODO: add Class Javadoc here.
 * </pre>
 * 
 */
public interface ReportformService {

  /**
   * Do something.
   * 
   * @return the string
   */
  public String doSomething();
  
  
 
  public List<Map<String, Object>> getMonthRevenue(String date ,String region);
  
  public List<Map<String, Object>> getRevenue(String date ,String region);
  
}
