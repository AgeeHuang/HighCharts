/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: eztravel.persistence.repository.reportform
 * @FileName: ReportformRepository.java
 * @date: 2015/1/7, 上午 09:55:46
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
package eztravel.persistence.repository.reportform;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import eztravel.rest.pojo.reportform.RevenueInfo;




/**
 * <pre>
 * ReportformRepository, TODO: add Class Javadoc here.
 * </pre>
 * 
 */
public interface ReportformRepository {

  /**
   * Gets the something.
   * 
   * @return the something
   */
  public Integer getSomething(Map<String, Object> map);
  
  public List<RevenueInfo> getMonthRevenue(@Param("date")String date , @Param("region")String region);
  
  public List<RevenueInfo> getRevenue(@Param("date")String date);
  
  public List<RevenueInfo> getYearRevenue(@Param("date")String date);
  
}
