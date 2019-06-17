package designPatterns;

/**
 * Created by nav on 7/13/15.
 */
public class passBetweenClasses {
    public static void main(String[] args) {
        passBetweenClasses passBetweenClasses = new passBetweenClasses();
        passBetweenClasses.MyBool myBool = passBetweenClasses.new MyBool();
        myBool.printBool();
        passBetweenClasses.setStuff(false);
        myBool.printBool();

    }

    private Boolean stuff = true;

    public Boolean getStuff() {
        return stuff;
    }

    public void setStuff(Boolean stuff) {
        this.stuff = stuff;
    }

    public class MyBool {
        private Boolean bool;

        public MyBool() {
            this.bool = stuff;
        }

        public void printBool() {
            System.out.println(bool);
        }
    }
}


