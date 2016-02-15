package com.moldedbits.androiddemos.library_demos.loader;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.moldedbits.androiddemos.R;
import com.moldedbits.androiddemos.library_demos.loader.loader.ExampleLoader;
import com.moldedbits.androiddemos.library_demos.loader.model.Example;

import timber.log.Timber;

public class LoaderActivity extends AppCompatActivity {

    ExampleLoader mLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_main);

        populateExample();
    }

    private void populateExample() {
        getSupportLoaderManager().initLoader(0, null, mCallbacks);
    }

    private LoaderManager.LoaderCallbacks<Example> mCallbacks =
            new LoaderManager.LoaderCallbacks<Example>() {
                @Override
                public Loader<Example> onCreateLoader(int id, Bundle args) {
                    mLoader = new ExampleLoader(LoaderActivity.this);
                    return mLoader;
                }

                @Override
                public void onLoadFinished(Loader<Example> loader, Example data) {
                    if (data == null) {
                        handleError(mLoader.getLastError());
                    } else {
                        ((TextView) findViewById(R.id.text)).setText(data.toString());
                    }
                }

                @Override
                public void onLoaderReset(Loader<Example> loader) {

                }
            };

    private void handleError(Throwable t) {
        Timber.e(t, "Could not get example");
    }

    public void refresh(View view) {
        ((TextView) findViewById(R.id.text)).setText(R.string.app_name);
        getSupportLoaderManager().restartLoader(0, null, mCallbacks);
    }
}
