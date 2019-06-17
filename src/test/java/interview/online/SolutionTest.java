package interview.online;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void test0() throws Exception {
        String[] in = new String[]{"[A,B,3]", "[B,C,5]", "[C,D,2]", "A->D,10"};
        assertEquals("A->B->C->D", Solution.getShortestPath(in));
    }

    @Test
    public void test1() throws Exception {
        String[] in = new String[]{"[A,B,3]","[B,C,5]","[C,D,2]","[A,C,7]", "A->D,10"};
        assertEquals("A->C->D", Solution.getShortestPath(in));
    }

    @Test
    public void test2() throws Exception {
        String[] in = new String[]{"[A,B,5]","[A,C,2]","[B,C,4]","[B,D,6]","[C,B,7]", "A->C,10"};
        assertEquals("E2", Solution.getShortestPath(in));
    }

    @Test
    public void test3() throws Exception {
        String[] in = new String[]{"[E,M,4]","[E,L,19]","[P,M,2]","[L,P,12]","[P,Q,10]","[Q,F,4]","[Q,G,7]","[F,A,3]","[G,H,10]","[H,A,3]","[G,A,5]","[F,L,7]","[A,L,2]", "H->E,25"};
        assertEquals("H->A->L->P->M->E", Solution.getShortestPath(in));
    }

    @Test
    public void test4() throws Exception {
        String[] in = new String[]{"[A,B,3]", "[A,C,2]", "[3,4,A]", "[!,@,2]", "A->B,4"};
        assertEquals("E1", Solution.getShortestPath(in));
    }

    @Test
    public void test5() throws Exception {
        String[] in = new String[]{"{A,B,3}", "{B,C,2}", "{D,E,2}", "{C,D,4}", "C->E,8"};
        assertEquals("E1", Solution.getShortestPath(in));
    }

    @Test
    public void test6() throws Exception {
        String[] in = new String[]{"[Q,F,2]","[Q,G,1]","[F,T,2]","[G,T,12]","[G,N,3]","[F,R,1]","[R,P,6]","[T,N,13]", "T->Z,30"};
        assertEquals("E2", Solution.getShortestPath(in));
    }

    @Test
    public void test7() throws Exception {
        String[] in = new String[]{"[O,M,8]","[M,W,3]","[W,P,4]","[M,S,3]","[S,G,2]","[M,G,4]","[P,A,8]","[M,O,2]","[A,S,12]","[A,T,4]", "A->W,20"};
        assertEquals("E2", Solution.getShortestPath(in));
    }

    @Test
    public void test8() throws Exception {
        String[] in = new String[]{"[A,B,5]","[A,C,7]","[B,C,1]","[C,D,3]","[A,D,8]","[D,E,3]", "A->E,10"};
        assertEquals("E3", Solution.getShortestPath(in));
    }

    @Test
    public void testCycle() throws Exception {
        String[] in = new String[]{"[A,B,3]","[A,C,7]","[B,C,4]","[C,D,2]","A->D,10"};
        assertEquals("E2", Solution.getShortestPath(in));
    }

}