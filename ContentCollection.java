package MusicApp;

import java.util.LinkedList;
import java.lang.Comparable;
import java.util.Random;
public abstract class ContentCollection implements Comparable<ContentCollection>{

    String m_title;
    LinkedList<Content> m_contentList;
    Random rand = new Random();

    public ContentCollection(){
        m_title = "";
        m_contentList = new LinkedList<Content>();
    }

    public ContentCollection(String title, LinkedList<Content> LL){
        m_title = title;
        m_contentList = LL;
    }

    public abstract void play();

    public void shuffle(){
        int number = rand.nextInt(0,m_contentList.size());
        m_contentList.get(number).play();
    }

    public int compareTo(ContentCollection cc) { // sorts the playlists by their size
      int ret;
      if (this.m_contentList.size() > cc.m_contentList.size()) {
        ret = 1;
      } else if (this.m_contentList.size() < cc.m_contentList.size()) {
        ret = -1;
      } else { // if the size is the same
        ret = 0;
      }
      return ret;
    }
    
}
