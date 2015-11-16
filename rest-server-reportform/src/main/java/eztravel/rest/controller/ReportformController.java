/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: eztravel.rest.controller
 * @FileName: ReportformController.java
 * @date: 2015/1/7, 上午 09:56:54
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
package eztravel.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eztravel.config.AppProperties;
import eztravel.core.service.reportform.ReportformService;
import eztravel.rest.controller.common.RestException;
import eztravel.rest.pojo.common.RestResource;
import eztravel.rest.pojo.common.RestResourceFactory;

/**
 * <pre>
 * reportformController, TODO: add Class Javadoc here.
 * </pre>
 * 
 */
@Controller
@Import({AppProperties.class})
@RequestMapping(value = "/rest/v1")
public class ReportformController {
  
  /** The Constant logger. */
  private static final Logger logger = LoggerFactory.getLogger(AppProperties.class);

  /** The env. */
  @Value("${app.env}")
  private String env;

  /** The Reportform service. */
  @Autowired
  private ReportformService reportformService;
  
  

  /**
   * Reportform.
   * 
   * @return the response entity
   */
  @RequestMapping(value = "/reportform", method = RequestMethod.GET)
  public ResponseEntity<RestResource<String>> reportform() {
    RestResource<String> body = RestResourceFactory.newInstance();
    List<String> items = new ArrayList<String>();
    items.add("Reportform");
    items.add("app.env=" + env); // 讀取參數檔設定
    items.add("reportformService.doSomething=" + reportformService.doSomething()); // 呼叫service執行SQL取得結果
    body.setItems(items);

    return new ResponseEntity<RestResource<String>>(body, HttpStatus.OK);
  }
  
  
  
  @RequestMapping(value = "/monthrevenue", method = RequestMethod.GET)
  public ResponseEntity<RestResource<List<Map<String, Object>>>> getmomthRevenueInfo(@RequestParam String date , @RequestParam String region) {
    RestResource<List<Map<String, Object>>> body = RestResourceFactory.newInstance();
    
    try {
      List<List<Map<String, Object>>> result = new ArrayList<List<Map<String, Object>>>();
      List<Map<String, Object>> revenueInfo = reportformService.getMonthRevenue(date,region);
      
      result.add(revenueInfo);
      
      body.setItems(result);
      
    }catch (Exception e) {
      throw new RestException(e.getMessage(), body);
    }
    

    return new ResponseEntity<RestResource<List<Map<String, Object>>>>(body, HttpStatus.OK);
  }
  
  @RequestMapping(value = "/revenue", method = RequestMethod.GET)
  public ResponseEntity<RestResource<List<Map<String, Object>>>> getRevenueInfo(@RequestParam String date  , @RequestParam String region) {
    RestResource<List<Map<String, Object>>> body = RestResourceFactory.newInstance();
    
    try {
      List<List<Map<String, Object>>> result = new ArrayList<List<Map<String, Object>>>();
      List<Map<String, Object>> revenueInfo = reportformService.getRevenue(date,region);
      
      result.add(revenueInfo);
      
      body.setItems(result);
      
    }catch (Exception e) {
      throw new RestException(e.getMessage(), body);
    }
    

    return new ResponseEntity<RestResource<List<Map<String, Object>>>>(body, HttpStatus.OK);
  }
   
}
