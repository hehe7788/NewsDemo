package bupt.ycc.newsdemo.news.model;

/**
 * Created by L.Y.C on 2016/4/24.
 */
public interface NewsModel {
    void loadNews(String ulr, int type, NewsModelImpl.OnLoadNewsListListener listener);
    void loadNewsDetail(String docid, NewsModelImpl.OnLoadNewsDetailListener listener);
}
