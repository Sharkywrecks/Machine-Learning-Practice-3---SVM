package data;

public class Patient {
    private double[] patientData;
    private int isPresent;

    public Patient(double[] patientData, int isPresent) {
        this.patientData = patientData;
        this.isPresent = isPresent;
    }

    public double[] getPatientData() {
        return patientData;
    }

    public int getIsPresent() {
        return isPresent;
    }
}
