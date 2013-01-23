
package com.my.listviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final ListView listView = (ListView) findViewById(R.id.mylist);
        final String[] values = new String[] {"Black", "White", "Red", "Green", "Blue"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,
                android.R.id.text1, values);
        
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        
        Button btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SparseBooleanArray checked = listView.getCheckedItemPositions();
                     
                String str =  checked.size() + " | ";
                for (int i=0;i<checked.size();i++) {
                    if(checked.get(checked.keyAt(i)))
                        str += values[i] + ",";
                }
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
        });
        
    }

}
