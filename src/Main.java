import data.DataReader;
import data.DataSeparater;
import data.Patient;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSeparater dataSeparater = new DataSeparater(new DataReader().readData("data/heart_disease.csv"));
        List<Patient> testData = dataSeparater.getTestData(),trainData = dataSeparater.getTrainData();
        SVM svm = new SVM(0.001,0.001,20000);
        svm.fit(dataSeparater.getData(trainData),dataSeparater.getLabels(trainData));
        System.out.println("Accuracy: "+accuracy(dataSeparater.getLabels(testData),svm.predict(dataSeparater.getData(testData))));
    }
    private static double accuracy(int[] knownLabels,double[] predictedLabels){
        double correct=0;
        for(int i=0;i<knownLabels.length;i++){
            if(knownLabels[i]==(int)predictedLabels[i]){
                correct++;
            }
        }
        return correct/knownLabels.length;
    }
}