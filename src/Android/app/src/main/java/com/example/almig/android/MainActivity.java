package com.example.almig.android;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.almig.android.adapter.DrawerAdapter;
import com.example.almig.android.fragment.CulturalAssetsFragment;
import com.example.almig.android.fragment.FootprintFragment;
import com.example.almig.android.fragment.HomeFragment;
import com.example.almig.android.fragment.PathfindingFragment;
import com.example.almig.android.fragment.SearchFragment;
import com.example.almig.android.fragment.StampAuthFragment;
import com.example.almig.android.geofence.GeofenceErrorMessages;
import com.example.almig.android.geofence.GeofenceTransitionsIntentService;
import com.example.almig.android.model.DrawerItem;
import com.example.almig.android.util.ImageUtil;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.almig.android.model.DrawerItem.DRAWER_ITEM_TAG_HOME;
import static com.example.almig.android.model.DrawerItem.DRAWER_ITEM_TAG_STAMP_AUTH;

public class MainActivity extends AppCompatActivity implements OnCompleteListener<Void> {
    private static final String TAG = LoadingActivity.class.getSimpleName();
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;

    private static final String PACKAGE_NAME = "com.google.android.gms.location.Geofence";
    static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";
    private static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;
    static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS = GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    static final int GEOFENCE_RADIUS_IN_METERS = 50;
    static final HashMap<String, LatLng> BAY_AREA_LANDMARKS = new HashMap<>();

    static {
        BAY_AREA_LANDMARKS.put("첨성대", new LatLng(35.233706, 129.089205));
    }

    /**
     * Tracks whether the user requested to add or remove geofences, or to do neither.
     */
    private enum PendingGeofenceTask {
        ADD, REMOVE, NONE
    }

    /**
     * Provides access to the Geofencing API.
     */
    private GeofencingClient mGeofencingClient;

    /**
     * The list of geofences used in this sample.
     */
    private ArrayList<Geofence> mGeofenceList;

    /**
     * Used when requesting to add or remove geofences.
     */
    private PendingIntent mGeofencePendingIntent;
    private PendingGeofenceTask mPendingGeofenceTask = PendingGeofenceTask.NONE;

    private ImageLoader mImageLoader;
    private Toolbar mToolbar;
    private Resources mRes;

    private ListView mDrawerList;
    private List<DrawerItem> mDrawerItems;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private Handler mHandler;
    private boolean mShouldFinish = false;

    private TextView mTvToolbarTitle;

    private void initBinding() {
        // Empty list for storing geofences.
        mGeofenceList = new ArrayList<>();
        // Initially set the PendingIntent used in addGeofences() and removeGeofences() to null.
        mGeofencePendingIntent = null;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerList = (ListView) findViewById(R.id.lv_menu_list);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);
//        mTvToolbarTitle = (TextView) findViewById(R.id.tb_title);

        mHandler = new Handler();
        mRes = getResources();
    }

    private void initImageLoader() {
        mImageLoader = ImageLoader.getInstance();
        if (!mImageLoader.isInited()) {
            mImageLoader.init(ImageLoaderConfiguration.createDefault(this));
        }
    }

    private void initNavDrawerItems() {
        mDrawerItems = new ArrayList<>();
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_travel), R.string.activity_title_home, DRAWER_ITEM_TAG_HOME));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_map), R.string.activity_title_pathfinding, DrawerItem.DRAWER_ITEM_TAG_PATHFINDING));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_book), R.string.activity_title_cultural_assets, DrawerItem.DRAWER_ITEM_TAG_CULTURAL_ASSETS));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_search), R.string.activity_title_search, DrawerItem.DRAWER_ITEM_TAG_SEARCH));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_footprint), R.string.activity_title_footprint, DrawerItem.DRAWER_ITEM_TAG_FOOTPRINT));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_stamp), R.string.activity_title_stamp_auth, DrawerItem.DRAWER_ITEM_TAG_STAMP_AUTH));
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
//        mTvToolbarTitle.setText(R.string.app_name);
//        mTvToolbarTitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/custom2.ttf"));
        getSupportActionBar().setTitle(mRes.getString(R.string.app_name));
    }

    private void initDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
    }

    private void initAdapter() {
        View headerView = initHeaderView(R.layout.header_nav_drawer, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "almighty911216@gmail.com");
        BaseAdapter adapter = new DrawerAdapter(this, mDrawerItems);
        mDrawerList.addHeaderView(headerView);// Add header before adapter (for// pre-KitKat)
        mDrawerList.setAdapter(adapter);
    }

    private View initHeaderView(int layoutRes, String url, String email) {
        View headerView = getLayoutInflater().inflate(layoutRes, mDrawerList, false);
        ImageView iv = (ImageView) headerView.findViewById(R.id.iv_profile);
        TextView tv = (TextView) headerView.findViewById(R.id.rtv_email);

        ImageUtil.displayRoundImage(iv, url, null);
        tv.setText(email);

        return headerView;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0: // Header를 클릭할 경우
                    return;

                case DRAWER_ITEM_TAG_HOME:
                    setTitle(mRes.getString(R.string.app_name));
                    break;

                default:
                    setTitle(mDrawerItems.get(position - 1).getTitle());
                    break;
            }

            selectItem(position, mDrawerItems.get(position - 1).getTag());
        }
    }

    private void selectItem(int position, int drawerTag) {
        Fragment fragment = getFragmentByDrawerTag(drawerTag);
        commitFragment(fragment);

        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    private Fragment getFragmentByDrawerTag(int drawerTag) {
        Fragment fragment;

        switch (drawerTag) {
            case DrawerItem.DRAWER_ITEM_TAG_PATHFINDING:
                fragment = PathfindingFragment.newInstance();
                break;

            case DrawerItem.DRAWER_ITEM_TAG_CULTURAL_ASSETS:
                fragment = CulturalAssetsFragment.newInstance();
                break;

            case DrawerItem.DRAWER_ITEM_TAG_SEARCH:
                fragment = SearchFragment.newInstance();
                break;

            case DrawerItem.DRAWER_ITEM_TAG_FOOTPRINT:
                fragment = FootprintFragment.newInstance();
                break;

            case DrawerItem.DRAWER_ITEM_TAG_STAMP_AUTH:
                fragment = StampAuthFragment.newInstance();
                break;

            default:
                fragment = HomeFragment.newInstance();
        }

        mShouldFinish = false;

        return fragment;
    }

    private class CommitFragmentRunnable implements Runnable {

        private Fragment fragment;

        public CommitFragmentRunnable(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void run() {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit();
        }
    }

    public void commitFragment(Fragment fragment) {
        // Using Handler class to avoid lagging while
        // committing fragment in same time as closing
        // navigation drawer
        mHandler.post(new CommitFragmentRunnable(fragment));
    }

    /**
     * Builds and returns a GeofencingRequest. Specifies the list of geofences to be monitored.
     * Also specifies how the geofence notifications are initially triggered.
     */
    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();

        // The INITIAL_TRIGGER_ENTER flag indicates that geofencing service should trigger a
        // GEOFENCE_TRANSITION_ENTER notification when the geofence is added and if the device
        // is already inside that geofence.
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);

        // Add the geofences to be monitored by geofencing service.
        builder.addGeofences(mGeofenceList);

        // Return a GeofencingRequest.
        return builder.build();
    }


    /**
     * Adds geofences. This method should be called after the user has granted the location
     * permission.
     */
    @SuppressWarnings("MissingPermission")
    private void addGeofences() {
        mGeofencingClient.addGeofences(getGeofencingRequest(), getGeofencePendingIntent()).addOnCompleteListener(this);
    }

    /**
     * Removes geofences. This method should be called after the user has granted the location
     * permission.
     */
    @SuppressWarnings("MissingPermission")
    private void removeGeofences() {
        mGeofencingClient.removeGeofences(getGeofencePendingIntent()).addOnCompleteListener(this);
    }

    /**
     * Runs when the result of calling {@link #addGeofences()} and/or {@link #removeGeofences()}
     * is available.
     *
     * @param task the resulting Task, containing either a result or error.
     */
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        mPendingGeofenceTask = PendingGeofenceTask.NONE;
        if (task.isSuccessful()) {
            updateGeofencesAdded(!getGeofencesAdded());

            int messageId = getGeofencesAdded() ? R.string.geofences_added : R.string.geofences_removed;
            Toast.makeText(this, getString(messageId), Toast.LENGTH_SHORT).show();
        } else {
            // Get the status code for the error and log it using a user-friendly message.
            String errorMessage = GeofenceErrorMessages.getErrorString(this, task.getException());
            Log.w(TAG, errorMessage);
        }
    }

    /**
     * Gets a PendingIntent to send with the request to add or remove Geofences. Location Services
     * issues the Intent inside this PendingIntent whenever a geofence transition occurs for the
     * current list of geofences.
     *
     * @return A PendingIntent for the IntentService that handles geofence transitions.
     */
    private PendingIntent getGeofencePendingIntent() {
        // Reuse the PendingIntent if we already have it.
        if (mGeofencePendingIntent != null) {
            return mGeofencePendingIntent;
        }
        Intent intent = new Intent(this, GeofenceTransitionsIntentService.class);
        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when calling
        // addGeofences() and removeGeofences().
        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    /**
     * This sample hard codes geofence data. A real app might dynamically create geofences based on
     * the user's location.
     */
    private void populateGeofenceList() {
        for (Map.Entry<String, LatLng> entry : BAY_AREA_LANDMARKS.entrySet()) {

            mGeofenceList.add(new Geofence.Builder()
                    // Set the request ID of the geofence. This is a string to identify this
                    // geofence.
                    .setRequestId(entry.getKey())

                    // Set the circular region of this geofence.
                    .setCircularRegion(
                            entry.getValue().latitude,
                            entry.getValue().longitude,
                            GEOFENCE_RADIUS_IN_METERS
                    )

                    // Set the expiration duration of the geofence. This geofence gets automatically
                    // removed after this period of time.
                    .setExpirationDuration(GEOFENCE_EXPIRATION_IN_MILLISECONDS)

                    // Set the transition types of interest. Alerts are only generated for these
                    // transition. We track entry and exit transitions in this sample.
                    .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER |
                            Geofence.GEOFENCE_TRANSITION_EXIT)

                    // Create the geofence.
                    .build());
        }
    }

    /**
     * Shows a {@link Snackbar} using {@code text}.
     *
     * @param text The Snackbar text.
     */
    private void showSnackbar(final String text) {
        View container = findViewById(android.R.id.content);
        if (container != null) {
            Snackbar.make(container, text, Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * Shows a {@link Snackbar}.
     *
     * @param mainTextStringId The id for the string resource for the Snackbar text.
     * @param actionStringId   The text of the action item.
     * @param listener         The listener associated with the Snackbar action.
     */
    private void showSnackbar(final int mainTextStringId, final int actionStringId,
                              View.OnClickListener listener) {
        Snackbar.make(
                findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show();
    }

    /**
     * Returns true if geofences were added, otherwise false.
     */
    private boolean getGeofencesAdded() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(GEOFENCES_ADDED_KEY, false);
    }

    private void updateGeofencesAdded(boolean added) {
        PreferenceManager.getDefaultSharedPreferences(this)
                .edit()
                .putBoolean(GEOFENCES_ADDED_KEY, added)
                .apply();
    }

    /**
     * Performs the geofencing task that was pending until location permission was granted.
     */
    private void performPendingGeofenceTask() {
        if (mPendingGeofenceTask == PendingGeofenceTask.ADD) {
            addGeofences();
        } else if (mPendingGeofenceTask == PendingGeofenceTask.REMOVE) {
            removeGeofences();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        removeGeofences();
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String place = extras.getString("place");
            setTitle("도장 찍기");
            selectItem(5, DRAWER_ITEM_TAG_STAMP_AUTH);
        }

        performPendingGeofenceTask();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBinding();
        initImageLoader();
        initToolbar();
        initDrawerToggle();

        mTitle = mDrawerTitle = getTitle();

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        initNavDrawerItems();
        initAdapter();
        mDrawerList.setAdapter(new DrawerAdapter(this, mDrawerItems));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        //mDrawerLayout.addDrawerListener(mDrawerToggle);

        selectItem(1, DRAWER_ITEM_TAG_HOME);

        // Get the geofences used. Geofence data is hard coded in this sample.
        populateGeofenceList();
        mGeofencingClient = LocationServices.getGeofencingClient(this);
        addGeofences();
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getString(titleId));
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (!mShouldFinish && !mDrawerLayout.isDrawerOpen(mDrawerList)) {
            Toast.makeText(getApplicationContext(), R.string.confirm_exit, Toast.LENGTH_SHORT).show();
            mShouldFinish = true;
            mDrawerLayout.openDrawer(mDrawerList);
        } else if (!mShouldFinish && mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            super.onBackPressed();
        }
    }
}