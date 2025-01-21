package Views;

public class IntroScreenView {
    public static void display() {
        String name = AskPlayerNameView.display();
        String intro =
                "  ____       _           _     __        __            \n" +
                        " |  _ \\ ___ | |__   __ _| |_ __\\ \\      / /_ _ _ __ ___ \n" +
                        " | |_) / _ \\| '_ \\ / _` | __/ _ \\ \\ /\\ / / _` | '__/ _ \\\n" +
                        " |  _ < (_) | |_) | (_| | ||  __/\\ V  V / (_| | | |  __/\n" +
                        " |_| \\_\\___/|_.__/ \\__,_|\\__\\___| \\_/\\_/ \\__,_|_|  \\___|\n" +
                        "                                                       \n" +
                        "                                                       \n";

        System.out.println(intro);
    }
}
