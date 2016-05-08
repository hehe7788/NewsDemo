package bupt.ycc.newsdemo.news.view;

import java.util.List;

import bupt.ycc.newsdemo.beans.NewsBean;

/**
 * Created by L.Y.C on 2016/4/24.
 * 按照功能写接口
 */
public interface NewsView {
    void showProgress();

    void addNews(List<NewsBean> newsList);

    void hideProgress();

    void showLoadFailMsg();
}
