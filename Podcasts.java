package MusicApp;

public class Podcasts extends Content{
    int m_episodeNumber;

    public Podcasts(){
        super();
        m_episodeNumber = -1;
    }

    public Podcasts(String title, String artist, int numStreams, int episodeNumber){
        super(title, artist, numStreams);
        m_episodeNumber = episodeNumber;
    }

    public void play(){
        m_numStreams +=1;
        System.out.println("* PODCASTS NOISES PLAYING *");
    }
}
