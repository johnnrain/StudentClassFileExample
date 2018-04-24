/*
 * File Class Example 2
 * Testing dynamic object naming
 */

import java.io.*;
import javax.swing.*;

public class fileExample {
	
	public static void main(String[] args) throws IOException {
		// Initialize Student Information and Output Arrays
		String[] stuInfo = {};
		
		//Create and initialize variables
		int numFiles = 0;
		int maxFiles;
		String temp = "";
		
		//Set the maximum size of the Student Object array;
		maxFiles = Integer.parseInt(JOptionPane.showInputDialog("Enter maximum number of files to process: "));
		Student[] stuArray = new Student[maxFiles];
		String[] outputs = new String[maxFiles];
		
		for(int i=0; temp.toLowerCase() != "exit" && i < maxFiles; i++) {
			temp = getFilename(i+1);
			System.out.println(temp.toLowerCase());
			if(temp.toLowerCase().equalsIgnoreCase("exit")) {
				break;
			}
			else {
				numFiles = numFiles+1;
				stuInfo = readFileToArray(temp);
				stuArray[i] = new Student();
				stuArray[i].setStuNumber(Integer.parseInt(stuInfo[0]));
				stuArray[i].setStuLName(stuInfo[1]);
				stuArray[i].setStuFName(stuInfo[2]);
				stuArray[i].setStuGPA(Double.parseDouble(stuInfo[3]));
			}
		}		
		
		// Output data
		for(int j = 0; j < numFiles; j++) {
			outputs[j] = stuArray[j].getFileData();
			System.out.println(stuArray[j].getFileData());
		}
		//JOptionPane.showMessageDialog(null, str1 + " \n" + str2);
		writeDataToFile(outputs);
	}

	
	public static String getFilename(int filenum)
	{
		return JOptionPane.showInputDialog("Type the name of file number " + filenum + " to import or type 'exit' to Quit.");
	}
	
	public static String[] readFileToArray(String filename) throws IOException
	{
		String line;
		String[] tmpInfo = {"","","",""};
		
		File file = new File(filename);
		FileReader fRead = new FileReader(file);
		BufferedReader bfRead = new BufferedReader(fRead);
		for( int i=0; (line = bfRead.readLine()) != null; i++) {
			tmpInfo[i] = line;
		}
		bfRead.close();
		fRead.close();
		JOptionPane.showMessageDialog(null, "File data imported successfully.");
		return tmpInfo;
	}
	
/*	public static void writeDataToFile(String s1, String s2) throws IOException {
		String fileName = JOptionPane.showInputDialog("File name for program output: ");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(fileName));
		bw1.write(s1);
		bw1.newLine();
		bw1.write(s2);
		bw1.close();		
	} */
	public static void writeDataToFile(String[] data) throws IOException {
		String fileName = JOptionPane.showInputDialog("File name for program output: ");
		FileWriter fw1 = new FileWriter(fileName);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		for(int i=0; i < data.length; i++) {
			bw1.write(data[i]);
			bw1.newLine();
		}
		bw1.close();
		fw1.close();
	}
}
