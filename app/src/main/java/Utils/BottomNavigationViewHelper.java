package Utils;

import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationViewHelper {
    private static final String TAG = "bottomNavigationViewHel";
    public static void setupBottomNavigationView(BottomNavigationView bottomNavigationView){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        bottomNavigationView.setHorizontalFadingEdgeEnabled(true);
    }
}
