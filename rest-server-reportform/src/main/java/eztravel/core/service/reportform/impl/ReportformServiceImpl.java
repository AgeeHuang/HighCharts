/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: eztravel.core.service.reportform.impl
 * @FileName: ReportformServiceImpl.java
 * @date: 2015/1/7, 上午 09:32:41
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
package eztravel.core.service.reportform.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import eztravel.core.service.reportform.ReportformService;
import eztravel.persistence.repository.reportform.ReportformRepository;
import eztravel.rest.pojo.reportform.RevenueInfo;



/**
 * <pre>
 * PaymentServiceImpl, TODO: add Class Javadoc here.
 * </pre>
 * 
 */
public class ReportformServiceImpl implements ReportformService {

  /** The Constant logger. */
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(ReportformServiceImpl.class);

  /** The reportform repository. */
  private ReportformRepository reportformRepository;

  /** The reportform prop. */
  @Autowired
  private Properties reportformProp;

  /**
   * Instantiates a new reportform service impl.
   * 
   * @param reportformRepository the reportform repository
   */
  public ReportformServiceImpl(ReportformRepository reportformRepository) {
    super();
    this.reportformRepository = reportformRepository;
  }

  @Override
  public String doSomething() {
    Map<String, Object> map = new HashMap<String, Object>();
    return String.valueOf(reportformRepository.getSomething(map));
  }

  @Override
  public List<Map<String, Object>> getMonthRevenue(String date, String region) {
    
    List<RevenueInfo> revenueInfo = reportformRepository.getMonthRevenue(date,region);
    
    //塞入每月訂單數量
    String[] ord_cnt_arr= new String[12];
    //塞入每月訂單金額
    String[] ord_amt_arr= new String[12];
    
    int i=0;
    for(RevenueInfo revenueinfo : revenueInfo ){  
      ord_cnt_arr[i]=revenueinfo.getOrd_Cnt();
      ord_amt_arr[i]=revenueinfo.getOrd_Amt();
      i++; 
    }
    ord_cnt_arr=getCnt_Amt(ord_cnt_arr);
    ord_amt_arr=getCnt_Amt(ord_amt_arr);
    
    Map<String, Object> monthResult = new HashMap<String,Object>();
    
    monthResult.put(date+"每月訂單", ord_cnt_arr);
    monthResult.put(date+"每月金額", ord_amt_arr);
    monthResult.put("local", date+"-"+region);
    
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    
    list.add(monthResult);
    
//    Map<String,List<Map<String, Object>>> result = new HashMap<String, List<Map<String, Object>>>();
//    
//    result.put(date+"-"+region, list);
   
    
    return list;
  }
  
  //判斷當月沒訂單或金額數量0
  public String[] getCnt_Amt(String[] arr){
    
    for(int x =0 ;x<arr.length ; x++){
      arr[x]= (arr[x]== null? "0" : arr [x]);
    }   
    return arr;
    
  }

  
  @Override
  public List<Map<String, Object>> getRevenue(String date, String region) {
    List<RevenueInfo> revenueInfo = reportformRepository.getRevenue(date,region);
    
    for(RevenueInfo revenueinfo : revenueInfo ){
      
      List<String> listay =new ArrayList<String>();
      
      
    }
    
    return null;
  }
  
}
