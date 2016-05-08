package bupt.ycc.newsdemo.news.presenter;

import java.util.List;

import bupt.ycc.newsdemo.beans.NewsBean;
import bupt.ycc.newsdemo.common.Urls;
import bupt.ycc.newsdemo.news.model.NewsModel;
import bupt.ycc.newsdemo.news.model.NewsModelImpl;
import bupt.ycc.newsdemo.news.view.NewsView;
import bupt.ycc.newsdemo.news.widget.NewsFragment;
import bupt.ycc.newsdemo.utils.LogUtils;

/**
 * Created by L.Y.C on 2016/4/24.
 */
public class NewsPresenterImpl implements NewsPresenter, NewsModelImpl.OnLoadNewsListListener {

    private static final String TAG = "NewsPresenterImpl";

    private NewsView mNewsView;
    private NewsModel mNewsModel;

    public NewsPresenterImpl(NewsView newsView) {
        mNewsView = newsView;
        mNewsModel = new NewsModelImpl();
    }

    @Override
    public void loadNews(int type, int page) {
        String url = getUrl(type, page);
        LogUtils.d(TAG, url);
        if (page == 0) {
            mNewsView.showProgress();
        }
        //Presenter层调用Model层接口
        mNewsModel.loadNews(url, type, NewsPresenterImpl.this);
    }

    /**
     * 根据类别和页面索引创建rul
     */
    private String getUrl(int type, int page) {
        StringBuilder sb = new StringBuilder();
        switch (type) {
            case NewsFragment.NEWS_TYPE_TOP:
                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
                break;
            case NewsFragment.NEWS_TYPE_ENTERTAIN:
                sb.append(Urls.COMMON_URL).append(Urls.ENTERTAIN_ID);
                break;
            case NewsFragment.NEWS_TYPE_ECONOMY:
                sb.append(Urls.COMMON_URL).append(Urls.ECONOMY_ID);
                break;
            case NewsFragment.NEWS_TYPE_SOCIETY:
                sb.append(Urls.COMMON_URL).append(Urls.SOCIETY_ID);
                break;
            default:
                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
                break;
        }
        sb.append("/").append(page).append(Urls.END_URL);
        return sb.toString();
    }

    //是model层接口，由model层调用，由Presenter实现
    @Override
    public void onSuccess(List<NewsBean> list) {
        mNewsView.hideProgress();
        mNewsView.addNews(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mNewsView.hideProgress();
        mNewsView.showLoadFailMsg();
    }
}
