import config.AppConfig;
import controller.BlackJackRunner;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BlackJackRunner blackJackRunner = appConfig.blackJackController();

        blackJackRunner.run();
    }
}
