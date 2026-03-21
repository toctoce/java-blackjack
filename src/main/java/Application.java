import config.AppConfig;
import domain.BlackJackRunner;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BlackJackRunner blackJackRunner = appConfig.blackJackRunner();

        blackJackRunner.run();
    }
}
