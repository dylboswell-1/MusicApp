package MusicApp;
import java.lang.Comparable;
public abstract class Content implements Comparable<Content>{
    String m_title;
    String m_artist;
    int m_numStreams;

    public Content(){
        m_title = "";
        m_artist = "";
        m_numStreams = 0;
    }

    public Content(String title, String artist, int streams){
        m_title = title;
        m_artist = artist;
        m_numStreams = streams;
    }

    public abstract void play();

    
    public int compareTo(Content c) {

        int ret;
        if (this.m_numStreams > c.m_numStreams) {
          ret = 1;
        } else if (this.m_numStreams < c.m_numStreams) {
          ret = -1;
        } else { // If the number of streams is the same
          ret = 0;
        }
        return ret;
  }
    
}
