/**
 * Created by 51203 on 13-Apr-16.
 */

import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class ANN {
    public Instances mData;
    public MultilayerPerceptron mModel;

    ANN() {
        ConverterUtils.DataSource source = null;
        try {
            source = new ConverterUtils.DataSource("data/train-digits.arff");
            mData = source.getDataSet();
            // setting class attribute if the data format does not provide this information
            // For example, the XRFF format saves the class attribute information as well
            if (mData.classIndex() == -1)
                mData.setClassIndex(mData.numAttributes() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void multiPerceptronLayer() {
        //Instance of NN
        mModel = new MultilayerPerceptron();

        //Setting Parameters
        mModel.setLearningRate(0.1);
        mModel.setMomentum(0.2);
        mModel.setTrainingTime(2000);
        mModel.setHiddenLayers("5");

        try {
            mModel.buildClassifier(mData);


            Evaluation eval = new Evaluation(mData);
            eval.evaluateModel(mModel, mData);
            System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
            System.out.println(eval.toSummaryString()); //Summary of Training



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
