package main;

public class Application {
    public static void main(String[] args) {

        String pathToFile = FileUtils.getPathToAdvicesFile(args);
        try {
            new Advicer().showAdvice(FileUtils.getRandomMessageFromFile(pathToFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

