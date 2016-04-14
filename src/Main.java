import weka.classifiers.Evaluation;
import weka.core.*;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by 51203 on 13-Apr-16.
 */
public class Main {
    public static void main(String[] args) {

        /*ANN ann = new ANN();
        ann.multiPerceptronLayer();

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

        double[] image2 = new double[]{-0.063157,-0.115679,-0.245228,-0.386709,-0.403616,-0.304921,-0.165850,-0.058946,-0.061265,-0.247669,-0.576165,-0.862425,-0.988037,-1.000000,-1.000000,-1.000000,-0.174121,-0.254627,-0.408194,-0.577966,-0.650294,-0.625147,-0.535698,-0.389242,-0.226154,-0.187152,-0.380758,-0.696773,-0.925994,-0.996155,-1.000000,-1.000000,-0.426291,-0.456718,-0.550805,-0.690394,-0.802090,-0.853178,-0.839841,-0.731594,-0.506554,-0.259907,-0.235431,-0.495293,-0.819913,-0.981506,-1.000000,-1.000000,-0.731472,-0.693965,-0.698604,-0.766018,-0.868193,-0.951080,-0.990997,-0.957977,-0.782712,-0.427573,-0.192035,-0.331807,-0.705165,-0.960845,-1.000000,-1.000000,-0.934936,-0.890135,-0.861051,-0.872374,-0.923033,-0.976532,-1.000000,-1.000000,-0.907927,-0.543572,-0.215045,-0.274159,-0.650416,-0.950652,-1.000000,-1.000000,-1.000000,-0.991302,-0.977783,-0.972320,-0.979156,-0.990661,-1.000000,-1.000000,-0.882353,-0.520165,-0.215534,-0.302052,-0.679774,-0.962066,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-0.985229,-0.781247,-0.392813,-0.171893,-0.369314,-0.768429,-0.996887,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-0.958740,-0.667323,-0.252857,-0.115618,-0.412650,-0.825711,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-0.941131,-0.621515,-0.209155,-0.085679,-0.356893,-0.718776,-0.888914,-0.945617,-0.986603,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-0.950500,-0.699336,-0.352712,-0.180652,-0.277852,-0.472587,-0.589014,-0.669673,-0.749660,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-0.980194,-0.856352,-0.646082,-0.465141,-0.380179,-0.345632,-0.291554,-0.265217,-0.291676,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-0.988678,-0.910643,-0.788479,-0.631678,-0.430198,-0.175006,0.024857,0.112169,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-1.000000,-0.992401,-0.976196,-0.948028,-0.872160,-0.720424,-0.486992,-0.198932,0.016648,0.110765,-1.000000,-1.000000,-1.000000,-0.997040,-0.971313,-0.922332,-0.862608,-0.806912,-0.758022,-0.722011,-0.660090,-0.552392,-0.416526,-0.296773,-0.251850,-0.272969,-1.000000,-1.000000,-1.000000,-0.989654,-0.901366,-0.740322,-0.574121,-0.472038,-0.428550,-0.421347,-0.408927,-0.397177,-0.412039,-0.480339,-0.588006,-0.692927,-1.000000,-1.000000,-1.000000,-0.979919,-0.809201,-0.504112,-0.217945,-0.100359,-0.129595,-0.216846,-0.304433,-0.417533,-0.559625,-0.717952,-0.856962,-0.951415};
        Instance iExample = new Instance(257);
        for (int i = 0; i < 256; i++) {
            //System.out.println(i);
            iExample.setValue((Attribute) fvAttributeDigits.elementAt(i), image2[i]);
        }
        //iExample.setValue(((Attribute) fvAttributeDigits.elementAt(256)), 3.0);


        Instances isTrainingSet = new Instances("Rel", fvAttributeDigits, 1);
        isTrainingSet.setClassIndex(256);
        isTrainingSet.add(iExample);
        try {
            double clsLabel = ann.mModel.classifyInstance(isTrainingSet.instance(0));
            System.out.println(clsLabel);

            *//*Evaluation eval = new Evaluation(isTrainingSet);
            eval.evaluateModel(ann.mModel, isTrainingSet);
            System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
            System.out.println(eval.toSummaryString()); //Summary of Training*//*


        } catch (Exception e) {
            e.printStackTrace();
        }*/


        // get image
        BufferedImage bufferedImage = Image.getImageFromFile("data/number2.png");
        for (int j = 0; j < bufferedImage.getHeight(); j++) {
            for (int i = 0; i < bufferedImage.getWidth(); i++) {
                if (bufferedImage.getData().getSample(i, j, 0) != 255) {
                    System.out.print("000");
                } else
                    System.out.print(bufferedImage.getData().getSample(i, j, 0));
            }
            System.out.println();
        }

    }
}
