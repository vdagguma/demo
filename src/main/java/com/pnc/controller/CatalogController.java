package com.pnc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.pnc.model.Catalog;
import com.pnc.model.Response;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CatalogController {
	
	@Autowired
	RestTemplate restTemplate;/*
	 * Copyright 2019 the original author or authors.
	 *
	 * Licensed under the Apache License, Version 2.0 (the "License");
	 * you may not use this file except in compliance with the License.
	 * You may obtain a copy of the License at
	 *
	 *      https://www.apache.org/licenses/LICENSE-2.0
	 *
	 * Unless required by applicable law or agreed to in writing, software
	 * distributed under the License is distributed on an "AS IS" BASIS,
	 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 * See the License for the specific language governing permissions and
	 * limitations under the License.
	 */
	/*@RequestMapping(value = "/catalog/book")
	public String getCatalog() {
		
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	      return restTemplate.exchange(
	         "https://demo0222473.mockable.io/books", HttpMethod.GET, entity, String.class).getBody();
	}
	
	//POST method from client and sending same request back to the backend IIB service to insert into table
	/*@PostMapping(path = "/catalog/books")
	 public String createBook(@RequestBody String book) {	 
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
       Map<String,String> map = new HashMap<String, String>();
       map.put("Content-Type", "application/json");
       HttpEntity<String> request = new HttpEntity<String>(book,headers);
		 return restTemplate.exchange("http://shiva-ASUS:7800/books", HttpMethod.POST, request, String.class).getBody();
	 }*/
	
	
	// trying to read the header information and sending it as a json message for response
	
	/*@RequestMapping(value="/displayBookInfo.do")
	//To copy incoming headers and creating a body with those values as a response
	/*public ResponseEntity<Map<String, String>> displayHeaderInfo(@RequestHeader("bookid") String bookid,@RequestHeader("author") String author,
									@RequestHeader("title") String title,@RequestHeader("genre") String genre,
									@RequestHeader("price") String price,@RequestHeader("description") String description)  {
        
		Map<String, String> returnValue = new HashMap<>();
        returnValue.put("bookid", bookid);
        returnValue.put("title", title);
        returnValue.put("genre", genre);
        returnValue.put("author", author);
        returnValue.put("price", price);
        returnValue.put("description", description);
        return ResponseEntity.status(200).body(returnValue);
	
	}*/
	
	/*@RequestMapping(value="/displayBookInfo.do")
	//To copy incoming headers and creating a body with those values as a response
	public String displayHeaderInfo(@RequestHeader("bookid") String bookid,@RequestHeader("author") String author,
									@RequestHeader("title") String title,@RequestHeader("genre") String genre,
									@RequestHeader("price") String price,@RequestHeader("description") String description)  {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://shiva-ASUS:7800/books", HttpMethod.POST, request, String.class).getBody();
	}*/
	
	/*@RequestMapping(value="/displayBookInfo.do")
	//To copy incoming headers and creating a body with header values as an inputrequest
	public String displayHeaderInfo(@RequestHeader("bookid") String bookid,@RequestHeader("author") String author,
									@RequestHeader("title") String title,@RequestHeader("genre") String genre,
									@RequestHeader("price") String price,@RequestHeader("description") String description)  {
        
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Accept", "application/json");
	    headers.add("Content-Type", "application/json");
	    MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
	    bodyMap.add("bookid", bookid);
	    bodyMap.add("author", author);
	    bodyMap.add("title", title);
	    bodyMap.add("genre", genre);
	    bodyMap.add("price", price);
	    bodyMap.add("description", description);
	    

	    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyMap, headers);
	    String result = restTemplate.postForObject("http://shiva-ASUS:7800/books", requestEntity, String.class);
	    return result;
		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		/*MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		Map<String, String> map= new HashMap<String, String>();
	    map.put("mapid", bookid);
        map.put("title", title);
        map.put("genre", genre);
        map.put("author", author);
        map.put("price", price);
        map.put("description", description);
        HttpEntity<HashMap<String, String>> request = new HttpEntity<HashMap<String, String>>(headers);
//	    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(headers);
		return restTemplate.exchange("http://shiva-ASUS:7800/books", HttpMethod.POST, request, String.class).getBody();*/
	
	@RequestMapping(value="/sendHeaders.do")
	//To copy incoming headers and creating a body with those values as a response
	public String displayHeaderInfo(@RequestHeader("bookid") String bookid,@RequestHeader("author") String author,
									@RequestHeader("title") String title,@RequestHeader("genre") String genre,
									@RequestHeader("price") String price,@RequestHeader("description") String description)  {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        //Map<String,String> map = new HashMap<String, String>();
        headers.set("Accept", "application/json");
        headers.add("bookid", bookid);
        headers.add("author", author);
        headers.add("title", title);
        headers.add("genre", genre);
        headers.add("price", price);
        headers.add("description", description);
        
        HttpEntity<String> request = new HttpEntity<String>(headers);
		 return restTemplate.exchange("https://demo0222473.mockable.io/books", HttpMethod.GET, request, String.class).getBody();
		 
		 
	
	}
	
	/*
	@RequestMapping(value="/sendHeaders.do")
	public List<Response> getBooksModified(@RequestHeader("bookid") String bookid,@RequestHeader("author") String author,
									@RequestHeader("title") String title,@RequestHeader("genre") String genre,
									@RequestHeader("price") String price,@RequestHeader("description") String description){
		
		ResponseEntity<List<Response>> response = restTemplate.exchange(
				  "https://demo0222473.mockable.io/book",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Response>>(){});
				List<Response> books = response.getBody();
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
				headers.add("bookid", bookid);
			    headers.add("author", author);
				//ResponseEntity.ok()
				  //          .headers(headers)
				    //        .body(books);
						//				return books;
										
	}
	*/
	
	 
	
}