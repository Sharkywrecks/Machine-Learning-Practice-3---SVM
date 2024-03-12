package data;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

public class MyMaths {
    public static int indexOfSmallest(double[] x){
        int index = 0;
        double temp = Double.MAX_VALUE;
        for(int i=0;i<x.length;i++){
            if(x[i]<temp){
                temp=x[i];
                index=i;
            }
        }
        return index;
    }
    public static int indexOfLargest(double[] x){
        int index = 0;
        double temp = Double.MIN_VALUE;
        for(int i=0;i<x.length;i++){
            if(x[i]>temp){
                temp=x[i];
                index=i;
            }
        }
        return index;
    }
    public static double euclideanDistance(double[] x1,double[] x2){
        double sum=0;
        for(int i=0;i<x1.length;i++){
            sum+=Math.pow(x1[i]-x2[i],2);
        }
        return Math.sqrt(sum);
    }
    //GENERIC COUNTER BUILDER
    public static <T> Map<T,Integer> caseCounterBuilder(T[] cases){
        Map<T,Integer> counter = new HashMap<>();
        for(T o:cases){
            counter.put(o,0);
        }
        return counter;
    }
    /**________________________________________________________________________________
     *
     * MATRIX HELPERS BELOW
     *
     */

    public static double[][] add(double[][] a, double[][] b){

        double[][] out = new double[a.length][a[0].length];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                out[i][j] = a[i][j] + b[i][j];
            }
        }

        return out;
    }
    public static double[][] add(double[][] a, double b){

        double[][] out = new double[a.length][a[0].length];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                out[i][j] = a[i][j] + b;
            }
        }

        return out;
    }
    public static double[] add(double[] a, double[] b){

        double[] out = new double[a.length];

        for(int i=0;i<a.length;i++){
            out[i] = a[i] + b[i];
        }

        return out;
    }
    public static double[] add(double[] a, double b){

        double[] out = new double[a.length];

        for(int i=0;i<a.length;i++){
            out[i] = a[i] + b;
        }

        return out;
    }
    public static double[][] subtract(double[][] a,double[][] b){
        return add(a,multiply(b,-1));
    }
    public static double[] subtract(double[] a,double[] b){
        return add(a,multiply(b,-1));
    }
    public static double[][] multiply(double[][] a, double scalar){

        double[][] out = new double[a.length][a[0].length];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                out[i][j] = a[i][j]*scalar;
            }
        }

        return out;
    }
    public static double[] multiply(double[] a, double scalar){

        double[] out = new double[a.length];

        for(int i=0;i<a.length;i++){
            out[i] = a[i]*scalar;
        }

        return out;
    }
    public static double maxArrayValue(double[][] arr){
        double max = Double.MIN_VALUE;
        for (double[] doubles : arr) {
            for (double d : doubles) {
                max = max > d ? max : d;
            }
        }
        return max;
    }

    public static double[][] dotProduct(double[][] inputs, double[][] values){
        double[][] returnArr = new double[inputs.length][values[0].length];
        for(int i=0;i<returnArr.length;i++){
            for(int j=0;j<returnArr[0].length;j++){
                double val=0;
                for(int k=0;k<inputs[0].length;k++){
                    val+=inputs[i][k]*values[k][j];
                }
                returnArr[i][j]=val;
            }
        }
        return returnArr;
    }
    public static double[] dotProduct(double[][] inputs, double[] values){
        double[] dotProduct=new double[inputs.length];
        for(int i=0;i<inputs.length;i++){
            double sumProd=0;
            for(int j=0;j<inputs[0].length;j++){
                sumProd+=inputs[i][j]*values[j];
            }
            dotProduct[i]=sumProd;
        }
        return dotProduct;
    }
    public static double dotProduct(double[] inputs, double[] values){
        double dotProduct=0;
        for(int i=0;i<inputs.length;i++){
            dotProduct+=inputs[i]*values[i];
        }
        return dotProduct;
    }
    public static double mean(double[] arr){
        double sum=0;
        for(double d:arr){
            sum+=d;
        }
        return sum/arr.length;
    }
    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    public static double[][] transpose(double[][] array){
        double[][] returnArr = new double[array[0].length][array.length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                returnArr[j][i] = array[i][j];
            }
        }
        return returnArr;
    }
    public static List<double[]> transpose(List<double[]> list){
        List<double[]> returnList = new ArrayList<>();
        for(int i=0;i<list.get(0).length;i++){
            returnList.add(new double[list.size()]);
        }
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(0).length;j++){
                returnList.get(j)[i] = list.get(i)[j];
            }
        }
        return returnList;
    }
    public static double[][] sign(double[][] arr){
        double[][] signArr = new double[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                signArr[i][j] = signArr[i][j]>0?1:signArr[i][j]<0?-1:0;
            }
        }
        return signArr;
    }

    public static double[] sign(double[] arr){
        double[] signArr = new double[arr.length];
        for(int i=0;i<arr.length;i++){
            signArr[i] = arr[i]>0?1:arr[i]<0?-1:0;
        }
        return signArr;
    }
    public static double[][] where(double[][] arr, Predicate<Double> predicate, double yes, double no){
        double[][] returnArr = new double[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(predicate.test(arr[i][j])){
                    returnArr[i][j] = yes;
                }else{
                    returnArr[i][j] = no;
                }
            }
        }
        return returnArr;
    }
    public static int[] where(int[] arr, Predicate<Integer> predicate, int yes, int no){
        int[] returnArr = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            if(predicate.test(arr[i])){
                returnArr[i] = yes;
            }else{
                returnArr[i] = no;
            }
        }
        return returnArr;
    }
}
