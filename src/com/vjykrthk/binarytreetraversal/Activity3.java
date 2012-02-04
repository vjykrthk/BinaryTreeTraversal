package com.vjykrthk.binarytreetraversal;

import com.vjykrthk.binarytreetraversal.BinaryTreeOuter.Node;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Activity3 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent calledIntent = getIntent();
		Bundle bundle = calledIntent.getExtras();
		Long targetValue = bundle.getLong("targetValue");

		Node reachedNode = BinaryTreeOuter.Node.traverse(targetValue);
		// Log.d(tag, "onCreate : targetValue - " + targetValue + " reached - "
		// + reachedNode.nodeValue());
		if (reachedNode == null) {
			setResult(Activity.RESULT_CANCELED);
		} else {
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
