package division2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navid.mazaheri on 12/3/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=2913
 */

public class UserName {
    public static void main(String args[]) {
        UserName userName = new UserName();
        System.out.println(
                userName.newMember(new String[] { "MasterOfDisaster", "DingBat", "Orpheus", "WolfMan", "MrKnowItAll" },
                        "TygerTyger"));
        System.out.println(userName.newMember(
                new String[] { "MasterOfDisaster", "TygerTyger1", "DingBat", "Orpheus", "TygerTyger", "WolfMan",
                        "MrKnowItAll" }, "TygerTyger"));
        System.out.println(userName.newMember(
                new String[] { "TygerTyger2000", "TygerTyger1", "MasterDisaster", "DingBat", "Orpheus", "WolfMan",
                        "MrKnowItAll" }, "TygerTyger"));
        System.out.println(userName.newMember(
                new String[] { "grokster2", "BrownEyedBoy", "Yoop", "BlueEyedGirl", "grokster", "Elemental",
                        "NightShade", "Grokster1" }, "grokster"));
        System.out.println(userName.newMember(
                new String[] { "Bart4", "Bart5", "Bart6", "Bart7", "Bart8", "Bart9", "Bart10", "Lisa", "Marge", "Homer",
                        "Bart", "Bart1", "Bart2", "Bart3", "Bart11", "Bart12" }, "Bart"));
    }

    public String newMember(String[] existingNames, String newName) {
        List<String> similarNames = new ArrayList<>();
        for (String name : existingNames) {
            if (name.startsWith(newName))
                similarNames.add(name);
        }

        int numToAppend = 1;
        String suggestedName = newName;
        while (similarNames.contains(suggestedName)) {
            suggestedName = newName + numToAppend++;
        }
        return suggestedName;
    }
}
