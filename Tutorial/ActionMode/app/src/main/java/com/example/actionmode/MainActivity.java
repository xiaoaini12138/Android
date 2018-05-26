package com.example.actionmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String[] number = new String[]{"One","Two","Three","Fore","Five","Six","Seven","Nine","Ten"};
    ListView L;
    ArrayList<Integer>Ay = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int j = 0;j<5;j++){
            Ay.add(0);
        }
        L = (ListView)findViewById(R.id.listView1);
        final List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i = 0;i<number.length;i++){
            Map<String,Object>showItem=new HashMap<>();
            showItem.put("number",number[i]);
            list.add(showItem);
        }
        final SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.list_layout,new String[]{"number"},new int[]{R.id.number});
        L.setAdapter(simpleAdapter);
        L.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        L.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                if(b){
                    Log.d("TAG","The position is "+i);
                    Ay.set(i,1);
                    Log.d("TAG","the checklist value in "+i+"is "+Ay.get(i));
                }else {
                    Log.d("TAG","The position is "+i);
                    Ay.set(i,0);
                    Log.d("TAG","the checklist value in "+i+"is "+Ay.get(i));
                }
                actionMode.setSubtitle(L.getCheckedItemCount()+" selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

                MenuInflater inflater=actionMode.getMenuInflater();
                inflater.inflate(R.menu.action_mode,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_delete:
                        for(int i=Ay.size()-1;i>=0;i--){
                            if(Ay.get(i)==1){
                                list.remove(i);
                                Ay.remove(i);
                                simpleAdapter.notifyDataSetChanged();
                                actionMode.finish();
                            }
                        }
                        break;
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });
    }
}
