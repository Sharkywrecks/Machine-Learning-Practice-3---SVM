import data.MyMaths;
//SUPPORT VECTOR MACHINE
public class SVM {
    private double learningRate,lambda;
    private int numIterations;
    private double[] weights;
    private double bias;

    public SVM(double learningRate, double lambda, int numIterations) {
        this.learningRate = learningRate;
        this.lambda = lambda;
        this.numIterations = numIterations;
    }

    public void fit(double[][] X, int[] y){
        int numFeatures = X[0].length;
        weights = new double[numFeatures];
        bias = 0;

        for(int i=0;i<numIterations;i++){
            for(int j = 0;j<X.length;j++){
                boolean condition = (y[j] * MyMaths.dotProduct(X[j],weights) - bias)>=1;
                if(condition){
                    weights = MyMaths.subtract(weights,MyMaths.multiply(weights,2*learningRate*lambda));
                }else{
                    weights = MyMaths.subtract(weights,MyMaths.subtract(
                            MyMaths.multiply(weights,2*learningRate*lambda),
                            MyMaths.multiply(X[j],y[j])));
                    bias -= y[j];
                }
            }
        }
    }
    public double[] predict(double[][] X){
        double[] linearOutput = MyMaths.add(MyMaths.dotProduct(X,weights),-bias);
        return MyMaths.sign(linearOutput);
    }
}
