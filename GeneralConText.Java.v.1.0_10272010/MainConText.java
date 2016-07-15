/***************************************************************************************
 * Author: Junebae Kye, Supervisor: Imre Solti
 * Date: 07/04/2010 
 *
 *
 *This program is to mainly print a line along with its negation scope, temporality, and experiencer. For example, 550     hiatal herniaA HIATAL HERNIA was found.     Affirmed     -1     Historical     Patient(Number TAB Phrase TAB Sentence TAB Dummystring TAB Negation Scope TAB Temporality TAB Experiencer)
 *Usage: java MainConText Annotations-1-120-random.txt yes(or no)
 *
 ****************************************************************************************/

import java.io.*;
import java.util.*;

public class MainConText {

    public static void main(String[] args) throws IOException {
	if (args.length != 2) {
	    System.out.println("Usage: please, specify a text file and an option of yes or no for negation scope.");
	    return;
	}
	boolean value;
	if (args[1].toLowerCase().equals("yes"))
	    value = true;
	else
	    value = false;
	GenNegEx n = new GenNegEx(value);
	GenExperiencer e = new GenExperiencer();
	GenTemporality t = new GenTemporality();	  
	BufferedReader file = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = file.readLine()) != null) {
	    String[] s = line.split("\\t");
	    String sentence = cleans(s[2]);
	    String scope = n.negScope(sentence);
	    String experi = e.getExperiencer(sentence);
	    String tempo = t.getTemporality(sentence);
	    System.out.println(line + "\t" + scope + "\t" + tempo + "\t" + experi);
	}
	file.close();
    }

    // post: removes punctuations from a sentence
    private static String cleans(String line) {
	line = line.toLowerCase();
	if (line.contains("\""))
	    line = line.replaceAll("\"", "");
	if (line.contains(","))
	    line = line.replaceAll(",", "");  
	if (line.contains("."))
	    line = line.replaceAll("\\.", "");
	if (line.contains(";"))
	    line = line.replaceAll(";", "");
	if (line.contains(":"))
	    line = line.replaceAll(":", "");
	return line;
    }
}
