package data;

import java.util.*;

public class DataSeparater {
    private List<Patient> testData, trainData;

    public DataSeparater(List<Patient> patients) {
        List<List<Patient>> temp = getTrainAndTestData(patients);
        trainData = temp.get(0);
        testData = temp.get(1);
    }

    private List<List<Patient>> getTrainAndTestData(List<Patient> patients) {
        Collections.shuffle(patients);
        List<Patient> trainPatients = new ArrayList<>(),testPatients = new ArrayList<>();
        int trainSize = (int) (patients.size()*0.75);
        for(int i=0;i<trainSize;i++){
            trainPatients.add(patients.get(i));
        }
        for(int i=trainSize;i<patients.size();i++){
            testPatients.add(patients.get(i));
        }
        List<List<Patient>> returnList = new ArrayList<>();
        returnList.add(trainPatients);
        returnList.add(testPatients);
        return returnList;
    }
    public double[][] getData(List<Patient> patients){
        double[][] data = new double[patients.size()][];
        for(int i=0;i<patients.size();i++){
            data[i] = patients.get(i).getPatientData();
        }
        return data;
    }
    public int[] getLabels(List<Patient> patients){
        int[] data = new int[patients.size()];
        for(int i=0;i<patients.size();i++){
            data[i] = patients.get(i).getIsPresent()>0?1:-1;
        }
        return data;
    }

    public List<Patient> getTestData() {
        return testData;
    }

    public List<Patient> getTrainData() {
        return trainData;
    }
}
