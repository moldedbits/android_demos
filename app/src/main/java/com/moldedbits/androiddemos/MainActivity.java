package com.moldedbits.androiddemos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.moldedbits.androiddemos.library_demos.loader.LoaderDemoMainActivity;
import com.moldedbits.androiddemos.library_demos.timber.TimberDemoActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements
        DemoAdapter.DemoClickListener {

    @Bind(R.id.demo_list)
    RecyclerView mDemoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        populateDemos();
    }

    private void populateDemos() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mDemoList.setLayoutManager(manager);

        ArrayList<Demo> demos = new ArrayList<>();
        demos.add(new Demo("Timber", R.drawable.ic_menu_send, TimberDemoActivity.class));
        demos.add(new Demo("Loader", R.drawable.ic_menu_send, LoaderDemoMainActivity.class));
        DemoAdapter adapter = new DemoAdapter(this);
        adapter.addItems(demos);

        mDemoList.setAdapter(adapter);
    }

    @Override
    public void onDemoClicked(Demo demo) {
        Intent intent = new Intent(this, demo.activityClass);
        startActivity(intent);
    }

    public static class Demo {
        String title;
        int resId;
        Class activityClass;

        public Demo(String title, int resId, Class activityClass) {
            this.title = title;
            this.resId = resId;
            this.activityClass = activityClass;
        }
    }
}
