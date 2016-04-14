import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by 51203 on 13-Apr-16.
 */
public class Main {
    static ANN ann;

    public static void trainModel() {
        ann.multiPerceptronLayer();
        // save model
        try {
            SerializationHelper.write("model/ann", ann.mModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MultilayerPerceptron readModel() {
        MultilayerPerceptron mlp = null;
        try {
            mlp = (MultilayerPerceptron) SerializationHelper.read("model/ann");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mlp;
    }

    public static void main(String[] args) {
        ann = new ANN();
        //trainModel();
        ann.mModel = readModel();
        // attribute
        FastVector fvAttributeDigits = new FastVector(257);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                fvAttributeDigits.addElement(new Attribute("pixel:x=" + i + ":y=" + j, i * 16 + j));
            }
        }
        FastVector fvClassVal = new FastVector(10);
        fvClassVal.addElement("0");
        fvClassVal.addElement("1");
        fvClassVal.addElement("2");
        fvClassVal.addElement("3");
        fvClassVal.addElement("4");
        fvClassVal.addElement("5");
        fvClassVal.addElement("6");
        fvClassVal.addElement("7");
        fvClassVal.addElement("8");
        fvClassVal.addElement("9");
        fvAttributeDigits.addElement(new Attribute("theClass", fvClassVal, 256));
        // end attribute
        // get image
        double[] bufferedImage = ImageHandler.getImageFromFile("data/number2.png");
        Instance iExample = new DenseInstance(257);
        for (int i = 0; i < 256; i++) {
            //System.out.println(i);
            iExample.setValue((Attribute) fvAttributeDigits.elementAt(i), bufferedImage[i]);
        }
        //iExample.setValue(((Attribute) fvAttributeDigits.elementAt(256)), 3.0);
        Instances isTrainingSet = new Instances("Rel", fvAttributeDigits, 1);
        isTrainingSet.setClassIndex(256);
        isTrainingSet.add(iExample);


        // test and evaluate
        try {
            double clsLabel = ann.mModel.classifyInstance(isTrainingSet.instance(0));
            System.out.println(clsLabel);

            /*Evaluation eval = new Evaluation(isTrainingSet);
            eval.evaluateModel(ann.mModel, isTrainingSet);
            System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
            System.out.println(eval.toSummaryString()); //Summary of Training*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        //////////////////////
    }

}
