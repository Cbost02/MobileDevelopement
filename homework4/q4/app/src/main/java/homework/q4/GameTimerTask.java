package homework.q4;

import java.util.TimerTask;

public class GameTimerTask extends TimerTask
{
    private Game game;
    private GameView view;

    public GameTimerTask(Game game, GameView view)
    {
        this.game = game;
        this.view = view;
    }

    public void run()
    {
        // Move all the shapes
        game.move();

        view.postInvalidate();
    }

}
