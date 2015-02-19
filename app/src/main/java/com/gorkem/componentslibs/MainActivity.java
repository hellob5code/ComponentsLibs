package com.gorkem.componentslibs;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gorkem.shimmer.Shimmer;
import com.gorkem.shimmer.ShimmerTextView;

//ListActivity
public class MainActivity extends Activity {
//    ShimmerTextView tv;
//    Shimmer shimmer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);

//        String[] items = getResources().getStringArray(R.array.sample_list);
//
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
//        setListAdapter(adapter);
    }

//    public void toggleAnimation(View target) {
//        if (shimmer != null && shimmer.isAnimating()) {
//            shimmer.cancel();
//        } else {
//            shimmer = new Shimmer();
//            shimmer.start(tv);
//        }
//    }

//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        switch (position) {
//            case 0:
//                startSignInActivity(false);
//                break;
//            case 1:
//                startSignInActivity(true);
//                break;
//            case 2:
//                startMessageActivity();
//                break;
//            case 3:
//                startUploadActivity();
//                break;
//            case 4:
//                startStateSampleActivity();
//                break;
//        }
//    }
//
//    private void startStateSampleActivity() {
//        Intent intent = new Intent(this, StateSampleActivity.class);
//        startActivity(intent);
//    }
//
//    private void startUploadActivity() {
//        Intent intent = new Intent(this, UploadActivity.class);
//        startActivity(intent);
//    }
//
//    private void startSignInActivity(boolean isEndlessMode) {
//        Intent intent = new Intent(this, SignInActivity.class);
//        intent.putExtra(SignInActivity.EXTRAS_ENDLESS_MODE, isEndlessMode);
//        startActivity(intent);
//    }
//
//    private void startMessageActivity() {
//        Intent intent = new Intent(this, MessageActivity.class);
//        startActivity(intent);
//    }
}
