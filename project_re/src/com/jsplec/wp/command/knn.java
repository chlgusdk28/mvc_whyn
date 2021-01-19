package com.jsplec.wp.command;
import java.io.IOException;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class knn {
	
	

	
//	
	
	
	
	public static void main(String[] args){	
//		System.out.println("knn");
//		knn("classification/knn_train.txt","classification/knn_test.txt",1,2);
//		System.out.println();
//		
		
		
	

	
		
	}
	

	public static void knn(String trainingFile, String testFile, int K, int metricType){
		//get the current time
		final long startTime = System.currentTimeMillis();
		
		// make sure the input arguments are legal 0보다 커야힌디
		if(K <= 0){
			System.out.println("K should be larger than 0!");
			return;
		}
		
		// metricType should be within [0,2];   2 또는 0어야 한다 
		if(metricType > 2 || metricType <0){
			System.out.println("metricType is not within the range [0,2]. Please try again later");
			return;
		}
		
		
		//TrainingFile and testFile should be the same group  트레인과 테스트 파일은 같은 그룹에 있어한
		String trainGroup = extractGroupName(trainingFile);
		String testGroup = extractGroupName(testFile);
		
		System.out.println("traingroup : "+trainGroup);
		System.out.println("testgroup : "+testGroup);
		if(!trainGroup.equals(testGroup)){
			System.out.println("trainingFile and testFile are illegal!");
			
			return;
			
		}
		System.out.println("group out");
		
		try {
			//read trainingSet and testingSet
			System.out.println("try in");
			System.out.println("trainingFile : "+trainingFile);
			System.out.println("testFile : "+testFile);
			TrainRecord[] trainingSet =  FileManager.readTrainFile(trainingFile);
			System.out.println("trainingFile2 : "+trainingFile);
			TestRecord[] testingSet =  FileManager.readTestFile(testFile);
			System.out.println("testFile2 : "+testFile);
			System.out.println("traingSet : "+trainingSet);
			System.out.println("testSet : "+testingSet);
			
			//determine the type of metric according to metricType
			Metric metric;
			if(metricType == 0)
				metric = new CosineSimilarity();
			
			else if(metricType == 1)
				metric = new L1Distance();
			else if (metricType == 2)
				metric = new EuclideanDistance();
			else{
				
				System.out.println("The entered metric_type is wrong!");
				return;
			}
			System.out.println("metric out");
			//test those TestRecords one by one
			int numOfTestingRecord = testingSet.length;
			for(int i = 0; i < numOfTestingRecord; i ++){
				TrainRecord[] neighbors = findKNearestNeighbors(trainingSet, testingSet[i], K, metric);
				int classLabel = classify(neighbors);
				testingSet[i].predictedLabel = classLabel; //assign the predicted label to TestRecord
			}
			//calculate the accuracy
			int correctPrediction = 0;
			for(int j = 0; j < numOfTestingRecord; j ++){
				if(testingSet[j].predictedLabel == testingSet[j].classLabel)
					correctPrediction ++;
			}
			
			//Output a file containing predicted labels for TestRecords
			System.out.println("1");
//			String predictPath = FileManager.outputFile(testingSet, trainingFile);
			System.out.println("testingSet = " + testingSet+"trainingFile = " + trainingFile);
//			System.out.println("The prediction file is stored in "+predictPath);
			
			System.out.println("2");
			System.out.println("The accuracy is "+((double)correctPrediction / numOfTestingRecord)*100+"%");
			System.out.println("3");
			
			//print the total execution time
			final long endTime = System.currentTimeMillis();
			System.out.println("Total excution time: "+(endTime - startTime) / (double)1000 +" seconds.");
		
		
		} catch (IOException e) {
			System.out.println("catch");
			System.out.println(e);
		}
		
	}
	
	// Find K nearest neighbors of testRecord within trainingSet 
	static TrainRecord[] findKNearestNeighbors(TrainRecord[] trainingSet, TestRecord testRecord,int K, Metric metric){
		int NumOfTrainingSet = trainingSet.length;
		assert K <= NumOfTrainingSet : "K is lager than the length of trainingSet!";
		
		//Update KNN: take the case when testRecord has multiple neighbors with the same distance into consideration
		//Solution: Update the size of container holding the neighbors
		TrainRecord[] neighbors = new TrainRecord[K];
		
		//initialization, put the first K trainRecords into the above arrayList
		int index;
		for(index = 0; index < K; index++){
			trainingSet[index].distance = metric.getDistance(trainingSet[index], testRecord);
			neighbors[index] = trainingSet[index];
		}
		
		//go through the remaining records in the trainingSet to find K nearest neighbors
		for(index = K; index < NumOfTrainingSet; index ++){
			trainingSet[index].distance = metric.getDistance(trainingSet[index], testRecord);
			
			//get the index of the neighbor with the largest distance to testRecord
			int maxIndex = 0;
			for(int i = 1; i < K; i ++){
				if(neighbors[i].distance > neighbors[maxIndex].distance)
					maxIndex = i;
			}
			
			//add the current trainingSet[index] into neighbors if applicable
			if(neighbors[maxIndex].distance > trainingSet[index].distance)
				neighbors[maxIndex] = trainingSet[index];
		}
		
		return neighbors;
	}
	
	// Get the class label by using neighbors
	static int classify(TrainRecord[] neighbors){
		//construct a HashMap to store <classLabel, weight>
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
		int num = neighbors.length;
		
		for(int index = 0;index < num; index ++){
			TrainRecord temp = neighbors[index];
			int key = temp.classLabel;
		
			//if this classLabel does not exist in the HashMap, put <key, 1/(temp.distance)> into the HashMap
			if(!map.containsKey(key))
				map.put(key, 1 / temp.distance);
			
			//else, update the HashMap by adding the weight associating with that key
			else{
				double value = map.get(key);
				value += 1 / temp.distance;
				map.put(key, value);
			}
		}	
		
		//Find the most likely label
		double maxSimilarity = 0;
		int returnLabel = -1;
		Set<Integer> labelSet = map.keySet();
		Iterator<Integer> it = labelSet.iterator();
		
		//go through the HashMap by using keys 
		//and find the key with the highest weights 
		while(it.hasNext()){
			int label = it.next();
			double value = map.get(label);
			if(value > maxSimilarity){
				maxSimilarity = value;
				returnLabel = label;
			}
		}
		
		return returnLabel;
	}
	
	static String extractGroupName(String filePath){
		StringBuilder groupName = new StringBuilder();
		for(int i = 15; i < filePath.length(); i ++){
			if(filePath.charAt(i) != '_')
				groupName.append(filePath.charAt(i));
			else
				break;
		}
		
		return groupName.toString();
	}
	}


