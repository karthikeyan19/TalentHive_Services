package com.karthik.utils;

import java.io.IOException;
import org.bson.Document;

import com.karthik.constants.MongoConstants;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoUtils {
	

	private static MongoClient mongoClient = null;
	private static MongoDatabase db = null;
	private static DB jongoDB = null;
	static
	{
		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		builder.connectionsPerHost(20);
		MongoClientOptions options = builder.build();
	    mongoClient =  new MongoClient(MongoConstants.IP_ADDRESS,options);
		db = mongoClient.getDatabase(MongoConstants.DB_NAME);
		jongoDB = mongoClient.getDB(MongoConstants.DB_NAME);
	}
	// constructor
	private MongoUtils()
	{
		
	}
	public static MongoDatabase getMongoDataBase(){

		if(db == null)
		{
			MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
			builder.connectionsPerHost(20);
			MongoClientOptions options = builder.build();
			 mongoClient =  new MongoClient(MongoConstants.IP_ADDRESS,options);
				db = mongoClient.getDatabase(MongoConstants.DB_NAME);
		}
		return db;
	}
	
	public static MongoCollection<Document> getCollection(String collectionName){
		
		
		return getMongoDataBase().getCollection(collectionName);
	}
	
	public static void closeCursor(MongoCursor<Document> cursor){
		
		try {
			if(cursor!=null)
			{
				cursor.close();
			}
			
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void closeJongoCursor(org.jongo.MongoCursor cursor){
		
		try {
			if(cursor!=null)
			{
				cursor.close();
			}
			
		} catch (MongoException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DB getDB()
	{
		return getMongoDB();
	}
	
	private static DB getMongoDB(){
		
		if(jongoDB == null)
		{
			MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
			builder.connectionsPerHost(20);
			MongoClientOptions options = builder.build();
		    mongoClient =  new MongoClient(MongoConstants.IP_ADDRESS,options);
			jongoDB = mongoClient.getDB(MongoConstants.DB_NAME);
		}
		
		
		return jongoDB;
	}
	

}
