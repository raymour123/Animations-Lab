package generalassembly.yuliyakaleda.startercode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  EditText editText;
  Button button;
  TextView textView;
  ListView listView;
  ArrayList<String> arrayList;
  BaseAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: set up all the view and event listeners.

    editText = (EditText) findViewById(R.id.edittext);
    button = (Button) findViewById(R.id.button);
    textView = (TextView) findViewById(R.id.textview);
    listView = (ListView) findViewById(R.id.listview);
    arrayList = new ArrayList<>();

    adapter = new BaseAdapter() {
      @Override
      public int getCount() {
        return arrayList.size();
      }

      @Override
      public Object getItem(int position) {
        return arrayList.get(position);
      }

      @Override
      public long getItemId(int position) {
        return position;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
          view = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView text = (TextView) view.findViewById(android.R.id.text1);
        text.setText(arrayList.get(position));
        return view;
      }
    };

    listView.setAdapter(adapter);

    button.setOnClickListener(this);




  }

  @Override
  public void onClick(View v) {
    // TODO: 1. get the text from the input field
    //       2. animate it in the center of the screen
    //       3. add it to the arrayList wish
    //       4. clear the input field

    if (editText.getText().toString().trim().length() == 0) {
      editText.setError("Please make a request");
    } else {
      String wish = editText.getText().toString().trim();

      arrayList.add(0, wish);

      textView.setText(wish);
      Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation);
      textView.startAnimation(animation);

      adapter.notifyDataSetChanged();
      editText.setText("");
    }


  }
}
