package com.shendu.userbook;

import com.shendu.userbook.adapter.MobileFuntionAdapter;
import com.shendu.userbook.json.CreateJsonUtill;
import com.shendu.userbook.json.JsonUtill;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

public class UserBookActivity extends Activity{
	MobileFuntionAdapter mFuncAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_book);
		GridView gridview = (GridView) findViewById(R.id.user_book_gridview);
		CreateJsonUtill cju = new CreateJsonUtill(getApplicationContext());
		mFuncAdapter = new MobileFuntionAdapter(UserBookActivity.this,
				JsonUtill.getFuntionInfo(cju.getFunctionInfo(),UserBookActivity.this));
		gridview.setAdapter(mFuncAdapter);
		getFragmentManager().addOnBackStackChangedListener(
				new OnBackStackChangedListener() {
					@Override
					public void onBackStackChanged() {
						if (getFragmentManager().getBackStackEntryCount() == 0) {
							ActionBar ab = getActionBar();
							ab.setDisplayHomeAsUpEnabled(false);
							ab.setLogo(R.drawable.ic_launcher);
							ab.setTitle(R.string.app_name);
							ab.setHomeButtonEnabled(false);
						}

					}
				});
	}
}
