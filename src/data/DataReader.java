package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public List<Patient> readData(String path){
        List<Patient> patients = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            String line = bf.readLine();
            while ((line= bf.readLine())!=null){
                String[] lineSplit = line.split(",");
                double[] patientData = new double[lineSplit.length-1];
                for(int i =0;i<patientData.length;i++){
                    patientData[i] = Double.parseDouble(lineSplit[i]);
                }
                patients.add(new Patient(patientData,Integer.parseInt(lineSplit[lineSplit.length-1])));
            }
        }catch(Exception e){

        }
        return patients;
    }
}
