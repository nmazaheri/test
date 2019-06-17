package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by nav on 12/1/15.
 */
public class FileIterable implements Iterable<String> {
    BufferedReader in;

    public FileIterable(String filename) throws FileNotFoundException {
        in = new BufferedReader(new FileReader(filename));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                try {
                    in.mark(1);
                    if (in.read() < 0)
                        return false;
                    in.reset();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }

            @Override
            public String next() {
                try {
                    return in.readLine();
                } catch (IOException e) {
                    return null;
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        try {
            String filename = "/Users/nav/Documents/workspace/test/src/file/sample.txt";
            Iterator<String> fileIter = new FileIterable(filename).iterator();
            System.out.println(fileIter.hasNext());
            System.out.println(fileIter.next());
            System.out.println(fileIter.next());
            System.out.println(fileIter.hasNext());
            System.out.println(fileIter.next());
            System.out.println(fileIter.hasNext());
            System.out.println(fileIter.next());
            System.out.println(fileIter.hasNext());
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
