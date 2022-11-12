package com.abjust.player;
import javax.sound.midi.*;

public class PlayerCmd{

    /**
     *  Plays sequence for certain instrument and note.
     */
    public void play(int aInstrument, int aNote){
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, aInstrument,0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);        
    
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, aNote, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);
    
            ShortMessage b = new ShortMessage();
            a.setMessage(128, 1, aNote, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);
            
            player.setSequence(seq);
            player.start();
    
        } catch (Exception ex) {
                ex.printStackTrace();
            } 
    }
}
