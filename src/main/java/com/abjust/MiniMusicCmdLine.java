package com.abjust;
import com.abjust.errormessages.ErrorMessages;
import com.abjust.player.*;
/**
 * The class contains code for music application.
 */
public class MiniMusicCmdLine implements ErrorMessages
{
    public static void main( String[] args )
    {
        PlayerCmd mini = new PlayerCmd();
        if(!(args.length < 2))
        {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }else{
            System.out.println(MISSING_INPUT_ERROR);
        }
    }
}
