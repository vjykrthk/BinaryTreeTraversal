package com.vjykrthk.binarytreetraversal;

import com.vjykrthk.binarytreetraversal.BinaryTreeOuter.Node;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Activity1 extends Activity {

	private String tag = "ActivityOne";

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent calledIntent = getIntent();
		Bundle bundle = calledIntent.getExtras();
		Long targetValue = bundle.getLong("targetValue");

		Node reachedNode = BinaryTreeOuter.Node.traverse(targetValue);

		if (reachedNode == null) {
			Log.d(tag, "onCreate : ReachedNode - null");
			setResult(Activity.RESULT_CANCELED);
		} else {
			Log.d(tag, "onCreate : targetValue - " + targetValue
					+ " reached - " + reachedNode.nodeValue());			
			Intent intent = new Intent();
			Bundle rbundle = new Bundle();
			if (reachedNode.nodeValue() == targetValue) {
				rbundle.putBoolean("found", true);
				rbundle.putLong("reachedValue", reachedNode.nodeValue());
			} else {
				rbundle.putBoolean("found", false);
				rbundle.putLong("reachedValue", reachedNode.nodeValue());
			}
			intent.putExtras(rbundle);
			setResult(Activity.RESULT_OK, intent);

		}
		finish();
	};

}
