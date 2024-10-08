package MusicApp;

public class Songs extends Content {

    public Songs(){
        super();
    }

    public Songs(String title, String artist, int numStreams){
        super(title, artist, numStreams);
    }

    public void play(){
        m_numStreams +=1;
        System.out.println("* " + m_title + " PLAYING *");
    }
}
