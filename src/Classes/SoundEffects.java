package Classes;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundEffects {

    //Background Music
    public static MediaPlayer bgMediaPlayer;

    public static void playBackgroundMusic() {
        Media bgMedia = new Media(SoundEffects.class.getResource("../Assets/sfx/bgmusic.mp3").toExternalForm());
        bgMediaPlayer = new MediaPlayer(bgMedia);
        bgMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        bgMediaPlayer.setVolume(0.025);
        bgMediaPlayer.play();
    }

    public static void stopBgMusic() {
        bgMediaPlayer.stop();
    }

    public static void playMenuClick() {
        Media menuClick = new Media(SoundEffects.class.getResource("/Assets/sfx/click.wav").toExternalForm());
        MediaPlayer menuClickPlayer = new MediaPlayer(menuClick);
        menuClickPlayer.play();
    }

    public static void playCritical() {
        Media criticalSound = new Media(SoundEffects.class.getResource("/Assets/sfx/strongpunch.mp3").toExternalForm());
        MediaPlayer criticalMediaPlayer = new MediaPlayer(criticalSound);
        criticalMediaPlayer.setVolume(0.25);
        criticalMediaPlayer.play();
    }

    public static void playTakeDmg() {
        Media takeDmgSound = new Media(SoundEffects.class.getResource("/Assets/sfx/attack.mp3").toExternalForm());
        MediaPlayer takeDmgMediaPlayer = new MediaPlayer(takeDmgSound);
        takeDmgMediaPlayer.setVolume(0.50);
        takeDmgMediaPlayer.play();
    }

    public static void playSelling(){
        Media sellingSound = new Media(SoundEffects.class.getResource("/Assets/sfx/selling.wav").toExternalForm());
        MediaPlayer sellingMediaPlayer = new MediaPlayer(sellingSound);
        sellingMediaPlayer.setVolume(0.15);
        sellingMediaPlayer.play();
    }

    public static void playHealing() {
        Media healingSound = new Media(SoundEffects.class.getResource("/Assets/sfx/healing.wav").toExternalForm());
        MediaPlayer healingMediaPlayer = new MediaPlayer(healingSound);
        healingMediaPlayer.setVolume(0.10);
        healingMediaPlayer.play();
    }
}
