package com.bridgeconn.autographago.ui.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.widget.TextView;

import com.bridgeconn.autographago.BuildConfig;
import com.bridgeconn.autographago.R;
import com.bridgeconn.autographago.utils.SharedPrefs;
import com.bridgeconn.autographago.utils.UtilFunctions;

public class AboutPageActivity extends AppCompatActivity {

    private TextView tvAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(SharedPrefs.getFontSize().getResId(), true);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_page);

        UtilFunctions.applyReadingMode();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        tvAboutUs = (TextView) findViewById(R.id.tv_about_us);

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Spannable spannable1 = new SpannableString(getResources().getString(R.string.the_autographa_project));
        spannable1.setSpan(new StyleSpan(Typeface.BOLD), 0, spannable1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable spannable2 = new SpannableString(getResources().getString(R.string.about_us_1));
        Spannable spannable3 = new SpannableString(getResources().getString(R.string.autographa_go));
        spannable3.setSpan(new StyleSpan(Typeface.BOLD), 0, spannable3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable spannable4 = new SpannableString(getResources().getString(R.string.about_us_2));
        Spannable spannable5 = new SpannableString(getResources().getString(R.string.website));
        spannable5.setSpan(new StyleSpan(Typeface.BOLD), 0, spannable5.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable spannable6 = new SpannableString(getResources().getString(R.string.about_us_3));
        Spannable spannable7 = new SpannableString(getResources().getString(R.string.autographa_team));
        spannable7.setSpan(new StyleSpan(Typeface.BOLD), 0, spannable7.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable spannable8 = new SpannableString(getResources().getString(R.string.about_us_4));
        Spannable spannable9 = new SpannableString(getResources().getString(R.string.about_us_5));

        spannableStringBuilder.append(getResources().getString(R.string.version));
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(BuildConfig.VERSION_NAME);
        spannableStringBuilder.append("\n\n");
        spannableStringBuilder.append(spannable1);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(spannable2);
        spannableStringBuilder.append(spannable3);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(spannable4);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(spannable5);
        spannableStringBuilder.append(spannable9);
        spannableStringBuilder.append(spannable6);
        spannableStringBuilder.append(spannable7);
        spannableStringBuilder.append(spannable8);

        tvAboutUs.setText(spannableStringBuilder);
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
}
