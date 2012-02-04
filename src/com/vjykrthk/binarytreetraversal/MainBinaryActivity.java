package com.vjykrthk.binarytreetraversal;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainBinaryActivity extends Activity {
	EditText editTarget;
	EditText editCol1;
	EditText editCol2;
	EditText editCol3;

	Button target_button;
	Button col1_button;
	Button col2_button;
	Button col3_button;
	protected int targetValue;
	protected final int requestCodeActivity1 = 1;
	protected final int requestCodeActivity2 = 2;
	protected final int requestCodeActivity3 = 3;
	private BinaryTreeOuter binaryTreeOuter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		binaryTreeOuter = new BinaryTreeOuter(this);
		wireUptoUi();
		target_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!editTarget.getText().toString().equals("")) {
					targetValue = (int) Long.parseLong(editTarget.getText()
							.toString());
					binaryTreeOuter = new BinaryTreeOuter(MainBinaryActivity.this);
					editTarget.setText("Target is " + targetValue);
					editCol1.setText("");
					editCol2.setText("");
					editCol3.setText("");
				}

			}
		});

		col1_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainBinaryActivity.this,
						Activity1.class);
				Bundle bundle = new Bundle();
				bundle.putLong("targetValue", targetValue);
				intent.putExtras(bundle);
				startActivityForResult(intent, requestCodeActivity1);	
			}
		});
		
		col2_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainBinaryActivity.this,
						Activity2.class);
				Bundle bundle = new Bundle();
				bundle.putLong("targetValue", targetValue);
				intent.putExtras(bundle);
				startActivityForResult(intent, requestCodeActivity2);				// TODO Auto-generated method stub
		}
		});
		
		col3_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainBinaryActivity.this,
						Activity3.class);
				Bundle bundle = new Bundle();
				bundle.putLong("targetValue", targetValue);
				intent.putExtras(bundle);
				startActivityForResult(intent, requestCodeActivity3);				// TODO Auto-generated method stub
		}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (resultCode == Activity.RESULT_OK) {
			Bundle bundle = data.getExtras();
			boolean found = bundle.getBoolean("found");
			Long reachedNodeValue = bundle.getLong("reachedValue");
			switch (requestCode) {
			case requestCodeActivity1:
				if (found) {
					editCol1.setText("Reached target node");
				} else {
					editCol1.setText("Reached node " + reachedNodeValue);
				}
				break;
			case requestCodeActivity2:
				if (found) {
					editCol2.setText("Reached target node");
				} else {
					editCol2.setText("Reached node " + reachedNodeValue);
				}
				break;
			case requestCodeActivity3:
				if (found) {
					editCol3.setText("Reached target node");
				} else {
					editCol3.setText("Reached node " + reachedNodeValue);
				}
				break;
			default:
				break;
			}
		} else if (requestCode == Activity.RESULT_CANCELED) {
			switch (requestCode) {
			case requestCodeActivity1:
				editCol1.setText("Target not found");
				break;
			case requestCodeActivity2:
				editCol2.setText("Target not found");
				break;
			case requestCodeActivity3:
				editCol3.setText("Target not found");
				break;
			default:
				break;
			}
		}
	}

	private void wireUptoUi() {
		editTarget = (EditText) findViewById(R.id.editTarget);
		editCol1 = (EditText) findViewById(R.id.editCol1);
		editCol2 = (EditText) findViewById(R.id.editCol2);
		editCol3 = (EditText) findViewById(R.id.editCol3);

		target_button = (Button) findViewById(R.id.target_button_id);
		col1_button = (Button) findViewById(R.id.col1_button_id);
		col2_button = (Button) findViewById(R.id.col2_button_id);
		col3_button = (Button) findViewById(R.id.col3_button_id);
	}
}