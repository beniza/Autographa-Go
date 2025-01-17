package com.bridgeconn.autographago.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.bridgeconn.autographago.R;
import com.bridgeconn.autographago.models.SearchModel;
import com.bridgeconn.autographago.ormutils.AllMappers;
import com.bridgeconn.autographago.ormutils.AllSpecifications;
import com.bridgeconn.autographago.ormutils.AutographaRepository;
import com.bridgeconn.autographago.ormutils.Mapper;
import com.bridgeconn.autographago.ormutils.Specification;
import com.bridgeconn.autographago.ui.adapters.HistoryAdapter;
import com.bridgeconn.autographago.utils.Constants;
import com.bridgeconn.autographago.utils.SharedPrefs;
import com.bridgeconn.autographago.utils.UtilFunctions;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private HistoryAdapter mAdapter;
    private ArrayList<SearchModel> mHistoryModels = new ArrayList<>();
    private String languageCode, versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(SharedPrefs.getFontSize().getResId(), true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        UtilFunctions.applyReadingMode();

        languageCode = SharedPrefs.getString(Constants.PrefKeys.LAST_OPEN_LANGUAGE_CODE, "ENG");
        versionCode = SharedPrefs.getString(Constants.PrefKeys.LAST_OPEN_VERSION_CODE, Constants.VersionCodes.ULB);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_history);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HistoryAdapter(this, mHistoryModels);
        mRecyclerView.setAdapter(mAdapter);

        findViewById(R.id.clear_history).setOnClickListener(this);

        getAllHistory();
    }

    private void getAllHistory() {
        // TODO FIX CRASH HERE
        // io.realm.exceptions.RealmError: Unrecoverable error. mmap() failed: Out of memory size: 1342177280 offset: 0 in io_realm_internal_SharedGroup.cpp line 113
        mHistoryModels.clear();
        final Realm realm = Realm.getDefaultInstance();
        ArrayList<SearchModel> models = query(realm, new AllSpecifications.AllHistory(languageCode, versionCode), new AllMappers.HistoryMapper());
        for (SearchModel model : models) {
            SearchModel searchModel = new SearchModel();
            searchModel.setBookName(model.getBookName());
            searchModel.setBookId(model.getBookId());
            searchModel.setChapterNumber(model.getChapterNumber());
            searchModel.setVerseNumber(model.getVerseNumber());
            mHistoryModels.add(searchModel);
        }
        realm.close();
        mAdapter.notifyDataSetChanged();
    }

    public ArrayList<SearchModel> query(Realm realm, Specification<SearchModel> specification, Mapper<SearchModel, SearchModel> mapper) {
        RealmResults<SearchModel> realmResults = specification.generateResults(realm);
        ArrayList<SearchModel> resultsToReturn = new ArrayList<>();
        for (SearchModel result : realmResults) {
            resultsToReturn.add(mapper.map(result));
        }
        return resultsToReturn;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear_history: {
                new AutographaRepository<SearchModel>().remove(new AllSpecifications.AllHistory(languageCode, versionCode));
                mHistoryModels.clear();
                mAdapter.notifyDataSetChanged();
                break;
            }
        }
    }
}