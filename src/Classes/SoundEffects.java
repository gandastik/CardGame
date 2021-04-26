package Classes;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundEffects {

    //Buttons
    private Media menuClick;
    private MediaPlayer menuClickPlayer;

    //Critical sfx
    private Media criticalSound;
    private MediaPlayer criticalMediaPlayer;

    //Card takes dmg sfx
    private Media takeDmgSound;
    private MediaPlayer takeDmgMediaPlayer;

    //Selling Cards sfx
    private Media sellingSound;
    private MediaPlayer sellingMediaPlayer;

    //Healing sfx
    private Media healingSound;
    private MediaPlayer healingMediaPlayer;

    public void playMenuClick() {
        menuClick = new Media(getClass().getResource("/Assets/sfx/click.wav").toExternalForm());
        menuClickPlayer = new MediaPlayer(menuClick);
        this.menuClickPlayer.play();
    }

    public void playCritical() {
        this.criticalSound = new Media(getClass().getResource("/Assets/sfx/strongpunch.mp3").toExternalForm());
        this.criticalMediaPlayer = new MediaPlayer(this.criticalSound);
        this.criticalMediaPlayer.setVolume(0.25);
        this.criticalMediaPlayer.play();
    }

    public void playTakeDmg() {
        this.takeDmgSound = new Media(getClass().getResource("/Assets/sfx/classic_hurt.mp3").toExternalForm());
        this.takeDmgMediaPlayer = new MediaPlayer(this.takeDmgSound);
        this.takeDmgMediaPlayer.setVolume(0.15);
        this.takeDmgMediaPlayer.play();
    }

    public void playSelling(){
        this.sellingSound = new Media(getClass().getResource("/Assets/sfx/selling.wav").toExternalForm());
        this.sellingMediaPlayer = new MediaPlayer(this.sellingSound);
        this.sellingMediaPlayer.setVolume(0.15);
        this.sellingMediaPlayer.play();
    }

    public void playHealing() {
        this.healingSound = new Media(getClass().getResource("/Assets/sfx/healing.wav").toExternalForm());
        this.healingMediaPlayer = new MediaPlayer(this.healingSound);
        this.healingMediaPlayer.setVolume(0.10);
        this.healingMediaPlayer.play();
    }
}
