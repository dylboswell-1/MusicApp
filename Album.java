package MusicApp;
import java.util.LinkedList;
public class Album extends ContentCollection{
    
  public Album(){
    super();
  }

  public Album(String title, LinkedList<Content> ll){
    super(title,ll);
  }

  public void play(){
    for(Content c: m_contentList){
        c.play();
    }
  }


  public int compareTo(Album a) { // sorts the albums by their size
    int ret;
    if (this.m_contentList.size() > a.m_contentList.size()) {
      ret = 1;
    } else if (this.m_contentList.size() < a.m_contentList.size()) {
      ret = -1;
    } else { // if the size is the same
      ret = 0;
    }
    return ret;
  }


}
