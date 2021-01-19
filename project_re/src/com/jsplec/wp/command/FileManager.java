package com.jsplec.wp.command;
//FileManager
// * ReadFile: read training files and test files
// * OutputFile: output predicted labels into a file

import java.io.BufferedReader;
import java.io.BufferedWriter;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FileManager{
	
	//read training files@Override

	public static TrainRecord[] readTrainFile(String fileName) throws IOException{
		System.out.println("readTrainFile = "+ fileName);
//		File file = new File(fileName);
//		System.out.println("file" + file);
//		
//		StringBuilder builder = new StringBuilder(fileName);
//		System.out.println("builder = " + builder);
		
		FileReader fileReader = new FileReader(fileName);
		System.out.println("fileReader = " + fileReader);
		
		BufferedReader bufferedReader = new  BufferedReader(fileReader);
		System.out.println("bufferedReader = "+  bufferedReader);
		
		Scanner scanner = new Scanner(bufferedReader);
		System.out.println("ScannerFile = "+  scanner);

		//read file
		int NumOfSamples = scanner.nextInt();
		System.out.println(NumOfSamples);
		int NumOfAttributes = scanner.nextInt();
		System.out.println(NumOfAttributes);
		int LabelOrNot = scanner.nextInt();
		System.out.println(LabelOrNot);
		scanner.nextLine();
		
		assert LabelOrNot == 1 : "No classLabel";// ensure that C is present in this file
		
		
		//transform data from file into TrainRecord objects
		TrainRecord[] records = new TrainRecord[NumOfSamples];
		int index = 0;
		while(scanner.hasNext()){
			double[] attributes = new double[NumOfAttributes];
			int classLabel = -1;
			System.out.println(classLabel);
			//Read a whole line for a TrainRecord
			for(int i = 0; i < NumOfAttributes; i ++){      // i를 0 으로 실수값으로 값을 비교하기 위해 바꾸고 Attribute 수 만큼 돌린다.
				attributes[i] = scanner.nextDouble();    
				System.out.println(attributes[i]);
			}
			
			//Read classLabel
			classLabel = (int) scanner.nextDouble();
			System.out.println(classLabel);
			assert classLabel != -1 : "Reading class label is wrong!";
			
			records[index] = new TrainRecord(attributes, classLabel);
			index ++;
		}
		
		return records;
	}
	
	
	public static TestRecord[] readTestFile(String fileName) throws IOException{
//		StringBuilder builder = new StringBuilder(fileName);
//		System.out.println("builder = " + builder);
		
		FileReader fileReader = new FileReader(fileName);
		System.out.println("fileReader = " + fileReader);
		
		BufferedReader bufferedReader = new  BufferedReader(fileReader);
		System.out.println("bufferedReader = "+  bufferedReader);
		
		Scanner scanner = new Scanner(bufferedReader);
		System.out.println("ScannerFile = "+  scanner);

		//read file
		int NumOfSamples = scanner.nextInt();
		int NumOfAttributes = scanner.nextInt();
		int LabelOrNot = scanner.nextInt();
		scanner.nextLine();
		
		assert LabelOrNot == 1 : "No classLabel";
		
		TestRecord[] records = new TestRecord[NumOfSamples];
		int index = 0;
		while(scanner.hasNext()){
			double[] attributes = new double[NumOfAttributes];
			int classLabel = -1;
			
			//read a whole line for a TestRecord
			for(int i = 0; i < NumOfAttributes; i ++){
				attributes[i] = scanner.nextDouble();
			}
			
			//read the true lable of a TestRecord which is later used for validation
			classLabel = (int) scanner.nextDouble();
			assert classLabel != -1 : "Reading class label is wrong!";
			
			records[index] = new TestRecord(attributes, classLabel);
			index ++;
		}
		
		return records;
	}
	
	public static String outputFile(TestRecord[] testRecords, String trainFilePath) throws IOException{
		//construct the predication file name
//		OutputStream output = new FileOutputStream("/Users/yoomingy/Documents/workspace-spring-tool-suite-4-4.8.1.RELEASE/knnFirst/classification/knn_test.txt");
		
		System.out.println("testRecords = "+testRecords);
		System.out.println("trainFilePath = "+trainFilePath);
		
		StringBuilder predictName = new StringBuilder();
		
		
		for(int i = 15; i < trainFilePath.length(); i ++){
			if(trainFilePath.charAt(i) != '_') 
				predictName.append(trainFilePath.charAt(i));
			
			else 
				
			
				break;
		}
		
		System.err.println("predictName = " + predictName);
		System.out.println("---------------------------");
		
		String predictPath = predictName.toString()+"_prediction.txt";
		System.out.println("predictPath = "+ predictPath);
		//ouput the prediction labels
		
//		File file = new File(predictPath);
//		System.out.println("file = "+file);
		
		StringBuilder builder = new StringBuilder(predictPath);
//		System.out.println("builder = " + builder);
		
		FileReader fileReader = new FileReader(predictPath);
		System.out.println("fileReader = "+fileReader);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		System.out.println("bufferedReader = "+bufferedReader);
		
//		if(!fileReader.exists())
//			file.createNewFile();
		
		int i =0;
		InputStreamReader isr = null;

		
		FileReader fr = null; 
		FileWriter fw = null; 
		
		
		try{ 
			
			isr = new InputStreamReader(System.in); 
			
			fw = new FileWriter(predictPath, true); 
			
			while((i=fileReader.read())!=-1){
				
				fw.write(i); 
				
			}
			
			// 입력받은 버퍼를 파일에 내보낸다. fw.flush(); 
			// sample.txt 파일을 읽을 FileReader 객체를 생성한다. 
			
			fr = new FileReader(predictPath); 
			
			// sample.txt 파일의 끝까지 읽으면서 콘솔에 출력한다. 
			
			while((i=fr.read())!=-1){
				
				System.out.print((char)i);
				
			} 
			
			}catch(IOException e){ 
				e.printStackTrace(); 
			}finally{ 
				
			// InputStreamReader, FileReader, FileWriter를 닫아준다. 
				if(isr != null) try{isr.close();}catch(IOException e){} 
				if(fr != null) try{fr.close();}catch(IOException e){} 
				if(fw != null) try{fw.close();}catch(IOException e) {}
		}
		return predictPath;

	
//		try {
//			
//		isr = new InputStreamReader(System.in);
//
//		
//		while (int i = isr.read())!=-1){
//			
//			
//		}
//		FileWriter fw = new FileWriter(predictPath);
//		BufferedWriter bw = new BufferedWriter(fw);
//		
////		while((i=fileReader.read())!=-1){ 
//					
//		for(int i =0; i < fileReader.read(); i ++){
//					bw.write(i); }
//		
////			TestRecord tr = testRecords[i];
////			bw.write(Integer.toString(tr.predictedLabel));
////			bw.newLine();
////		}
//		
//		bw.close();
//		fw.close();
//		
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		return predictPath;
	}
}
