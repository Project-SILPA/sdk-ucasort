package org.libindic.ucasort;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Arrays;

/**
 * Created by sujith on 13/7/14.
 */
public class UCASort {

    private static final String MALAYALAM_COLLATION_RULES = (
            "< \u0D70 < \u0D71 < \u0D72 < \u0D73 < \u0D74 < \u0D75 " +
                    "< \u0D79 < \u0D02 < \u0D03 < \u0D66 < \u0D67 < \u0D68 " +
                    "< \u0D69 < \u0D6A < \u0D6B < \u0D6C < \u0D6D < \u0D6E " +
                    "< \u0D6F < \u0D05 < \u0D06 < \u0D07 < \u0D08 < \u0D09 " +
                    "< \u0D0A < \u0D0B < \u0D60 < \u0D0C < \u0D61 < \u0D0E " +
                    "< \u0D0F < \u0D10 < \u0D12 < \u0D13 < \u0D14 < \u0D15\u0D4D " +
                    "< \u0D15 < \u0D7F < \u0D16\u0D4D , \u0D16 < \u0D17\u0D4D , \u0D17 " +
                    "< \u0D18\u0D4D , \u0D18 < \u0D19\u0D4D , \u0D19 < \u0D1A\u0D4D , \u0D1A " +
                    "< \u0D1B\u0D4D , \u0D1B < \u0D1C\u0D4D , \u0D1C < \u0D1D\u0D4D , \u0D1D " +
                    "< \u0D1E\u0D4D , \u0D1E < \u0D1F\u0D4D , \u0D1F < \u0D20\u0D4D , \u0D20 " +
                    "< \u0D21\u0D4D , \u0D21 < \u0D22\u0D4D , \u0D22 < \u0D23\u0D4D , \u0D23 " +
                    "< \u0D7A < \u0D24\u0D4D , \u0D24 < \u0D25\u0D4D , \u0D25 < \u0D26\u0D4D " +
                    ", \u0D26 < \u0D27\u0D4D , \u0D27 < \u0D28\u0D4D , \u0D28 < \u0D7B " +
                    "< \u0D29\u0D4D , \u0D29 < \u0D2A\u0D4D , \u0D2A < \u0D2B\u0D4D , \u0D2B " +
                    "< \u0D2C\u0D4D , \u0D2C < \u0D2D\u0D4D , \u0D2D < \u0D2E\u0D4D , \u0D2E " +
                    "< \u0D2F\u0D4D , \u0D2F < \u0D30\u0D4D , \u0D30 < \u0D4E < \u0D7C " +
                    "< \u0D32\u0D4D , \u0D32 < \u0D7D < \u0D35\u0D4D , \u0D35 < \u0D36\u0D4D " +
                    ", \u0D36 < \u0D37\u0D4D , \u0D37 < \u0D38\u0D4D , \u0D38 < \u0D39\u0D4D " +
                    ", \u0D39 < \u0D33\u0D4D , \u0D33 < \u0D7E < \u0D34\u0D4D , \u0D34 " +
                    "< \u0D31\u0D4D , \u0D31 < \u0D3A\u0D4D , \u0D3A < \u0D3D < \u0D3E " +
                    "< \u0D3F < \u0D40 < \u0D41\u0D4D , \u0D41 < \u0D42 < \u0D43 " +
                    "< \u0D44 < \u0D62 < \u0D63 < \u0D46 < \u0D47 < \u0D48 " +
                    "< \u0D4A < \u0D46\u0D3E < \u0D4B < \u0D47\u0D3E < \u0D4C < \u0D46\u0D57 " +
                    "< \u0D57 < \u0D4D");

    private static RuleBasedCollator mlCollator;

    static {
        try {
            mlCollator = new RuleBasedCollator(MALAYALAM_COLLATION_RULES);
        } catch (ParseException pe) {
            Log.e(UCASort.MODULE_NAME, "Error : " + pe.getMessage());
        }
    }

    public static final String MODULE_NAME = "UCA Sort";
    public static final String MODULE_INFORMATION = "Sorts a set of words linguistically";


    /**
     * Function to sort using collator
     *
     * @param text text to be sorted
     * @return string array
     */
    public static String[] sort(String text) {

        if (text == null) return null;

        String[] words = text.split(" ");
        Arrays.sort(words, mlCollator);

        return words;
    }

    /**
     * Function to sort using collator using text from android view which can be instance of textview.
     * Eg: TextView, EditText, Button
     *
     * @param v1 view
     * @return sorted string array
     */
    public static String[] sort(View v1) {

        String text = null;
        if (v1 instanceof TextView) {
            text = ((TextView) v1).getText().toString();
        }
        return sort(text);
    }


    /**
     * This function gives name of the module
     *
     * @return name of module
     */
    public static String getModuleName() {
        return UCASort.MODULE_NAME;
    }

    /**
     * This function gives a brief description of the module
     *
     * @return brief information regarding the module
     */
    public static String getModuleInformation() {
        return UCASort.MODULE_INFORMATION;
    }
}
