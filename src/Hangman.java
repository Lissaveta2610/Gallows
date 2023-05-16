package src;

public class Hangman {
    Man man = new Man();

    public String makeNewGallow() {
        return "\n   ________" + // 0
                "\n   |      |" + // 1
                "\n   |      " +// 2
                "\n   |      " + // 3
                "\n   |      " + // 4
                "\n   |     " + // 5
                "\n   |      " + // 6
                "\n   |____________";
    }

    public void addElementToGallow(int mistake) {

        switch (mistake) {
            case 0:
                System.out.println(makeNewGallow());
            case 1:
                System.out.println(Man.HEAD);
                break;

            case 2:
                System.out.println(Man.BODY_ONE);
                break;

            case 3:
                System.out.println(Man.BODY_TWO);
                break;

            case 4:
                System.out.println(Man.LEFT_ARM + Man.BODY_TWO);
                break;

            case 5:
                System.out.println(Man.RIGHT_ARM);
                break;

            case 6:
                System.out.println(Man.LEFT_FOOT + " ");
                break;

            case 7:
                System.out.println(Man.RIGHT_FOOT);
                break;

            default:
                break;
        }
    }
}
