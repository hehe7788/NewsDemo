package bupt.ycc.newsdemo.news.model;

import java.util.List;

import bupt.ycc.newsdemo.beans.NewsBean;
import bupt.ycc.newsdemo.beans.NewsDetailBean;
import bupt.ycc.newsdemo.common.Urls;
import bupt.ycc.newsdemo.news.NewsJsonUtils;
import bupt.ycc.newsdemo.news.widget.NewsFragment;
import bupt.ycc.newsdemo.utils.OkHttpUtils;

/**
 * Created by L.Y.C on 2016/4/24.
 */
public class NewsModelImpl implements NewsModel {

    @Override
    public void loadNews(String url, final int type, final NewsModelImpl.OnLoadNewsListListener listener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<NewsBean> newsBeanList = NewsJsonUtils.readJsonNewsBeans(response, getID(type));
                listener.onSuccess(newsBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news list failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    @Override
    public void loadNewsDetail(final String docid, final NewsModelImpl.OnLoadNewsDetailListener listener) {
        String url = getDetailUrl(docid);
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                NewsDetailBean newsDetailBean = NewsJsonUtils.readJsonNewsDetailBeans(response, docid);
                listener.onSuccess(newsDetailBean);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news detail info failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }
    /**
     * 获取ID
     * @param type
     * @return
     */
    private String getID(int type) {
        String id;
        switch (type) {
            case NewsFragment.NEWS_TYPE_TOP:
                id = Urls.TOP_ID;
                break;
            case NewsFragment.NEWS_TYPE_ENTERTAIN:
                id = Urls.ENTERTAIN_ID;
                break;
            case NewsFragment.NEWS_TYPE_ECONOMY:
                id = Urls.ECONOMY_ID;
                break;
            case NewsFragment.NEWS_TYPE_SOCIETY:
                id = Urls.SOCIETY_ID;
                break;
            default:
                id = Urls.TOP_ID;
                break;
        }
        return id;
    }

    private String getDetailUrl(String docId) {
        StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
        sb.append(docId).append(Urls.END_DETAIL_URL);
        return sb.toString();
    }
    public interface OnLoadNewsListListener {
        void onSuccess(List<NewsBean> list);
        void onFailure(String msg, Exception e);
    }

    public interface OnLoadNewsDetailListener {
        void onSuccess(NewsDetailBean newsDetailBean);
        void onFailure(String msg, Exception e);
    }
}
