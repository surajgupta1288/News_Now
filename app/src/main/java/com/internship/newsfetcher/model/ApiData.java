package com.internship.newsfetcher.model;

public class ApiData {
   public String title;   //* DATA NAME ALWAYS BE SAME WITH API  ARRAY LIST DATA"articles": [ "author" "title": key ]
   public String description; //* HEAR WE DECLARE VARIABLE PUBLIC THATS WHY WE ASSES IN MAINACTIVITY CLASS//
   public String urlToImage;  //* IF I TAKE PRIVATE THAN I NEED TO MANDATORY to use getter setter//
   public String url;


   public ApiData() {   //FOR DECLARE PUBLIC WE TAKE NO ARGUMENT CONSTRUCTOR //SELECT NONE
   }
}
