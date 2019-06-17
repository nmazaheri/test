package interview.online;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {
    Solution2 solution2 = new Solution2();

    @Test
    public void test0() {
        String [] in = new String[] {"Name=John Sex=Man Age=46 Country=UK", "Name=Anita Sex=Woman Age=22 Country=NL"};
        String answer = solution2.GetNameFromRegistryByTraits(in, "Sex=Woman");
        assertEquals("Anita", answer);
    }

    @Test
    public void test4() {
        String [] in = new String[] {"Name=John Sex=Man Age=46 Country=US=&@!#",
                "Name=Anita Sex=Woman Age=22 Country=NL",
                "Name=Keiko Sex=Woman Age=37 Country=JP",
                "Name=Denny Sex=Man Age=13 Country=NL",
                "Name=Mirjam Sex=Woman Age=28 Country=BE",
                "Name=Johnny Sex=Man Age=8 Country=UK",
                "Name=Anna Sex=Woman Age=71 Country=SW",
                "Name=Fred Sex=Man Age=51 Country=NL",
                "Name=Frederique Sex=Woman Age=51 Country=FR",
                "Name=Rob Sex=Man Age=42 Country=US",
                "Name=Robin Sex=Man Age=46 Country=US",
                "Name=Magda Sex=Woman Age=29 Country=PL",
                "Name=Peter Sex=Man Age=66 Country=RU",
                "Name=Pete Sex=Man Age=66 Country=US",
                "Name=Xiaoling Sex=Woman Age=26 Country=CH"};
        String answer = solution2.GetNameFromRegistryByTraits(in, "Name=Xiaoling");
        assertEquals("Error", answer);
    }

}