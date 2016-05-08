package bupt.ycc.newsdemo.main.widget;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import bupt.ycc.newsdemo.R;
import bupt.ycc.newsdemo.main.presenter.MainPresenter;
import bupt.ycc.newsdemo.main.presenter.MainPresenterImpl;
import bupt.ycc.newsdemo.main.view.MainView;
import bupt.ycc.newsdemo.news.widget.NewsFragment;
import bupt.ycc.newsdemo.weather.widget.WeatherFragment;

public class MainActivity extends AppCompatActivity implements MainView {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    private MainPresenter mMainPresenter;
    private int menuId = R.id.navigation_item_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);

        mMainPresenter = new MainPresenterImpl(this);

        switch2News();
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    if (menuId != menuItem.getItemId()) {
                        mMainPresenter.switchNavigation(menuItem.getItemId());
                        menuId = menuItem.getItemId();
                    }
                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return true;
                }
            });
    }

    @Override
    public void switch2News() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, new NewsFragment())
                .commit();
        mToolbar.setTitle(R.string.navigation_news);
    }

    @Override
    public void switch2Weather() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, new WeatherFragment())
                .commit();
        mToolbar.setTitle(R.string.navigation_weather);
    }

    @Override
    public void switch2About() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content, new AboutFragment())
                .commit();
        mToolbar.setTitle(R.string.navigation_about);
    }
}
