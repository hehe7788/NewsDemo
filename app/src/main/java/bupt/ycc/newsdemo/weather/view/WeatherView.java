package bupt.ycc.newsdemo.weather.view;

import java.util.List;

import bupt.ycc.newsdemo.beans.WeatherBean;

/**
 * Created by L.Y.C on 2016/5/8.
 */
public interface WeatherView {
    void showProgress();
    void hideProgress();
    void showWeatherLayout();

    void setCity(String city);
    void setToday(String data);
    void setTemperature(String temperature);
    void setWind(String wind);
    void setWeather(String weather);
    void setWeatherImage(int res);
    void setWeatherData(List<WeatherBean> lists);

    void showErrorToast(String msg);
}
