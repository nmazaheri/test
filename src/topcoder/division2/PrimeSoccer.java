package topcoder.division2;

/**
 * Created by navid.mazaheri on 12/31/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=10033
 *
 * This problem required basic knowledge of probability theory and combinatorics.

 First, let assume we know the probability that team A will score a prime number of goals (lets call this probability Pa)
 and that team B will score a prime number of goals (Pb). Since those events are independent, the probability that at
 least one team scores a prime number of goals will be equal to Pa + Pb - Pa * Pb.

 Now lets try to compute the probability that a team will score a prime number of goals. A 90-minute game contains only
 18 5-minute intervals, and a team can score at most one goal during such interval, therefore a team can score at most
 18 goals. Now we need to find all prime numbers Pi not greater than 18, compute the probabilities for each team to score
 exactly Pi goals, and sum those probabilities to get numbers Pa and Pb. To find primes you may either use the sieve of
 Eratosthenes, or just pre-code them into an array.

 The last but not the least - how to compute the probability for a team with skill S to score exactly K goals during a
 game? Assume that we've selected K intervals and want to compute the probability that the team has scored in each of
 those K intervals and did not score during any other interval. This probability is equal to SK * (1 - S)(18 - K)
 (SK is the probability to score during K intervals, and (1 - S)(18 - K) is the probability not to score in any of
 other (18 - K) intervals). And the last step - since there are 18! / (K! * (18 - K)!) ways to select K intervals,
 the final answer is Pa = (Sum over all primes K) (18! * SkillOfTeamAK * (1 - SkillOfTeamA)(18 - K) / (K! * (18 - K)!).
 Of course, to compute Pb you'll need to replace SkillOfTeamA by SkillOfTeamB.
 */
public class PrimeSoccer {
    private final int intervals = 18;
    private int[] primes = { 2, 3, 5, 7, 11, 13, 17 };
    int[] permut = { 153, 816, 8568, 31824, 31824, 8568, 18 };

    public static void main(String[] args) {
        PrimeSoccer primeSoccer = new PrimeSoccer();
        System.out.println(primeSoccer.getProbability(50, 50));

    }

    public double getProbability(int skillOfTeamA, int skillOfTeamB) {
        double sA = skillOfTeamA / 100.0;
        double sB = skillOfTeamB / 100.0;

        double probA = 0;
        double probB = 0;

        for (int i = 0; i < primes.length; i++) {
            probA += Math.pow(sA, primes[i]) * Math.pow((1.0 - sA), (intervals - primes[i])) * permut[i];
            probB += Math.pow(sB, primes[i]) * Math.pow((1.0 - sB), (intervals - primes[i])) * permut[i];
        }

        probA = 1.0 - probA;
        probB = 1.0 - probB;

        return 1.0 - (probA * probB);
    }
}
